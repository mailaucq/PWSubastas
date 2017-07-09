package com.subastas.client;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.jboss.resteasy.util.Base64;
import com.subastas.domain.dao.UsuariosDAO;
import com.subastas.domain.dao.UsuariosDAOImpl;
import com.subastas.domain.to.Usuario;
import javax.ws.rs.core.Response.Status;

@Provider
@ServerInterceptor
public class BasicAuthentication implements PreProcessInterceptor {

	private UsuariosDAO dao = new UsuariosDAOImpl();
	private static String AUTHORIZATION_PROPERTY = "Authorization";
	private static String AUTHENTICATION_SCHEME = "Basic";
	private static ServerResponse ACCESS_DENIED = new ServerResponse(
			"Access denied", 401, new Headers<Object>());;
	private static ServerResponse ACCESS_FORBIDDEN = new ServerResponse(
			"No access", 403, new Headers<Object>());;
	private static ServerResponse SERVER_ERROR = new ServerResponse(
			"Server error", 500, new Headers<Object>());;

	@Override
	public ServerResponse preProcess(HttpRequest request,
			ResourceMethod methodInvoked) throws Failure,
			WebApplicationException {
		Method method = methodInvoked.getMethod();

		if (method.isAnnotationPresent(PermitAll.class))
			return null;

		if (method.isAnnotationPresent(DenyAll.class))
			return ACCESS_FORBIDDEN;

		final HttpHeaders headers = request.getHttpHeaders();

		final List<String> authorization = headers
				.getRequestHeader(AUTHORIZATION_PROPERTY);

		if (authorization == null || authorization.isEmpty())
			return ACCESS_DENIED;

		final String encodedUserPassword = authorization.get(0).replaceFirst(
				AUTHENTICATION_SCHEME + " ", "");

		String usernameAndPassword;
		try {
			usernameAndPassword = new String(Base64.decode(encodedUserPassword));
		} catch (IOException e) {
			return SERVER_ERROR;
		}

		final StringTokenizer stringTokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = stringTokenizer.nextToken();
		final String password = stringTokenizer.nextToken();

		if (method.isAnnotationPresent(RolesAllowed.class)) {
			RolesAllowed rolesAnnotation = method
					.getAnnotation(RolesAllowed.class);
			Set<String> rolesSet = new HashSet<String>(
					Arrays.asList(rolesAnnotation.value()));

			if (!validate(username, password, rolesSet))
				return ACCESS_DENIED;
		}

		return null;
	}

	private boolean validate(final String nombreUsuario,
			final String claveUsuario, final Set<String> rolesSet) {
		boolean isAllowed = false;
		Usuario usuario = null;
		try {
			usuario = dao.findByNamedQuery("Usuario.findByUsuarioNombre",
					nombreUsuario).get(0);
		} catch (Exception e) {
			System.err.println("Not Found");
		}
		boolean isValid = usuario != null
				&& usuario.getUsuarioPassword().equals(claveUsuario);
		System.out.println("is valid: " + isValid);
		String rol = "ADMIN";
		isAllowed = rolesSet.contains(rol) && isValid;
		System.out.println("is allowed: " + isAllowed);
		return isAllowed;
	}

}

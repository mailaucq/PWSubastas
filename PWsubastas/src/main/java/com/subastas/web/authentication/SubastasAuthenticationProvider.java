package com.subastas.web.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;

import com.subastas.domain.to.Usuario;
import com.subastas.service.UsuarioService;

@Component
public class SubastasAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
    private UsuarioService usuarioService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        Usuario usuario = usuarioService.validarUsuario(name, password);
        
        if (usuario == null) {
        	throw new BadCredentialsException("Usuario no existe.");
        }
        
        if (!password.equals(usuario.getUsuarioPassword())) {
            throw new BadCredentialsException("Contraseña incorrecta.");
        }
        
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl("ROLE_USER")); 
        
		return new UsernamePasswordAuthenticationToken(name, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
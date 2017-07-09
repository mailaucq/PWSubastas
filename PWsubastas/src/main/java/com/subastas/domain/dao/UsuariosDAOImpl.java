package com.subastas.domain.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.subastas.domain.to.Usuario;

@Component("usuarioDAO")
public class UsuariosDAOImpl extends GenericDAOImpl<Usuario,BigDecimal> implements UsuariosDAO {
}

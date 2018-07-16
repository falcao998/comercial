package com.sys.automacao.comercial.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.automacao.comercial.dao.repository.UsuarioRepository;
import com.sys.automacao.comercial.model.Usuario;

@Service
public class UsuarioDaoService {

	@Autowired
	UsuarioRepository repository;
	
	public Usuario login(String user, String senha) {
		Usuario usuario = repository.findByUserAndSenha(user,senha);
		return usuario == null ? null : usuario;
	}
	
	public Usuario loginAtivo(String user, String senha) {
		Usuario usuario = repository.findByUserAndSenhaAndStatus(user,	senha, "ATIVO");
		return usuario == null ? null : usuario;
	}
	
	public Usuario loginInativo(String user, String senha) {
		return repository.findByUserAndSenhaAndStatus(user,	senha, "INATIVO");
	}
}
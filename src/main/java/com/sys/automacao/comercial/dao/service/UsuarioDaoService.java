package com.sys.automacao.comercial.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.automacao.comercial.dao.repository.UsuarioRepository;
import com.sys.automacao.comercial.model.Usuario;

@Service
public class UsuarioDaoService {

	@Autowired
	UsuarioRepository repository;
	
	public Usuario permissao(String user, String senha) {
		return repository.findByUserAndSenha(user,senha);
	}
}
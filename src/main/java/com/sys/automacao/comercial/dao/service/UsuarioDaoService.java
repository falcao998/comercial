package com.sys.automacao.comercial.dao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sys.automacao.comercial.dao.repository.UsuarioRepository;
import com.sys.automacao.comercial.dao.specification.UsuarioSpecification;
import com.sys.automacao.comercial.model.Usuario;

@Service
public class UsuarioDaoService {

	@Autowired
	UsuarioRepository repository;
	
	public Optional<Usuario> permissao(String user, String senha) {
		return repository.findOne(Specification.where(UsuarioSpecification.user(user)).and(UsuarioSpecification.senha(senha)));
	}
	
	//Teste alterenativo
	public Usuario permissao2(String user, String senha) {
		return repository.findByUserAndSenha(user,senha);
	}
}
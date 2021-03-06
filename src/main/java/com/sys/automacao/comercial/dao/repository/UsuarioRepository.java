package com.sys.automacao.comercial.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sys.automacao.comercial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, JpaSpecificationExecutor<Usuario> {
	
	public Usuario findByUserAndSenha(String user,String senha);
	public Usuario findByUserAndSenhaAndStatus(String user,String senha,String status);
}

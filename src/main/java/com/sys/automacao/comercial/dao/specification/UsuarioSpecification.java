package com.sys.automacao.comercial.dao.specification;

import org.springframework.data.jpa.domain.Specification;

import com.sys.automacao.comercial.model.Usuario;
import com.sys.automacao.comercial.model.Usuario_;

public class UsuarioSpecification {

	public static Specification<Usuario> nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(Usuario_.nome), nome);
	}
	
	public static Specification<Usuario> user(String user) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(Usuario_.user), user);
	}
	
	public static Specification<Usuario> senha(String senha) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(Usuario_.senha), senha);
	}
}

package com.sys.automacao.comercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.automacao.comercial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

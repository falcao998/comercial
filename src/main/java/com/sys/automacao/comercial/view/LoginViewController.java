package com.sys.automacao.comercial.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sys.automacao.comercial.repository.UsuarioRepository;

import javafx.fxml.FXML;

@Component
public class LoginViewController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@FXML
	public void handleSair() {
		System.exit(0);
	}
	
	@FXML
	public void handleLogin() {
		System.out.println(repository.findById(1).get().getNome());
	}
}

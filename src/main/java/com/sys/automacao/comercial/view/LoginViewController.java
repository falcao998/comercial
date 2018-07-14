package com.sys.automacao.comercial.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.repository.UsuarioRepository;

import javafx.fxml.FXML;

@Component
public class LoginViewController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@FXML
	private JFXTextField tfUsuario;
	
	@FXML
	private JFXPasswordField pfSenha;
	
	@FXML
	public void handleSair() {
		System.exit(0);
	}
	
	@FXML
	public void handleLogin() {
		// Not used
	}
}

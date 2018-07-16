package com.sys.automacao.comercial.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.repository.UsuarioRepository;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;

import javafx.fxml.FXML;

@Component
public class LoginViewController {
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private UsuarioDaoService service;
	
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
		if(tfUsuario.getText().trim().isEmpty())
			System.out.println(service.permissao(tfUsuario.getText(), pfSenha.getText()).get().getNome());
	}
}

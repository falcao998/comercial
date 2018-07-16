package com.sys.automacao.comercial.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Component
public class LoginViewController {
	
	@Autowired
	private UsuarioDaoService service;
	
	@FXML
	private JFXTextField tfUsuario;
	
	@FXML
	private JFXPasswordField pfSenha;
	
	@FXML
	private Label lErroUsuario, lErroSenha, lInativoUsuario;
	
	@FXML
	public void handleSair() {
		System.exit(0);
	}
	
	@FXML
	public void handleLogin() {
		testeEmptyUsuarioSenha();
		System.out.println(service.permissao(tfUsuario.getText(), pfSenha.getText()));
	}
	
	@FXML
	public void handleDigitar() {
		testeEmptyUsuarioSenha();
	}
	
	private void testeEmptyUsuarioSenha() {
//		tfUsuario.getText().trim().isEmpty() ? lErroUsuario.setVisible(true) : lErroUsuario.setVisible(false));
//		pfSenha.getText().trim().isEmpty() ? lErroSenha.setVisible(true) : lErroSenha.setVisible(false));
	}
}

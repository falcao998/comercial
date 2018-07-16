package com.sys.automacao.comercial.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Usuario;

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
	private Label lUsuarioEmpty, lSenhaEmpty, lUsuarioError;
	
	@FXML
	public void handleSair() {
		System.exit(0);
	}
	
	@FXML
	public void handleLogin() {
		if (testeEmptyUsuarioSenha()) {
			Usuario usuario = service.loginAtivo(tfUsuario.getText(), pfSenha.getText());
			if (usuario == null)
				showMenssagemError();
			else
				testeEmptyUsuarioSenha();
		}
	}
	
	@FXML
	public void handleDigitar() {
		testeEmptyUsuarioSenha();
	}
	
	private boolean testeEmptyUsuarioSenha() {
		
		boolean teste = true;
		
		lUsuarioError.setVisible(false);
		lUsuarioEmpty.setVisible(false);
		lSenhaEmpty.setVisible(false);
		
		if (tfUsuario.getText().trim().isEmpty()) {
			teste = false;
			lUsuarioEmpty.setVisible(true);
		}
		if (pfSenha.getText().trim().isEmpty()) {
			teste = false;
			lSenhaEmpty.setVisible(true);
		}
		
		return teste;
	}
	
	private void showMenssagemError() {
		lUsuarioError.setVisible(true);
	}
	
}

package com.sys.automacao.comercial.view;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Usuario;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@Component
public class LoginViewController {
	
	@Autowired
	private UsuarioDaoService service;
	
	@Autowired
	private ExchangeStage exchangeStage;
	
	@FXML
	private AnchorPane anchorPaneLogin;
	
	@FXML
	private JFXTextField tfUsuario;
	
	@FXML
	private JFXPasswordField pfSenha;
	
	@FXML
	private Label lUsuarioEmpty;
	
	@FXML
	private Label lSenhaEmpty;
	
	@FXML
	private Label lUsuarioError;
	
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
				sucessLogin();
		}
	}
	
	@FXML
	public void handleDigitarUsuario() {
		testeUsuarioEmpty(true);
	}
	
	@FXML
	public void handleDigitarSenha() {
		testeSenhaEmpty(true);
	}
	
	public void sucessLogin() {
		exchangeStage.exchange("/view/Principal.fxml", StageStyle.DECORATED, anchorPaneLogin);
		/*try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Principal.fxml"));
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			Stage login = (Stage)anchorPaneLogin.getScene().getWindow();
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			login.close();
			stage.show();
		}catch(IOException e) {}*/
	}
	
	private boolean testeUsuarioEmpty(boolean teste) {
		lUsuarioEmpty.setVisible(false);
		if (tfUsuario.getText().trim().isEmpty()) {
			teste = false;
			lUsuarioEmpty.setVisible(true);
		}
		return teste;
	}
	
	private boolean testeSenhaEmpty(boolean teste) {
		lSenhaEmpty.setVisible(false);
		if (pfSenha.getText().trim().isEmpty()) {
			teste = false;
			lSenhaEmpty.setVisible(true);
		}
		return teste;
	}
	
	private boolean testeEmptyUsuarioSenha() {
		boolean teste = true;
		
		lUsuarioError.setVisible(false);
		
		teste = testeUsuarioEmpty(teste);
		teste = testeSenhaEmpty(teste);
		
		return teste;
	}
	
	private void showMenssagemError() {
		lUsuarioError.setVisible(true);
	}
	
}
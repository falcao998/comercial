package com.sys.automacao.comercial.view;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@Component
public class PrincipalViewController {
	
	@Autowired
	ExchangeStage exchangeStage;

	@FXML
	public void sair() {
		System.exit(0);
	}
	
	@FXML
	public void trocarUsuario() {
		exchangeStage.exchange("Login.fxml", StageStyle.UNDECORATED, new Pane());
		/*try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			Stage login = (Stage)anchorPaneLogin.getScene().getWindow();
			Stage stage = new Stage(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			login.close();
			stage.show();
		}catch(IOException e) {}*/
	}
}

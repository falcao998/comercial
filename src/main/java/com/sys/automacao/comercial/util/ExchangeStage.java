package com.sys.automacao.comercial.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@Component
public class ExchangeStage {

	public void exchange(String screenName, StageStyle style, Pane pane) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(screenName));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage login = (Stage)pane.getScene().getWindow();
			Stage stage = new Stage(style);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			login.close();
			stage.show();
		}catch(IOException e) {}
	}
}
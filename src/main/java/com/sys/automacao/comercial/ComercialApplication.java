package com.sys.automacao.comercial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class ComercialApplication extends Application {
	
	private ConfigurableApplicationContext springContext;
    private Parent root;
	
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(ComercialApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/Login.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SYS - AUTOMAÇÃO COMERCIAL");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		springContext.stop();
	}
	
	public static void main(String[] args) {
		launch(ComercialApplication.class,args);
	}
}
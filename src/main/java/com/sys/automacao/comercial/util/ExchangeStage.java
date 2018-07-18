package com.sys.automacao.comercial.util;

import java.io.IOException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sys.automacao.comercial.view.LoginViewController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@Component
public class ExchangeStage {
	
	/*private FXMLLoader fxmlLoader;
	private URL resource;
	public static final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);*/
	
	private ConfigurableApplicationContext springContext;
	private ApplicationContext context;
//    private Parent root;

	public void exchange(String screenName, StageStyle style, Pane pane, boolean maximezed) {
		try {
			springContext = new AnnotationConfigApplicationContext(SpringApplication.class);
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(screenName));
			fxmlLoader.setControllerFactory(springContext::getBean);
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage login = (Stage)pane.getScene().getWindow();
			login.close();
			Stage stage = new Stage(style);
			stage.setScene(scene);
			stage.centerOnScreen();
			if(maximezed) {
				stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
				stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			}
			stage.show();
		}catch(IOException e) {}
	}
	
	/*private Object createControllerForType(Class<?> type) {
	    return this.applicationContext.getBean(type);
	}

	private FXMLLoader loadSynchronously(URL resource) throws IllegalStateException {

	    FXMLLoader loader = new FXMLLoader(resource);
	    loader.setControllerFactory(this::createControllerForType);

	    try {
	        loader.load();
	    } catch (IOException ex) {
	        throw new IllegalStateException("Cannot load Resource!", ex);
	    }

	    return loader;
	}

	private void initializeFxmlLoader() {
	    this.fxmlLoader = loadSynchronously(resource);
	    this.presenterProperty.set(this.fxmlLoader.getController());
	}

	public void setResource (String resource) {
	    this.resource = getClass().getResource(resource);
	}

	public Parent getView(String resource) {
		setResource(resource);
	    initializeFxmlLoader();

	    Parent parent = fxmlLoader.getRoot();
	    return parent;
	}*/
}
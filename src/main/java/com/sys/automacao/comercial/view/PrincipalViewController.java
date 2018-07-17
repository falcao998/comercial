package com.sys.automacao.comercial.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

@Component
public class PrincipalViewController {
	
	@Autowired
	private ExchangeStage exchangeStage;
	
	@FXML
	private BorderPane borderPanePrincipal;

	@FXML
	public void handleSair() {
		System.exit(0);
	}
	
	@FXML
	public void hadlerTrocarUsuario() {
		sairTela();
	}
	
	public void sairTela() {
		exchangeStage.exchange("../view/Login.fxml", StageStyle.UNDECORATED, borderPanePrincipal);
	}
}

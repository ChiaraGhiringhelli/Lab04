package it.polito.tdp.lab04.controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SegreteriaStudentiController {

	private Model m = new Model();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Corso> menuCorsi;

	@FXML
	private Button btnCercaIscritti;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private ImageView btnImmagine;

	@FXML
	private TextField txtCognome;

	@FXML
	void doCercaMatricola(ActionEvent event) {

		int matr = Integer.parseInt(txtMatricola.getText());
		
		if( m.getNomeCognomePerMatricola(matr) == null) {
			
			txtResult.setText("Non esiste la matricola che hai messo.");
			
		}
		
		else {
			
			String array[] = m.getNomeCognomePerMatricola(matr).split(" ");
			String cognome = array[0];
			String nome = array[1];
			
			txtCognome.setText(cognome);
			txtNome.setText(nome);
			
		}
	}
		
	

	@FXML
	void doCercaCorsi(ActionEvent event) {
		
		if( txtMatricola.getText() == null ) {
			txtResult.setText("Non hai messo nessuna matricola, idiot");
		}
		
		else {
			
			int matricola = Integer.parseInt(txtMatricola.getText());
			List<Corso> lista = m.getCorsiStudente(matricola);
			String ris = null;
			
			txtResult.setText("I corsi a cui è iscritto lo studente sono:\n");
			
			if( lista.isEmpty() == true ) {
				
				txtResult.setText("Nessuno, è una capra");
			}
			
			for( Corso c: lista) {
				ris = c.toString();
				txtResult.setText(ris);
			}
		}
	}

	@FXML
	void doCercaIscritti(ActionEvent event) {

		Corso corso = menuCorsi.getValue();
		
		if( corso == null ) {
			txtResult.appendText("Non hai selezionato nessun corso.");
			
		}
		List<Studente> lista = m.listaStudentiDelCorso(corso);

		for (Studente s : lista) {

			txtResult.appendText(s.getDettagliStudente());

		}

	}

	@FXML
	void doIscrivi(ActionEvent event) {
		
		int matricola = Integer.parseInt(txtMatricola.getText());
		//this.doCercaMatricola(matricola);
		
		for( Studente s : m.listaStudenti1()) {
			
			if(s.getMatricola() == matricola ) {
				
				
			}
			
		}
		

	}

	@FXML
	void doReset(ActionEvent event) {

		txtResult.clear();
		txtNome.clear();
		txtCognome.clear();
		txtMatricola.clear();

	}

	@FXML
	void initialize() {
		assert menuCorsi != null : "fx:id=\"menuCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnImmagine != null : "fx:id=\"btnImmagine\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

	}

	public void setModel(Model m) {
		this.m = m;

		menuCorsi.getItems().addAll(m.listaCorsi());

	}

}

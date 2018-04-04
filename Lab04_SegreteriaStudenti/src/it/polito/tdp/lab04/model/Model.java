package it.polito.tdp.lab04.model;

import java.util.List;
import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private List<Corso> corsi;
	private List<Studente> studenti;
	private CorsoDAO corsoDAO = null;
	private StudenteDAO studenteDAO = null;
	private List<Studente> studente;
	
	public Model() {
		
		corsoDAO = new CorsoDAO();
		studenteDAO = new StudenteDAO();
	
	}
	
	public List<Corso> listaCorsi() {
		// Carico una sola volta tutti i corsi
		// sfruttando un meccanismo di cache
		
		if (this.corsi == null)
			this.corsi = corsoDAO.getTuttiICorsi();
		return this.corsi;
	}
	
	public List<Studente> listaStudentiDelCorso(Corso corso) {
		
		if (this.studenti == null)
			this.studenti = corsoDAO.getStudentiIscrittiAlCorso(corso);
		return this.studenti;
	}
	
	public List<Studente> listaStudenti1( ) {
		if (this.studente == null)
			this.studente = studenteDAO.listaStudentiTotali();
		return studente;
		
	}
	
	public List<Corso> getCorsiStudente( int matricola ) {
		StudenteDAO s = new StudenteDAO();
		return s.getCorsiStudente(matricola);
		
	}

	
	public String getNomeCognomePerMatricola(int matricola) {
		
		Studente s = studenteDAO.getStudentePerMatricola(matricola);
		
		return s.getCognome()+" "+ s.getNome() ;
	}

}

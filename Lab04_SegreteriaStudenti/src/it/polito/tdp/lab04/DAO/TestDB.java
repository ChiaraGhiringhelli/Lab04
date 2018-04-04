package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Model;

public class TestDB {

	public static void main(String[] args) {
		
		/*
		 * 	This is a main to check the DB connection
		 */
		
		Model m = new Model();
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		int matricola = 146101;
		String result = m.getNomeCognomePerMatricola(matricola);
		System.out.println(result);

	}

}

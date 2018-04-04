package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> listaStudentiTotali() {
		
		List<Studente> lista = new LinkedList<Studente>();
		 
		final String sql = "SELECT * FROM studente";

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");
				
				Studente s1 = new Studente(matricola, cognome, nome, cds);
				System.out.println(s1.toString());
				
				lista.add(s1);
				
			}

			conn.close();
			
		} catch (SQLException e) {
		 
			e.printStackTrace();
		 
		}
		
		return lista ;
		
	}
	
	public boolean iscriviStudente(Corso corso) {
		
		/*List<Corso> listaCorsi = new LinkedList<Corso>();
		boolean iscritto = false;
		
		for(Corso c : listaCorsi) {
			
			if( c.getCodiceInsegnante().compareTo(corso.getCodiceInsegnante()) == 0 ) {
				iscritto = false;
			}
			
		}*/
		
		return true;
		
	}

	public List<Corso> getCorsiStudente( int matricola ) {
		
			final String sql = "SELECT * FROM iscrizione as i, corso as c WHERE i.cod";
			Corso c = null;
			
			try {
				
				Connection conn1 = ConnectDB.getConnection();
				PreparedStatement st1 = conn1.prepareStatement(sql);
				
				st1.setInt(1, matricola);
				
				ResultSet rs = st1.executeQuery();

				while (rs.next()) {

					
					//c = new Corso(codins, crediti, nomeCorso, periodo);
				}

				conn1.close();
				
			} catch (SQLException e) {
			 
				e.printStackTrace();
			 
			}
			
		
		
		return null;
	}

	public Studente getStudentePerMatricola(int matricola) {
		
		final String sql = "SELECT matricola, nome, cognome, CDS FROM studente WHERE matricola = ?";

		Studente s = null;
		
		try {
			
			Connection conn1 = ConnectDB.getConnection();
			PreparedStatement st1 = conn1.prepareStatement(sql);
			
			st1.setInt(1, matricola);
			
			ResultSet rs = st1.executeQuery();

			if (rs.next()) {

				s = new Studente(matricola, rs.getString("cognome"), rs.getString("nome"), rs.getString("cds") );
				
			}

			conn1.close();
			
		} catch (SQLException e) {
		 
			e.printStackTrace();
		 
		}
		
		
		return s;
	}
	
	
}

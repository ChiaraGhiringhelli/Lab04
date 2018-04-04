package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				// Crea un nuovo JAVA Bean Corso
				Corso corso = new Corso( codins, periodoDidattico, nome, numeroCrediti);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(corso);
				
			}

		conn.close();
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
		return corsi;
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	
	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		
		List<Studente> studenti = new LinkedList<Studente>();
		final String sql = "SELECT * FROM iscrizione as i , studente as s WHERE s.matricola = i.matricola and i.codins= ? ";

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, corso.getCodiceInsegnante());
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("cds");
				
				Studente s1 = new Studente(matricola, cognome, nome, cds);
				
				studenti.add(s1);
				
			}

			conn.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		
		}
		
		return studenti;
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	
	
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		
		boolean iscritto = false;
		
		
		
		
		
		
		
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	
	
}

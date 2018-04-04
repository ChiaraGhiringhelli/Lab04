package it.polito.tdp.lab04.model;

public class Corso {
	
	private String codiceInsegnante;
	private int crediti;
	private String nomeCorso;
	private int periodoD;
	
	public Corso(String codiceInsegnante, int crediti, String nomeCorso, int periodoD) {
		super();
		this.codiceInsegnante = codiceInsegnante;
		this.crediti = crediti;
		this.nomeCorso = nomeCorso;
		this.periodoD = periodoD;
	}

	public String getCodiceInsegnante() {
		return codiceInsegnante;
	}

	public void setCodiceInsegnante(String codiceInsegnate) {
		this.codiceInsegnante = codiceInsegnate;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getPeriodoD() {
		return periodoD;
	}

	public void setPeriodoD(int periodoD) {
		this.periodoD = periodoD;
	}

	@Override
	public String toString() {
		return crediti +" "+ nomeCorso +" "+ periodoD +" "+ codiceInsegnante;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceInsegnante == null) ? 0 : codiceInsegnante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codiceInsegnante == null) {
			if (other.codiceInsegnante != null)
				return false;
		} else if (!codiceInsegnante.equals(other.codiceInsegnante))
			return false;
		return true;
	}
	

}

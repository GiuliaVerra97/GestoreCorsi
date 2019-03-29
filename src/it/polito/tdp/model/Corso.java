package it.polito.tdp.model;

public class Corso {

	private String codis;
	private int crediti;
	private String nome;
	private int pd;
	
	
	
	public Corso(String codis, int crediti, String nome, int pd) {
		super();
		this.codis = codis;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}

	public String getCodis() {
		return codis;
	}

	public void setCodis(String codis) {
		this.codis = codis;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPd() {
		return pd;
	}

	public void setPd(int pd) {
		this.pd = pd;
	}

	@Override
	public String toString() {
		return String.format("Corso [codis=%s, crediti=%s, nome=%s, pd=%s]", codis, crediti, nome, pd);
	}

	
	
	// genero solo per codins
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codis == null) ? 0 : codis.hashCode());
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
		if (codis == null) {
			if (other.codis != null)
				return false;
		} else if (!codis.equals(other.codis))
			return false;
		return true;
	}

	
	
	
}

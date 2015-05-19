package com.ssn.team1.biblioteca1;

import java.io.Serializable;

public abstract class Membru extends UtilizatorSimplu implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String adresa;
	protected String cnp;

	public Membru(String numeUtilizator, String parola, String nume,
			String numarTelefon, String adresa, String cnp) {
		super(numeUtilizator, parola, nume, numarTelefon);
		this.adresa = adresa;
		this.cnp = cnp;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	@Override
	public String toString() {
		return super.toString() + "\nAdresa : " + this.adresa + "\nCNP : "
				+ this.cnp + "\n ";
	}

}

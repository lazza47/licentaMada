package com.lazarescu.licenta.biblioteca;

import java.io.Serializable;

public abstract class UtilizatorSimplu extends Utilizator implements
		Serializable {

	private static final long serialVersionUID = 1L;
	protected String nume;
	private String numarTelefon;

	public UtilizatorSimplu(String numeUtilizator, String parola) {
		super(numeUtilizator, parola);
	}

	public UtilizatorSimplu(String numeUtilizator, String parola, String nume,
			String numarTelefon) {
		super(numeUtilizator, parola);
		this.nume = nume;
		this.numarTelefon = numarTelefon;
	}

	public abstract boolean esteEligibilSaImprumute();

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getNumarTelefon() {
		return numarTelefon;
	}

	public void setNumarTelefon(String numarTelefon) {
		this.numarTelefon = numarTelefon;
	}

	@Override
	public String toString() {
		return super.toString() + "Nume : " + nume + "\nNumar telefon : "
				+ numarTelefon;
	}

}

package com.ssn.team1.biblioteca1;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Utilizator implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String numeUtilizator;
	protected String parola;

	public Utilizator(String numeUtilizator, String parola) {
		this.numeUtilizator = numeUtilizator;
		this.parola = parola;
	}

	public ArrayList<Carte> cautaCartiDupaTitlu(String titlu) {
		return Biblioteca.getInstance().getCartiDupaTitlu(titlu);
	}

	public ArrayList<Carte> cautaCartiDupaAutor(String autor) {
		return Biblioteca.getInstance().getCartiDupaAutor(autor);
	}

	public ArrayList<Carte> gasesteToateCartile() {
		return Biblioteca.getInstance().getToateCartile();
	}

	public String getNumeUtilizator() {
		return numeUtilizator;
	}

	public String getParola() {
		return parola;
	}

	@Override
	public String toString() {
		return "Nume utilizator :" + getNumeUtilizator() + "\nParola :"
				+ getParola() + "\n";
	}

	public void setParola(String parola) {
		this.parola = parola;
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void setNumeUtilizator(String numeUtilizator) {
		this.numeUtilizator = numeUtilizator;
	}

	public abstract void meniu();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeUtilizator == null) ? 0 : numeUtilizator.hashCode());
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
		Utilizator other = (Utilizator) obj;
		if (numeUtilizator == null) {
			if (other.numeUtilizator != null)
				return false;
		} else if (!numeUtilizator.equals(other.numeUtilizator))
			return false;
		return true;
	}

}

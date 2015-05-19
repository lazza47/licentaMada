package com.lazarescu.licenta.biblioteca;

import java.io.Serializable;

public class Validator implements Serializable {

	private static final long serialVersionUID = 1L;

	public static boolean suntEgale(Carte c, String titluCarte, String numeAutor) {
		if (eliminaSpatii(c.getAutor()).equals(eliminaSpatii(numeAutor))
				&& eliminaSpatii(c.getTitlu())
						.equals(eliminaSpatii(titluCarte))) {
			return true;
		} else {
			return false;
		}
	}

	private static String eliminaSpatii(String str) {
		return str.trim().replace(" ", "");
	}

	public static boolean stringulEsteGol(String string) {
		string = string.trim();
		if ("".equals(string)) {
			return true;
		}
		return false;
	}

	public static boolean esteCnpValid(String cnp) {
		if (cnp.length() == 13 && cnp.matches("[0-9]+")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esteNumeValid(String nume) {
		nume = nume.trim();
		if (nume.matches("[a-zA-Z ]+") && nume.length() >= 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esteNrExemplareInt(String numarExemplare) {
		numarExemplare = numarExemplare.trim();
		if (numarExemplare.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	public static boolean esteNumarTelefonValid(String numarTelefon) {
		numarTelefon = numarTelefon.trim();
		if (numarTelefon.matches("[0-9+]+") && numarTelefon.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esteAdresaValida(String adresa) {
		adresa = adresa.trim();
		if (adresa.length() > 4) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean existaUsername(String username) {
		return Biblioteca.getInstance().existaUsername(username);
	}

	public static boolean existaCarte(String titlu, String autor) {
		return Biblioteca.getInstance().existaCarte(titlu, autor);
	}

	public static boolean existaCNP(String cnp) {
		for (MembruInregistrat m : Biblioteca.getInstance()
				.getMembriiInregistrati()) {
			if (m.getCnp().equals(cnp)) {
				return true;
			}
		}
		return false;
	}

	public static boolean existaExemplarByID(String idExemplar) {
		for (Carte c : Biblioteca.getInstance().getCarti()) {
			for (Exemplar e : c.getExemplare()) {
				if (e.getIdUnic().equals(idExemplar)) {
					return true;
				}
			}
		}
		return false;
	}

}

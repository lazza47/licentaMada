package com.lazarescu.licenta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Carte implements Serializable {
	private static final long serialVersionUID = 1L;
	private String titlu;
	private String autor;
	private ArrayList<Exemplar> exemplare = new ArrayList<Exemplar>();

	public Carte(String titlu2, String numeAutor) {
		this.titlu = titlu2;
		this.autor = numeAutor;
	}

	public void adaugaNumarExemplare(String idExemplar) {
		// for (int i = 0; i < numarExemplare; i++) {
		// String id = titlu + "#" + autor + "/" + exemplare.size() + 1;
		getExemplare().add(new Exemplar(idExemplar, this.getTitlu()));
		// }
	}

	private boolean esteDisponibila() {
		for (Exemplar exemplar : getExemplare()) {
			if (exemplar.esteDisponibil()) {
				return true;
			}
		}
		return false;
	}

	public Exemplar getExemplarDisponibil() {
		for (Exemplar exemplar : getExemplare()) {
			if (exemplar.esteDisponibil()) {
				exemplar.setEsteImprumutat(true);
				return exemplar;
			}
		}

		return null;
	}

	public String getTitlu() {
		return titlu;
	}

	public String getAutor() {
		return autor;

	}

	// @Override
	// public String toString() {
	// String afisare;
	// String newLine = System.getProperty("line.separator");
	// afisare = "titlu: " + titlu + newLine + "autor: " + autor + newLine +
	// "disponibila: " + newLine;
	// if (esteDisponibila()) {
	// afisare += "DA";
	// } else {
	// afisare += "Data cand va fi disponibila: " +
	// getDataEliberarii().toString();
	// }
	// return afisare;
	// }

	@Override
	public String toString() {
		String disponibilitate = "";
		if (esteDisponibila()) {
			disponibilitate = "disponibila";
		} else {
			if (exemplare.isEmpty()) {
				disponibilitate = " momentan nu exista exemplare";
			} else {
				disponibilitate = "Nu este disponibila ";
				// + getDataEliberarii().toString();
			}

		}
		return "Carte [" + titlu + "-" + autor + "] (" + disponibilitate + ")";
	}

	@SuppressWarnings("unused")
	private Date getDataEliberarii() {
		Date dataEliberarii = getExemplare().get(0).getDataEliberarii();
		if (getExemplare().size() > 0) {
			for (int i = 1; i < getExemplare().size(); i++) {
				if ((dataEliberarii.compareTo(getExemplare().get(i)
						.getDataEliberarii())) > 0) {
					dataEliberarii = getExemplare().get(i).getDataEliberarii();
				}
			}
		}
		return dataEliberarii;
	}

	public ArrayList<Exemplar> getExemplare() {
		return exemplare;
	}

}

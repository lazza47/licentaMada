package com.lazarescu.licenta;

import java.io.Serializable;
import java.util.ArrayList;

public class MembruInregistrat extends Membru implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Exemplar> cartiImprumutate = new ArrayList<>();

	public MembruInregistrat(String numeUtilizator, String nume, String parola,
			String nrTel, String adresa, String cnp) {
		super(numeUtilizator, parola, nume, nrTel, adresa, cnp);

	}

	public void afiseazaIstoricOperatiuniPersonale() {
		Biblioteca.getInstance().afiseazaIstoricMembru(this);
	}

	@Override
	public void meniu() {
		MeniuMembruInregistrat.meniu();
	}

	public ArrayList<Exemplar> getCartiImprumutate() {
		return cartiImprumutate;
	}

	public void returneazaCarte(Exemplar exemplarImprumutat) {
		exemplarImprumutat.returneaza();
		cartiImprumutate.remove(exemplarImprumutat);
	}

	public void imprumutaCarte(Exemplar exemplarImprumutat) {
		Imprumut imp = new Imprumut(Biblioteca.getInstance().getExpireDate());
		exemplarImprumutat.imprumuta(imp);
		cartiImprumutate.add(exemplarImprumutat);
		Biblioteca.getInstance().addImprumut(this, imp);
		InterfataUtilizator.showMessage(" Cartea a fost imprumutata cu succes");
	}

	public Exemplar getExemplarImprumutatById(String idExemplar) {
		Exemplar exemplar = null;
		for (Exemplar e : cartiImprumutate) {
			if (e.getIdUnic().equals(idExemplar)) {
				exemplar = e;
			}
		}
		return exemplar;
	}

	public void afiseazaInformatii() {
		String afisare = this.toString() + "\n############################\n";
		String newLine = System.getProperty("line.separator");
		afisare += "Numarul de carti imprumutate :" + cartiImprumutate.size()
				+ newLine;
		for (Exemplar e : cartiImprumutate) {
			String numeCarte = e.getImprumut().getNumeCarte();
			afisare += "Numele cartii :" + numeCarte + newLine
					+ "Data la care trebuie returnata :"
					+ e.getDataEliberarii() + newLine
					+ "----------------------" + newLine;
		}

		InterfataUtilizator.showScrollableMessage(afisare);
		;
	}

	@Override
	public boolean esteEligibilSaImprumute() {
		for (Exemplar e : cartiImprumutate) {
			if (e.getImprumut().isTermenDepasit()) {
				InterfataUtilizator.showMessage(" ! Carti nereturnate la timp");
				return false;
			}
		}
		if (cartiImprumutate.size() > 2) {
			InterfataUtilizator.showMessage(" ! 3 carti imprumutate");
			return false;
		}
		return true;
	}

}

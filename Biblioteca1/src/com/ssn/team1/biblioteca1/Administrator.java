package com.ssn.team1.biblioteca1;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

public class Administrator extends UtilizatorSimplu implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Exemplar> cartiImprumutate = new ArrayList<Exemplar>();

	public Administrator(String numeUtilizator, String parola) {
		super(numeUtilizator, parola);
	}

	@Override
	public void setParola(String parola) {
		super.setParola(parola);
	}

	public Administrator(String numeUtilizator, String parola, String nume,
			String numarTelefon) {
		super(numeUtilizator, parola, nume, numarTelefon);
	}

	public void adaugaCarte(String titlu, String numeAutor) {
		Biblioteca.getInstance().adaugaCarte(new Carte(titlu, numeAutor));
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void adaugaNumarExemplare(String titlu, String autor,
			String idExemplar) {
		Carte carte = Biblioteca.getInstance().getCarteDupaTitluSiAutor(titlu,
				autor);
		carte.adaugaNumarExemplare(idExemplar);
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void adaugaMembru(String numeUtilizator1, String parola1,
			String nume1, String numarTelefon, String adresa, String cnp) {
		if (Validator.existaCNP(cnp)) {
			InterfataUtilizator.showMessage("Cnp-ul introdus exista deja !");
			return;
		}
		Biblioteca.getInstance().adaugaMembru(
				new MembruInregistrat(numeUtilizator1, parola1, nume1,
						numarTelefon, adresa, cnp));
		InterfataUtilizator.showMessage(" ! utilizatorul " + numeUtilizator1
				+ " a fost adaugat");
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void adaugaAdministrator(String numeUtilizator1, String parola1,
			String nume1, String numarTelefon) {
		Biblioteca.getInstance()
				.adaugaAdministrator(
						new Administrator(numeUtilizator1, parola1, nume1,
								numarTelefon));
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void afiseazaStatisticiCartiNereturnateLaTimp() {
		Biblioteca.getInstance().afiseazaStatisticiCartiNereturnateLaTimp();
	}

	public void afiseazaIstoricOperatiuniTotale() {
		Biblioteca.getInstance().afiseazaIstoricOperatiuniTotale();
	}

	public void returneazaCarte(String username, String idExemplar) {
		UtilizatorSimplu membru = Biblioteca.getInstance()
				.getMembruInregistratByNumeUtilizator(username);
		if (membru instanceof MembruInregistrat) {
			MembruInregistrat memInreg = (MembruInregistrat) membru;
			Exemplar exemplarImprumutat = memInreg
					.getExemplarImprumutatById(idExemplar);
			if (exemplarImprumutat == null) {
				InterfataUtilizator.showMessage(" ! nu exista exemplarul");
				return;
			}
			memInreg.returneazaCarte(exemplarImprumutat);
		} else {
			Administrator admin = (Administrator) membru;
			Exemplar exemplarImprumutat = admin
					.getExemplarImprumutatById(idExemplar);
			if (exemplarImprumutat == null) {
				InterfataUtilizator.showMessage(" ! nu exista exemplarul");
				return;
			}
			admin.returneazaCartePtAdmin(exemplarImprumutat);
		}
		InterfataUtilizator.showMessage(" ! carte returnata cu succes");
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	private void returneazaCartePtAdmin(Exemplar exemplarImprumutat) {
		exemplarImprumutat.returneaza();
		cartiImprumutate.remove(exemplarImprumutat);
	}

	public void imprumutaCarte(String username, String titluCarte,
			String autorCarte) {
		UtilizatorSimplu membru = Biblioteca.getInstance()
				.getMembruInregistratByNumeUtilizator(username);
		Carte carte = Biblioteca.getInstance().getCarteDupaTitluSiAutor(
				titluCarte, autorCarte);
		if (carte == null) {
			InterfataUtilizator.showMessage(" ! nu exista cartea");
			return;
		}
		Exemplar exemplarDeImprumutat = carte.getExemplarDisponibil();
		if (exemplarDeImprumutat == null) {
			InterfataUtilizator
					.showMessage(" ! nu exista exemplare disponibile");
			return;
		}
		if (membru instanceof MembruInregistrat) {
			if (membru.esteEligibilSaImprumute()) {
				((MembruInregistrat) membru)
						.imprumutaCarte(exemplarDeImprumutat);
			}
		} else {
			if (membru.esteEligibilSaImprumute()) {
				((Administrator) membru)
						.imprumutaCartePtAdmin(exemplarDeImprumutat);
			}

		}

		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	private void imprumutaCartePtAdmin(Exemplar exemplarImprumutat) {
		Imprumut imp = new Imprumut(Biblioteca.getInstance().getExpireDate());
		exemplarImprumutat.imprumuta(imp);
		cartiImprumutate.add(exemplarImprumutat);
		Biblioteca.getInstance().addImprumut(this, imp);
		InterfataUtilizator.showMessage(" ! Carte imprumutata cu succes");
	}

	public void aprobaSolicitare(MembruNeinregistrat membruNeinregistrat) {
		if (!Validator.existaUsername(membruNeinregistrat.getNumeUtilizator())) {
			if (Validator.esteCnpValid(membruNeinregistrat.getCnp())) {
				Biblioteca.getInstance().aprobaSolicitare(membruNeinregistrat);
			} else {
				InterfataUtilizator.showMessage("! Username "
						+ membruNeinregistrat.getNumeUtilizator()
						+ " cnp existent");
				refuzaSolicitare(membruNeinregistrat);
			}
		} else {
			InterfataUtilizator.showMessage(" ! username existent :"
					+ membruNeinregistrat.getNumeUtilizator());
			refuzaSolicitare(membruNeinregistrat);
		}
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	@Override
	public void meniu() {
		MeniuAdministrator.meniu();
	}

	public ArrayList<Carte> getCartiDupaTitlu(String titlu) {
		return Biblioteca.getInstance().getCartiDupaTitlu(titlu);
	}

	public ArrayList<Carte> getCartiDupaAutor(String autor) {
		return Biblioteca.getInstance().getCartiDupaAutor(autor);
	}

	public void afiseazaInformatiiDespreMembru(String numeUtilizator1) {
		UtilizatorSimplu membruInregistrat = Biblioteca.getInstance()
				.getMembruInregistratByNumeUtilizator(numeUtilizator1);
		if (membruInregistrat instanceof Administrator) {
			InterfataUtilizator
					.showMessage(" ! nu sunt disponibile informatiile despre admin");
			return;
		}
		((MembruInregistrat) membruInregistrat).afiseazaInformatii();
	}

	public void exportaInfoInCSv() {
		try {
			Biblioteca.getInstance().exportaToCsv();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void refuzaSolicitare(MembruNeinregistrat membru) {
		Biblioteca.getInstance().refuzaSolicitare(membru);
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
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

	private Exemplar getExemplarImprumutatById(String idExemplar) {
		Exemplar exemplar = null;
		for (Exemplar e : cartiImprumutate) {
			if (e.getIdUnic().equals(idExemplar)) {
				exemplar = e;
			}
		}
		return exemplar;
	}

	public ArrayList<Exemplar> getCartiImprumutate() {
		return cartiImprumutate;
	}

	public void imprumutaCartePrinIdExemplar(String username,
			String titluCarte, String autorCarte, String idExemplar2) {
		boolean facut = false;
		UtilizatorSimplu membru = Biblioteca.getInstance()
				.getMembruInregistratByNumeUtilizator(username);
		Carte carte = Biblioteca.getInstance().getCarteDupaTitluSiAutor(
				titluCarte, autorCarte);
		if (carte == null) {
			InterfataUtilizator.showMessage(" ! nu exista cartea");
			return;
		}
		for (Exemplar e : carte.getExemplare()) {
			if (e.getIdUnic().equals(idExemplar2)) {
				Exemplar exemplarDeImprumutat = e;
				facut = true;
				if (membru instanceof MembruInregistrat) {
					if (membru.esteEligibilSaImprumute()) {
						((MembruInregistrat) membru)
								.imprumutaCarte(exemplarDeImprumutat);
					}
				} else {
					if (membru.esteEligibilSaImprumute()) {
						((Administrator) membru)
								.imprumutaCartePtAdmin(exemplarDeImprumutat);
					}

				}

				SerializareDate.save(Biblioteca.getInstance()
						.getFisierSerializare());

			}
		}
		if (!facut) {
			InterfataUtilizator.showMessage(" ! nu exista exemplar");
			return;
		} else {
			InterfataUtilizator.showMessage(" ! cartea a fost imprumutat");
		}

	}

	public void imprumutaCarteDupaId(String username, String idExemplar) {
		UtilizatorSimplu membru = Biblioteca.getInstance()
				.getMembruInregistratByNumeUtilizator(username);
		Exemplar exemplar = Biblioteca.getInstance()
				.getExemplarByID(idExemplar);
		if (exemplar == null) {
			InterfataUtilizator.showMessage(" ! nu exista exemplar");
			return;
		}
		if (exemplar.esteImprumutat()) {
			for (MembruInregistrat m : Biblioteca.getInstance()
					.getMembriiInregistrati()) {
				for (Exemplar e : m.getCartiImprumutate()) {
					if (e.getIdUnic().equals(idExemplar)) {
						m.returneazaCarte(e);
						System.out.println(" ! " + m.getNumeUtilizator()
								+ " a returnat " + idExemplar);
						break;
					}
				}
			}

		}

		if (membru instanceof MembruInregistrat) {
			if (membru.esteEligibilSaImprumute()) {
				((MembruInregistrat) membru).imprumutaCarte(exemplar);
			}
		} else {
			if (membru.esteEligibilSaImprumute()) {
				((Administrator) membru).imprumutaCartePtAdmin(exemplar);
			}

		}

		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void schimbaParola(String parolaVeche, String parolaNoua) {

		if (this.equals(parolaVeche)) {
			this.setParola(parolaNoua);
			SerializareDate.save(Biblioteca.getInstance()
					.getFisierSerializare());
			InterfataUtilizator.showMessage(" ! Parola schimbata cu succes");
		} else {
			InterfataUtilizator.showMessage("Parola veche este gresita !");
		}
	}

}

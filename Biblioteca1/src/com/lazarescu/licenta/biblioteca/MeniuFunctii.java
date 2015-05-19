package com.lazarescu.licenta.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class MeniuFunctii extends Meniu {

	public static void login(String username, String password) {

		utilizator = biblioteca.getUtililizatorDupaNumeUtilizatorSiParola(
				username, password);
		if (utilizator == null) {
			InterfataUtilizator.showMessage(" ! username sau password GRESIT");
		} else {
			utilizator.meniu();

		}
	}

	public static void operatiuniPersonale() {
		MembruInregistrat membru = (MembruInregistrat) utilizator;
		membru.afiseazaIstoricOperatiuniPersonale();
	}

	public static void cautareTitlu(String titlu) {
		// String titlu;
		String cartiGasite = "";
		ArrayList<Carte> carti = utilizator.cautaCartiDupaTitlu(titlu);
		if (carti.isEmpty()) {
			InterfataUtilizator.showMessage(" ! 0 rezultate");
		} else {
			for (Carte carte : carti) {
				cartiGasite += carte;

			}
			InterfataUtilizator.showScrollableMessage(cartiGasite);
		}
	}

	public static void cautareAutor(String autor, boolean inputValid) {
		ArrayList<Carte> carti = utilizator.cautaCartiDupaAutor(autor);
		String autoriGasiti = "";
		if (carti.isEmpty()) {
			InterfataUtilizator.showMessage(" ! 0 rezultate");
		} else {
			for (Carte carte : carti) {
				autoriGasiti += carte.toString() + "\n";

			}
			InterfataUtilizator.showMessage(autoriGasiti);

		}
	}

	public static void adaugareCarte(String titlu, String numeAutor) {
		boolean totulOK = true;

		String[] mesaje = {
		/**/" ! numele cartii nu poate fi null",
		/**/" ! autorul cartii nu poate fi null" };

		totulOK = true;

		if (Validator.existaCarte(titlu, numeAutor)) {
			InterfataUtilizator.showMessage(" ! cartea exista");
			return;
		}

		boolean[] suntValide = {
		/**/Validator.stringulEsteGol(titlu),
		/**/Validator.stringulEsteGol(numeAutor) };
		for (int i = 0; i < mesaje.length; i++) {
			totulOK = totulOK && suntValide[i];
			if (suntValide[i]) {
				InterfataUtilizator.showMessage(mesaje[i]);
			}
		}

		if (totulOK) {
			return;
		}
		Administrator admin = (Administrator) utilizator;
		admin.adaugaCarte(titlu, numeAutor);
		InterfataUtilizator.showMessage(" ! Carte adaugata cu succes");

	}

	public static void adaugareExemplare(String titlu, String numeAutor,
			String numarExemplare) {
		boolean totulOK = true;
		String[] mesaje = {
		/**/" ! numar exemplare incorect" };
		boolean[] suntValide = { Validator.esteNrExemplareInt(numarExemplare) };
		for (int i = 0; i < mesaje.length; i++) {
			totulOK = totulOK && suntValide[i];
			if (!suntValide[i]) {
				InterfataUtilizator.showMessage(mesaje[i]);
			}
		}

		if (!totulOK) {
			InterfataUtilizator.showMessage(" ! Reintroduceti datele corect");
		}
		if (!Validator.existaCarte(titlu, numeAutor)) {
			InterfataUtilizator.showMessage(" ! nu exista cartea");
			return;
		}
		Administrator admin = (Administrator) utilizator;
		adaugaExemplareManual(titlu, numeAutor, numarExemplare, admin);

	}

	private static void adaugaExemplareManual(String titlu, String numeAutor,
			String numarExemplare, Administrator admin) {
		if (!numarExemplare.equals("")) {
			for (int i = 0; i < Integer.parseInt(numarExemplare); i++) {
				boolean existaExemp = false;
				String idExemplar = "";
				do {
					idExemplar = String.valueOf(JOptionPane
							.showInputDialog("Introduceti id exemplar "));
					existaExemp = Validator.existaExemplarByID(idExemplar);
					if (existaExemp) {
						InterfataUtilizator.showMessage(" ! exista exemplar");
					}
				} while (existaExemp);
				admin.adaugaNumarExemplare(titlu, numeAutor, idExemplar);
			}
			InterfataUtilizator
					.showMessage(" ! numarul de exemplare a fost adaugat");
		}
	}

	public static void adaugareMembru(String numeUtilizator, String parola,
			String numeComplet, String nrTelefon, String cnp, String adresa) {
		boolean totulOK = true;

		String[] mesaje = {
		/**/" ! username ocupat",
		/**/" ! camp GOL",
		/**/" ! nume invalid",
		/**/" ! numar de telefon invalid",
		/**/" ! adresa invalida",
		/**/" ! cnp invalid" };
		totulOK = true;
		if (!totulOK) {
			totulOK = true;
			System.out.println();
			System.out.println(" ! Reintroduceti datele corect");
		}

		boolean[] suntValide = {
				/**/!Validator.existaUsername(numeUtilizator),
				/**/!(Validator.stringulEsteGol(parola)
						&& Validator.stringulEsteGol(numeComplet)
						&& Validator.stringulEsteGol(cnp) && Validator
						.stringulEsteGol(adresa)),
				/**/Validator.esteNumeValid(numeComplet),
				/**/Validator.esteNumarTelefonValid(nrTelefon),
				/**/Validator.esteAdresaValida(adresa),
				/**/Validator.esteCnpValid(cnp) };
		for (int i = 0; i < mesaje.length; i++) {
			totulOK = totulOK && suntValide[i];
			if (!suntValide[i]) {
				InterfataUtilizator.showScrollableMessage(mesaje[i] + "\n");
			}
		}
		if (!totulOK) {
			return;
		} else {

			Administrator admin = (Administrator) utilizator;
			admin.adaugaMembru(numeUtilizator, numeComplet, parola, nrTelefon,
					adresa, cnp);
		}
	}

	public static void solicitariInregistrare() {
		ArrayList<MembruNeinregistrat> solicitari = Biblioteca.getInstance()
				.getSolicitariInregistrare();
		ArrayList<MembruNeinregistrat> solicitariAprobate = new ArrayList<>();
		ArrayList<MembruNeinregistrat> solicitariRefuzate = new ArrayList<>();
		Administrator admin = (Administrator) utilizator;

		Iterator<MembruNeinregistrat> iterator = solicitari.iterator();
		while (iterator.hasNext()) {
			MembruNeinregistrat m = iterator.next();
			int rezultat = JOptionPane.showConfirmDialog(null,
					"Adauga membru \n" + m.toString() + "?",
					"Adaugare solicitare", JOptionPane.YES_NO_CANCEL_OPTION);
			if (rezultat == JOptionPane.YES_OPTION) {
				solicitariAprobate.add(m);
				InterfataUtilizator.showMessage("Solicitare aprobata !");
				iterator.remove();
			}
			if (rezultat == JOptionPane.NO_OPTION) {
				solicitariRefuzate.add(m);
				InterfataUtilizator.showMessage("Solicitare refuzata !");
				iterator.remove();
			}

		}
		for (MembruNeinregistrat m : solicitariAprobate) {
			admin.aprobaSolicitare(m);
		}
		for (MembruNeinregistrat m : solicitariRefuzate) {
			admin.refuzaSolicitare(m);
		}

	}

	public static void statistici() {
		Administrator admin = (Administrator) utilizator;
		admin.afiseazaStatisticiCartiNereturnateLaTimp();
		InterfataUtilizator
				.showMessage("Rezultatele au fost exportate sub forma de CSV");
		admin.exportaInfoInCSv();
	}

	public static void operatiuniTotale() {
		Administrator admin = (Administrator) utilizator;
		admin.afiseazaIstoricOperatiuniTotale();
	}

	public static void inregistrare(String numeUtilizator, String nume,
			String parola, String numarTelefon, String cnp, String adresa) {
		boolean totulOK = true;
		boolean dateIntroduseCorect = true;
		String[] mesaje = {
		/**/" ! username ocupat",
		/**/" ! camp parola GOL",
		/**/" ! nume invalid",
		/**/" ! numar de telefon invalid",
		/**/" ! adresa invalida",
		/**/" ! cnp invalid" };

		boolean[] suntValide = {
		/**/!Validator.existaUsername(numeUtilizator),
		/**/!Validator.stringulEsteGol(parola),
		/**/Validator.esteNumeValid(nume),
		/**/Validator.esteNumarTelefonValid(numarTelefon),
		/**/Validator.esteAdresaValida(adresa),
		/**/Validator.esteCnpValid(cnp) };
		for (int i = 0; i < mesaje.length; i++) {
			totulOK = totulOK && suntValide[i];
			if (!suntValide[i]) {
				InterfataUtilizator.showMessage(mesaje[i]);
				dateIntroduseCorect = false;
			}
		}
		if (dateIntroduseCorect) {
			Guest guest = (Guest) utilizator;
			guest.solicitInregistrare(numeUtilizator, nume, parola,
					numarTelefon, cnp, adresa);
			InterfataUtilizator.showMessage("! Solicitarea a fost trimisa ");
		}
	}

	public static void imprumutareCarte() {
		String username = "";
		boolean userValid = false;
		while (!userValid) {
			username = String.valueOf(JOptionPane
					.showInputDialog("  >username: "));

			UtilizatorSimplu utilizator1 = biblioteca
					.getMembruInregistratByNumeUtilizator(username);
			if (utilizator1 == null) {
				InterfataUtilizator.showMessage(" ! username GRESIT");
			} else {
				userValid = true;
			}
		}
		if (!biblioteca.getMembruInregistratByNumeUtilizator(username)
				.esteEligibilSaImprumute()) {
			InterfataUtilizator
					.showMessage(" ! userul nu este eligibil de imprumut");
		} else {

			String titlu;
			String listaCarti = "";
			boolean inputValid;

			titlu = String.valueOf(JOptionPane.showInputDialog("  >titlu: "));
			inputValid = !Validator.stringulEsteGol(titlu);
			if (!inputValid) {
				InterfataUtilizator.showMessage(" ! camp GOL");
			}

			ArrayList<Carte> carti = utilizator.cautaCartiDupaTitlu(titlu);

			if (carti.isEmpty()) {
				InterfataUtilizator.showMessage(" ! 0 rezultate");
				// utilizator.meniu();
			} else {

				for (int i = 0; i < carti.size(); i++) {

					listaCarti += ("   " + (i + 1) + "." + carti.get(i) + "\n");
				}

				String choice = String.valueOf(JOptionPane
						.showInputDialog(listaCarti));
				if ("0".equals(choice)) {
					return;
				}

				if (Validator.esteNrExemplareInt(choice)
						&& Integer.valueOf(choice) <= carti.size()
						&& Integer.valueOf(choice) > 0) {
					Carte carte = carti.get(Integer.valueOf(choice) - 1);
					Administrator admin = (Administrator) utilizator;

					admin.imprumutaCarte(username, carte.getTitlu(),
							carte.getAutor());
				} else {
					InterfataUtilizator.showMessage(" ! input GRESIT");
				}

			}
		}
	}

	public static void returnareCarte2() {
		String username = "";
		UtilizatorSimplu utilizator1 = null;
		String strCartiImprumutate = "";

		username = String.valueOf(JOptionPane.showInputDialog("  >username: "));
		utilizator1 = biblioteca.getMembruInregistratByNumeUtilizator(username);
		if (utilizator1 == null) {
			InterfataUtilizator.showMessage(" ! username GRESIT");
		} else {
			ArrayList<Exemplar> cartiImprumutate = null;
			if (utilizator1 instanceof Administrator) {
				Administrator admin = (Administrator) utilizator1;
				cartiImprumutate = admin.getCartiImprumutate();
			}
			if (utilizator1 instanceof MembruInregistrat) {
				MembruInregistrat membru = (MembruInregistrat) utilizator1;
				cartiImprumutate = membru.getCartiImprumutate();
			}

			if (cartiImprumutate.isEmpty()) {
				InterfataUtilizator.showMessage(" ! nu sunt carti imprumutate");
			} else {

				for (int i = 0; i < cartiImprumutate.size(); i++) {
					strCartiImprumutate += ("   " + (i + 1) + "."
							+ cartiImprumutate.get(i) + "\n");
				}
				String choice = String.valueOf(JOptionPane
						.showInputDialog(strCartiImprumutate));
				if ("0".equals(choice)) {

					return;
				}
				if (Validator.esteNrExemplareInt(choice)
						&& Integer.valueOf(choice) <= cartiImprumutate.size()
						&& Integer.valueOf(choice) > 0) {

					Exemplar exemplar = cartiImprumutate.get(Integer
							.valueOf(choice) - 1);
					Administrator admin = (Administrator) utilizator;

					admin.returneazaCarte(username, exemplar.getIdUnic());
					InterfataUtilizator.showMessage("Cartea "
							+ exemplar.getIdUnic() + " a fost returnata ");

				} else {
					InterfataUtilizator.showMessage(" ! input GRESIT");
				}

			}

		}

	}

	public static void informatiiMembru(String username) {
		boolean userValid = false;

		UtilizatorSimplu utilizator1 = biblioteca
				.getMembruInregistratByNumeUtilizator(username);
		if (utilizator1 == null) {
			System.out.println();
		} else {
			userValid = true;
		}

		if (userValid) {
			Administrator admin = (Administrator) utilizator;
			admin.afiseazaInformatiiDespreMembru(username);
		} else {
			InterfataUtilizator.showMessage(" ! username GRESIT");
		}

	}

	public static void listaMembrii() {
		String membrii = "";
		for (MembruInregistrat m : biblioteca.getMembriiInregistrati()) {
			membrii += "Nume : " + m.nume + " Nume utilizator : "
					+ m.numeUtilizator + "\n\n";
		}
		InterfataUtilizator.showScrollableMessage(membrii);
	}

	public static void adaugareAdmin(String numeUtilizator, String parola,
			String numeComplet, String nrTelefon, String cnp, String adresa) {
		boolean totulOK = true;

		String[] mesaje = {
		/**/" ! username ocupat",
		/**/" ! camp GOL",
		/**/" ! nume invalid",
		/**/" ! numar de telefon invalid",
		/**/};
		// do {
		totulOK = true;
		if (!totulOK) {
			totulOK = true;
			InterfataUtilizator.showMessage(" ! Reintroduceti datele corect");
		}

		boolean[] suntValide = {
				/**/!Validator.existaUsername(numeUtilizator),
				/**/!(Validator.stringulEsteGol(parola) && Validator
						.stringulEsteGol(numeComplet)),
				/**/Validator.esteNumeValid(numeComplet),
				/**/Validator.esteNumarTelefonValid(nrTelefon) };
		for (int i = 0; i < mesaje.length; i++) {
			totulOK = totulOK && suntValide[i];
			if (!suntValide[i]) {
				InterfataUtilizator.showScrollableMessage(mesaje[i]);
			}
		}
		if (!totulOK) {
			return;
		}

		Administrator admin = (Administrator) utilizator;
		admin.adaugaAdministrator(numeUtilizator, parola, numeComplet,
				nrTelefon);
		InterfataUtilizator.showMessage(" ! Adminul a fost adugat ");
	}

	public static void operatiuniPersonaleReturnate() {
		((MembruInregistrat) utilizator).afiseazaInformatii();

	}

	public static void schimbaParolaAdmin(String parolaVeche, String parolaNoua) {
		((Administrator) utilizator).schimbaParola(parolaVeche, parolaNoua);
	}

	public static void afiseazaToateCartile() {
		ArrayList<Carte> carti = utilizator.gasesteToateCartile();
		String toateCartileDinBiblioteca = "";
		for (Carte c : carti) {
			toateCartileDinBiblioteca += c.toString() + "\n";
		}
		InterfataUtilizator.showScrollableMessage(toateCartileDinBiblioteca);
	}
}
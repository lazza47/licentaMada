package com.lazarescu.licenta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Biblioteca implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Biblioteca instance = null;
	private ArrayList<MembruNeinregistrat> solicitariInregistrare = new ArrayList<MembruNeinregistrat>();
	private ArrayList<MembruInregistrat> membriiInregistrati = new ArrayList<MembruInregistrat>();
	private ArrayList<Administrator> administratori = new ArrayList<Administrator>();
	private Guest guest;
	private String fisierSerializare;
	private ArrayList<Carte> carti = new ArrayList<Carte>();
	private HashMap<UtilizatorSimplu, ArrayList<Imprumut>> istoric = new HashMap<UtilizatorSimplu, ArrayList<Imprumut>>();
	private long expireDate;

	private Biblioteca() {
	}

	public ArrayList<Carte> getCarti() {
		return carti;
	}

	public ArrayList<Carte> getCartiDupaTitlu(String titlu) {
		ArrayList<Carte> cartiGasite = new ArrayList<Carte>();
		for (Carte c : carti) {
			if (c.getTitlu().toLowerCase().contains(titlu.toLowerCase())) {
				cartiGasite.add(c);
			}
		}
		return cartiGasite;
	}

	public ArrayList<Carte> getCartiDupaAutor(String autor) {
		ArrayList<Carte> cartiGasite = new ArrayList<Carte>();
		for (Carte c : carti) {
			if (c.getAutor().toLowerCase().contains(autor.toLowerCase())) {
				cartiGasite.add(c);
			}
		}
		return cartiGasite;
	}

	public ArrayList<Carte> getToateCartile() {

		return carti;
	}

	public Carte getCarteDupaTitluSiAutor(String titlu, String autor) {
		Carte carte = null;
		for (Carte c : carti) {
			if (c.getTitlu().toLowerCase().contains(titlu.toLowerCase())
					&& c.getAutor().toLowerCase().contains(autor.toLowerCase())) {
				carte = c;
			}
		}
		return carte;
	}

	public static Biblioteca getInstance() {
		if (instance == null) {
			instance = new Biblioteca();
			instance.initConfig();
			Biblioteca b = SerializareDate.load(Biblioteca.getInstance()
					.getFisierSerializare());
			if (b != null) {
				instance = b;
				instance.initConfig();
			}
		}

		return instance;
	}

	public void adaugaCarte(Carte carte) {
		carti.add(carte);
	}

	public void adaugaMembru(MembruInregistrat membru) {
		membriiInregistrati.add(membru);
	}

	public void adaugaAdministrator(Administrator a) {
		administratori.add(a);
	}

	public UtilizatorSimplu getMembruInregistratByNumeUtilizator(
			String numeUtilizator) {
		UtilizatorSimplu m = null;
		for (MembruInregistrat membruInregistrat : membriiInregistrati) {
			if (membruInregistrat.getNumeUtilizator().equals(numeUtilizator)) {
				m = membruInregistrat;
			}
		}
		for (Administrator administrator : administratori) {
			if (administrator.getNumeUtilizator().equals(numeUtilizator)) {
				m = administrator;
			}
		}
		return m;
	}

	public void afiseazaStatisticiCartiNereturnateLaTimp() {
		String statistici = "";
		for (UtilizatorSimplu m : membriiInregistrati) {
			statistici += afiseazaStatisticiCartiNereturnateLaTimp(m);
		}
		for (UtilizatorSimplu m : administratori) {
			statistici += afiseazaStatisticiCartiNereturnateLaTimp(m);
		}
		InterfataUtilizator.showScrollableMessage(statistici);
	}

	public void afiseazaIstoricOperatiuniTotale() {
		String istoricMembrii = "";
		String istoricAdministratori = "";
		for (UtilizatorSimplu m : membriiInregistrati) {
			istoricMembrii += afiseazaIstoricOperatiuniTotale(m);

		}
		for (UtilizatorSimplu m : administratori) {
			istoricAdministratori += afiseazaIstoricOperatiuniTotale(m);
		}
		InterfataUtilizator.showScrollableMessage("Membrii :\n"
				+ istoricMembrii +
				/**/"Administratori :\n" + istoricAdministratori);
	}

	public Utilizator getUtililizatorDupaNumeUtilizatorSiParola(
			String username, String password) {
		Utilizator u = null;
		if (verificaParolaGuest(username, password)) {
			return guest;
		}
		u = getAdministratorDupaNumeSiParola(username, password);
		if (u == null) {
			u = getMembruInregistratDupaNumeSiParola(username, password);
			if (u != null) {
				return u;
			} else {
				return getMembruNeinregistratDupaNumeSiParola(username,
						password);
			}
		}
		return u;
	}

	public ArrayList<MembruInregistrat> getMembriiInregistrati() {
		return membriiInregistrati;
	}

	public ArrayList<Administrator> getAdministratori() {
		return administratori;
	}

	private boolean verificaParolaGuest(String username, String password) {
		return ((guest.getNumeUtilizator().equals(username) && guest
				.getParola().equals(password)) ? true : false);
	}

	private Utilizator getMembruInregistratDupaNumeSiParola(String username,
			String password) {
		for (MembruInregistrat membri : membriiInregistrati) {
			if (membri.getNumeUtilizator().equals(username)
					&& membri.getParola().equals(password)) {
				return membri;
			}
		}
		return null;
	}

	private Utilizator getMembruNeinregistratDupaNumeSiParola(String username,
			String password) {
		for (MembruNeinregistrat membri : solicitariInregistrare) {
			if (membri.getNumeUtilizator().equals(username)
					&& membri.getParola().equals(password)) {
				return membri;
			}
		}
		return null;
	}

	private Utilizator getAdministratorDupaNumeSiParola(String username,
			String password) {
		for (Administrator administrator : administratori) {
			if (administrator.getNumeUtilizator().equals(username)
					&& administrator.getParola().equals(password)) {
				return administrator;
			}
		}
		return null;
	}

	public void initConfig() {
		Document doc = citesteDinConfig("config.xml");
		ArrayList<String> informatiiDocument = getInformatiiDocument(doc,
				"datafile");
		this.fisierSerializare = informatiiDocument.get(0).trim();
		informatiiDocument = getInformatiiDocument(doc, "guest");
		this.guest = new Guest(informatiiDocument.get(0).trim(),
				informatiiDocument.get(1).trim());
		informatiiDocument = getInformatiiDocument(doc, "admin");
		this.administratori.add(new Administrator(informatiiDocument.get(0)
				.trim(), informatiiDocument.get(1).trim()));
		informatiiDocument = getInformatiiDocument(doc, "expire");
		this.expireDate = Long.parseLong(informatiiDocument.get(0).trim()) * 1000;

	}

	private Document citesteDinConfig(String numeConfig) {
		Document doc = null;
		try {
			File fXmlFile = new File(numeConfig);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = null;
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return doc;
	}

	private ArrayList<String> getInformatiiDocument(Document doc, String numeNod) {
		Element docElement = doc.getDocumentElement();
		NodeList nodList = docElement.getElementsByTagName(numeNod);
		ArrayList<String> informatiiNod = new ArrayList<String>();
		for (int i = 0; i < nodList.getLength(); i++) {
			Node node = nodList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				informatiiNod.add(element.getLastChild().getNodeValue());
			}
		}
		return informatiiNod;
	}

	public ArrayList<MembruNeinregistrat> getSolicitariInregistrare() {
		return solicitariInregistrare;
	}

	public void adaugaSolicitareInregistrare(
			MembruNeinregistrat membruNeinregistrat) {
		solicitariInregistrare.add(membruNeinregistrat);
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public void aprobaSolicitare(MembruNeinregistrat membruNeinregistrat) {
		solicitariInregistrare.remove(membruNeinregistrat);
		MembruInregistrat membruInregistrat = new MembruInregistrat(
				membruNeinregistrat.getNumeUtilizator(),
				membruNeinregistrat.getNume(), membruNeinregistrat.getParola(),
				membruNeinregistrat.getNumarTelefon(),
				membruNeinregistrat.getCnp(), membruNeinregistrat.getAdresa());
		adaugaMembru(membruInregistrat);
	}

	public void refuzaSolicitare(MembruNeinregistrat membruNeinregistrat) {
		solicitariInregistrare.remove(membruNeinregistrat);
		SerializareDate.save(Biblioteca.getInstance().getFisierSerializare());
	}

	public boolean existaUsername(String username) {
		if (guest.numeUtilizator.equals(username)) {
			return true;
		}
		for (MembruInregistrat membru : membriiInregistrati) {
			if (membru.getNumeUtilizator().equals(username)) {
				return true;
			}
		}
		for (Administrator admin : administratori) {
			if (admin.getNumeUtilizator().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public long getExpireDate() {
		return expireDate;
	}

	public Guest getGuest() {
		return guest;
	}

	public String getFisierSerializare() {
		return fisierSerializare;
	}

	public boolean existaCarte(String titlu, String autor) {
		boolean validare = false;
		for (Carte carte : carti) {
			if (carte.getTitlu().equals(titlu)
					&& carte.getAutor().equals(autor)) {
				validare = true;
			}
		}
		return validare;
	}

	public String afiseazaIstoricOperatiuniTotale(UtilizatorSimplu m) {
		ArrayList<Imprumut> imprumuturi = istoric.get(m);
		String istoric = "";
		if (imprumuturi != null) {
			for (Imprumut imprumut : imprumuturi) {
				System.out.println(imprumut);
				istoric += imprumut.toString() + "\n";
			}

		}
		return istoric;
	}

	public String afiseazaStatisticiCartiNereturnateLaTimp(UtilizatorSimplu m) {
		ArrayList<Imprumut> imprumuturi = istoric.get(m);
		String statistici = "";
		if (imprumuturi != null) {
			for (Imprumut imprumut : imprumuturi) {
				imprumut.setDupaCatTimpTermenDepasit(Biblioteca.getInstance()
						.getExpireDate());
				if (imprumut.isTermenDepasit()) {
					statistici += m.getNumeUtilizator() + "  "
							+ imprumut.toString() + "\n";
				}
			}

		}
		return statistici;
	}

	public void afiseazaIstoricMembru(MembruInregistrat membruInregistrat) {
		ArrayList<Imprumut> istoricImprumuturiMembru = istoric
				.get(membruInregistrat);
		String istoricImprumuturi = "";
		if (istoricImprumuturiMembru != null) {
			for (Imprumut imprumut : istoricImprumuturiMembru) {
				istoricImprumuturi += imprumut.toString() + "\n";
			}
			InterfataUtilizator.showScrollableMessage(istoricImprumuturi);
		}

	}

	public void addImprumut(UtilizatorSimplu utilizator, Imprumut imp) {
		ArrayList<Imprumut> arrayList = istoric.get(utilizator);
		if (arrayList != null) {
			arrayList.add(imp);
			istoric.put(utilizator, arrayList);
		} else {
			arrayList = new ArrayList<Imprumut>();
			arrayList.add(imp);
			istoric.put(utilizator, arrayList);
		}
	}

	public void exportaToCsv() throws FileNotFoundException {
		PrintStream csvFIle = new PrintStream(new FileOutputStream(
				"fisierul_meu.csv"));

		for (UtilizatorSimplu m : membriiInregistrati) {
			ArrayList<Imprumut> imprumuturi = istoric.get(m);
			if (imprumuturi != null) {
				for (Imprumut imprumut : imprumuturi) {
					if (imprumut.isTermenDepasit()) {
						print(m.getNume(), csvFIle);
						print(imprumut.toString(), csvFIle);
					}
				}
			}
		}
		for (UtilizatorSimplu m : administratori) {
			ArrayList<Imprumut> imprumuturi = istoric.get(m);
			if (imprumuturi != null) {
				for (Imprumut imprumut : imprumuturi) {
					if (imprumut.isTermenDepasit()) {
						print(m.getNume(), csvFIle);
						print(imprumut.toString(), csvFIle);
					}
				}
			}
		}
	}

	private void print(String s, PrintStream file) {
		file.print(s);
	}

	public Exemplar getExemplarByID(String idExemplar) {
		for (Carte c : carti) {
			for (Exemplar e : c.getExemplare()) {
				if (e.getIdUnic().equals(idExemplar)) {
					return e;
				}
			}
		}
		return null;
	}

}

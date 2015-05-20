package com.lazarescu.licenta;

import java.io.Serializable;
import java.util.Date;

public class Exemplar implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idUnic;
	private boolean esteImprumutat = false;
	private boolean pierdut = false;
	private String numeCarte;
	private Imprumut imprumut;

	public boolean esteDisponibil() {
		if (!esteImprumutat() && !isPierdut()) {
			return true;
		}
		return false;
	}

	public Exemplar(String id, String numeCarte) {
		this.numeCarte = numeCarte;
		setIdUnic(id);
	}

	@Override
	public String toString() {
		return "Exemplar " + numeCarte + " " + idUnic + " ";
	}

	public Date getDataEliberarii() {
		return new Date(getImprumut().getDataImprumutare().getTime()
				+ (Biblioteca.getInstance().getExpireDate()));
	}

	public boolean esteImprumutat() {
		return esteImprumutat;
	}

	public void setEsteImprumutat(boolean esteImprumutat) {
		this.esteImprumutat = esteImprumutat;
	}

	public boolean isPierdut() {
		return pierdut;
	}

	public void setPierdut(boolean pierdut) {
		this.pierdut = pierdut;
	}

	public String getIdUnic() {
		return idUnic;
	}

	public void setIdUnic(String idUnic) {
		this.idUnic = idUnic;
	}

	public Imprumut getImprumut() {
		return imprumut;
	}

	public void setImprumut(Imprumut imprumut) {
		this.imprumut = imprumut;
	}

	public void returneaza() {
		imprumut.setDataReturnare(new Date());
		esteImprumutat = false;
	}

	public void imprumuta(Imprumut imprumut1) {
		this.imprumut = imprumut1;
		imprumut1.setNumeCarte(numeCarte);
		imprumut1.setId(idUnic);
		esteImprumutat = true;
	}

}

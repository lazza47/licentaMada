
package com.lazarescu.licenta.biblioteca;

import java.io.Serializable;


public class MembruNeinregistrat extends Membru implements Serializable {

  private static final long serialVersionUID = 1L;

  public MembruNeinregistrat(String numeUtilizator, String parola, String nume, String nrTel, String cnp, String adresa) {
    super(numeUtilizator, parola, nume, nrTel, adresa, cnp);
  }

  @Override
  public void meniu() {
    MeniuMembruNeinregistrat.meniu();

  }

  @Override
  public boolean esteEligibilSaImprumute() {
    return false;
  }

  @Override
  public String toString() {
    return " [ numeUtilizator: " + numeUtilizator + ", nume: " + nume + ", adresa: " + adresa + ", cnp: " + cnp + "]";
  }

}

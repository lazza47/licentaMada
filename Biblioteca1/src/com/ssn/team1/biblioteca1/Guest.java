
package com.ssn.team1.biblioteca1;

import java.io.Serializable;


public class Guest extends Utilizator implements Serializable {

  private static final long serialVersionUID = 1L;

  public Guest(String username, String password) {
    super(username, password);
  }

  public void solicitInregistrare(String numeUtilizator1, String nume, String parola1, String nrTel, String cnp, String adresa) {
    MembruNeinregistrat membruNeinregistrat = new MembruNeinregistrat(numeUtilizator1, parola1, nume, nrTel, cnp, adresa);
    Biblioteca.getInstance().adaugaSolicitareInregistrare(membruNeinregistrat);
  }

  @Override
  public void meniu() {
    MeniuGuest.meniu();
  }

  @Override
  public String toString() {
    return super.toString() + "]";
  }

}

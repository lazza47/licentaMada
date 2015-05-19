
package com.ssn.team1.biblioteca1;

import java.io.Serializable;
import java.util.Date;

public class Imprumut implements Serializable {
  private static final long serialVersionUID = 1L;
  private Date dataImprumutare;
  private Date dataReturnare = null;
  private String numeCarte;
  private String idExemplar;
  private long dupaCatTimpTermenDepasit;

  public Imprumut(long dupaCatTImp) {
    this.dupaCatTimpTermenDepasit = dupaCatTImp;
    dataImprumutare = new Date();
  }

  public boolean isTermenDepasit() {
    Date datacurenta = new Date();
    Date dataCandTrebuieReturnata = new Date(dataImprumutare.getTime() + (dupaCatTimpTermenDepasit));
    if (dataReturnare == null) {
      if (datacurenta.after(dataCandTrebuieReturnata)) {
        return true;
      }
    } else {
      if (dataReturnare.after(dataCandTrebuieReturnata)) {
        return true;
      }
    }
    return false;
  }

  public Date getDataImprumutare() {
    return dataImprumutare;
  }

  public Date getDataReturnare() {
    return dataReturnare;
  }

  public void setDataReturnare(Date dataReturnare) {
    this.dataReturnare = dataReturnare;
  }

  public String getNumeCarte() {
    return numeCarte;
  }

  public void setDataImprumutare(Date dataImprumutare) {
    this.dataImprumutare = dataImprumutare;
  }

  public void setDupaCatTimpTermenDepasit(long dupaCatTimpTermenDepasit) {
    this.dupaCatTimpTermenDepasit = dupaCatTimpTermenDepasit;
  }

  @Override
  public String toString() {
    String newLine = System.getProperty("line.separator");
    String afisare = "";
    afisare += numeCarte + ", ";
    afisare += idExemplar + ", ";
    afisare += dataImprumutare + ", ";
    if (dataReturnare == null) {
      afisare += ", nereturnata";
    } else {
      afisare +=", "+dataReturnare;
    }
    afisare += newLine;
    return afisare;
  }

  public void setNumeCarte(String numeCarte) {
    this.numeCarte = numeCarte;
  }

  public void setId(String idUnic) {
    idExemplar = idUnic;

  }

}

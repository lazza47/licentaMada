package com.lazarescu.licenta.biblioteca;

public class MeniuPrincipal extends Meniu {
	public static void main(String[] args) {

		biblioteca.adaugaAdministrator(new Administrator("adi007", "adi",
				"Mihai Adian", "0743117033"));
		meniu();
	}

	public static void meniu() {

		FrameLogin login = new FrameLogin();
		login.setVisible(true);
	}
}

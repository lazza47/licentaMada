package com.example.primaapilicatie1;

import java.util.ArrayList;

public class Restaurant {
	private static ArrayList<Masa> mese = new ArrayList<Masa>();

	public static void addMasa(String nume, String parola) {
		mese.add(new Masa(nume, parola));
	}

	public static Masa getMasaDupaNumeSiParola(String nume, String parola) {
		for (Masa m : mese) {
			if (m.getNume().equals(nume)) {
				if (m.getParola().equals(parola)) {
					return m;
				}

			}

		}
		return null;

	}
}

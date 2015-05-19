package com.ssn.team1.biblioteca1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializareDate implements Serializable {

	public static void save(String numeFisierSerializare) {

		FileOutputStream file = null;
		ObjectOutput out = null;

		try {
			file = new FileOutputStream(numeFisierSerializare);
			out = new ObjectOutputStream(file);
			out.writeObject(Biblioteca.getInstance());
			out.flush();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			InterfataUtilizator.showMessage(e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				InterfataUtilizator.showMessage(e.getMessage());
			}
		}

	}

	public static Biblioteca load(String numeFisierSerializare) {
		FileInputStream file = null;
		Biblioteca biblioteca = null;
		ObjectInput input = null;
		try {
			file = new FileInputStream(numeFisierSerializare);
			input = new ObjectInputStream(file);
			biblioteca = (Biblioteca) input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			InterfataUtilizator.showMessage(e.getMessage());
		} catch (IOException e) {
			InterfataUtilizator.showMessage(e.getMessage());
		} catch (ClassNotFoundException e) {
			InterfataUtilizator.showMessage(e.getMessage());
		}

		return biblioteca;
	}

}

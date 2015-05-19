package com.ssn.team1.biblioteca1;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InterfataUtilizator {
	public static void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text.toString());
	}

	public static void showScrollableMessage(String text) {
		JTextArea textArea = new JTextArea(6, 25);
		textArea.setText(text);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setSize(1000, 1000);
		JOptionPane.showMessageDialog(null, scrollPane);
	}

}

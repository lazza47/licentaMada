package com.lazarescu.licenta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameAdaugareMembruSauAdministrator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumeUtilizator;
	private JTextField textFieldParola;
	private JTextField textFieldNumeComplet;
	private JTextField textFieldNumarTelefon;
	private JTextField textFieldAdresa;
	public static String str;
	private JTextField textFieldCnp;
	private JButton btnInregistrare;
	private String numeUtilizator;
	private String numeComplet;
	private String parola;
	private String nrTelefon;
	private String adresa;
	private String cnp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAdaugareMembruSauAdministrator frame = new FrameAdaugareMembruSauAdministrator(
							str);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public FrameAdaugareMembruSauAdministrator(String str) {
		setTitle("Adauga membru sau admin");
		FrameAdaugareMembruSauAdministrator.str = str;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nume utilizator");
		lblNewLabel.setBounds(10, 47, 101, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Parola");
		lblNewLabel_1.setBounds(10, 72, 101, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nume complet");
		lblNewLabel_2.setBounds(10, 97, 101, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Numar telefon");
		lblNewLabel_3.setBounds(10, 122, 101, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Adresa");
		lblNewLabel_4.setBounds(10, 147, 101, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("CNP");
		lblNewLabel_5.setBounds(10, 172, 101, 14);
		contentPane.add(lblNewLabel_5);

		textFieldNumeUtilizator = new JTextField();
		textFieldNumeUtilizator.setBounds(166, 44, 141, 20);
		contentPane.add(textFieldNumeUtilizator);
		textFieldNumeUtilizator.setColumns(10);

		textFieldParola = new JTextField();
		textFieldParola.setBounds(166, 69, 141, 20);
		contentPane.add(textFieldParola);
		textFieldParola.setColumns(10);

		textFieldNumeComplet = new JTextField();
		textFieldNumeComplet.setBounds(166, 94, 141, 20);
		contentPane.add(textFieldNumeComplet);
		textFieldNumeComplet.setColumns(10);

		textFieldNumarTelefon = new JTextField();
		textFieldNumarTelefon.setBounds(166, 119, 141, 20);
		contentPane.add(textFieldNumarTelefon);
		textFieldNumarTelefon.setColumns(10);

		textFieldAdresa = new JTextField();
		textFieldAdresa.setBounds(166, 144, 141, 20);
		contentPane.add(textFieldAdresa);
		textFieldAdresa.setColumns(10);

		textFieldCnp = new JTextField();
		textFieldCnp.setBounds(166, 169, 141, 20);
		contentPane.add(textFieldCnp);
		textFieldCnp.setColumns(10);
		final String tip = str;
		btnInregistrare = new JButton("Inregistrare");
		btnInregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStuff();
				if (tip.equals("membru")) {

					MeniuFunctii.adaugareMembru(numeUtilizator, parola,
							numeComplet, nrTelefon, cnp, adresa);

				}
				if (tip.equals("administrator")) {
					MeniuFunctii.adaugareAdmin(numeUtilizator, parola,
							numeComplet, nrTelefon, cnp, adresa);
				}
				if (tip.equals("guest")) {
					MeniuFunctii.inregistrare(numeUtilizator, numeComplet,
							parola, nrTelefon, cnp, adresa);

				}
			}
		});
		btnInregistrare.setBounds(335, 227, 89, 23);
		contentPane.add(btnInregistrare);

	}

	private void setStuff() {
		numeUtilizator = textFieldNumeUtilizator.getText();
		parola = textFieldParola.getText();
		numeComplet = textFieldNumeComplet.getText();
		nrTelefon = textFieldNumarTelefon.getText();
		cnp = textFieldCnp.getText();
		adresa = textFieldAdresa.getText();

	}
}

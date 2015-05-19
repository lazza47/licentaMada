package com.ssn.team1.biblioteca1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameSchimbareParola extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldParolaVeche;
	private JTextField textFieldParolaNoua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSchimbareParola frame = new FrameSchimbareParola();
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
	public FrameSchimbareParola() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblParolaVeche = new JLabel("Parola veche :");
		lblParolaVeche.setBounds(22, 104, 110, 14);
		contentPane.add(lblParolaVeche);

		JLabel lblParolaNoua = new JLabel("Parola noua :");
		lblParolaNoua.setBounds(22, 156, 110, 14);
		contentPane.add(lblParolaNoua);

		textFieldParolaVeche = new JTextField();
		textFieldParolaVeche.setBounds(180, 101, 191, 20);
		contentPane.add(textFieldParolaVeche);
		textFieldParolaVeche.setColumns(10);

		textFieldParolaNoua = new JTextField();
		textFieldParolaNoua.setBounds(180, 153, 191, 20);
		contentPane.add(textFieldParolaNoua);
		textFieldParolaNoua.setColumns(10);

		JButton btnSchimbaParola = new JButton("Schimba parola");
		btnSchimbaParola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parolaVeche = textFieldParolaVeche.getText();
				String parolaNoua = textFieldParolaNoua.getText();
				if (!(Validator.stringulEsteGol(parolaVeche) || Validator
						.stringulEsteGol(parolaNoua))) {
					MeniuFunctii.schimbaParolaAdmin(parolaVeche, parolaNoua);
				} else {
					InterfataUtilizator.showMessage("Camp gol");
				}
			}

		});
		btnSchimbaParola.setBounds(280, 227, 144, 23);
		contentPane.add(btnSchimbaParola);
	}
}

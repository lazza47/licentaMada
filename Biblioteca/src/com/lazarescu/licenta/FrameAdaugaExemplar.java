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

public class FrameAdaugaExemplar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitlu;
	private JTextField textNumeAutor;
	private JTextField textNrExemplare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAdaugaExemplar frame = new FrameAdaugaExemplar();
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
	public FrameAdaugaExemplar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Adauga exemplar");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titlu = textFieldTitlu.getText();
				String numeAutor = textNumeAutor.getText();
				String numarExemplare = textNrExemplare.getText();
				MeniuFunctii
						.adaugareExemplare(titlu, numeAutor, numarExemplare);
			}
		});
		btnAdauga.setBounds(174, 227, 89, 23);
		contentPane.add(btnAdauga);

		JLabel lblNewLabel = new JLabel("Titlu :");
		lblNewLabel.setBounds(10, 92, 99, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nume autor :");
		lblNewLabel_1.setBounds(10, 117, 99, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Numar exemplare :");
		lblNewLabel_2.setBounds(10, 142, 99, 14);
		contentPane.add(lblNewLabel_2);

		textFieldTitlu = new JTextField();
		textFieldTitlu.setBounds(159, 89, 86, 20);
		contentPane.add(textFieldTitlu);
		textFieldTitlu.setColumns(10);

		textNumeAutor = new JTextField();
		textNumeAutor.setBounds(159, 114, 86, 20);
		contentPane.add(textNumeAutor);
		textNumeAutor.setColumns(10);

		textNrExemplare = new JTextField();
		textNrExemplare.setBounds(159, 139, 86, 20);
		contentPane.add(textNrExemplare);
		textNrExemplare.setColumns(10);

	}
}

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

public class FrameAdaugaCarte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitlu;
	private JTextField textFieldAutor;
	private static FrameAdaugaCarte frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FrameAdaugaCarte();
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
	public FrameAdaugaCarte() {
		setTitle("Adaugare carte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titlu :");
		lblNewLabel.setBounds(31, 92, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Autor :");
		lblNewLabel_1.setBounds(31, 139, 46, 14);
		contentPane.add(lblNewLabel_1);

		textFieldTitlu = new JTextField();
		textFieldTitlu.setBounds(117, 89, 86, 20);
		contentPane.add(textFieldTitlu);
		textFieldTitlu.setColumns(10);

		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(117, 136, 86, 20);
		contentPane.add(textFieldAutor);
		textFieldAutor.setColumns(10);

		JButton btnAdauga = new JButton("Adauga !");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titlu = textFieldTitlu.getText();
				String numeAutor = textFieldAutor.getText();
				MeniuFunctii.adaugareCarte(titlu, numeAutor);
			}
		});
		btnAdauga.setBounds(335, 227, 89, 23);
		contentPane.add(btnAdauga);
	}
}

package com.lazarescu.licenta;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameMembriAdministrator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMembriAdministrator frame = new FrameMembriAdministrator();
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
	public FrameMembriAdministrator() {
		setTitle("Membrii");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdaugare = new JButton("Adaugare");
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdaugareUtilizatorAdministrator frame = new FrameAdaugareUtilizatorAdministrator();
				frame.setVisible(true);
			}
		});

		JLabel label = new JLabel("");
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(btnAdaugare);

		JButton btnInformatii = new JButton("InformatiiMembru");
		btnInformatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameInformatiiMembru frame = new FrameInformatiiMembru();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnInformatii);

		JButton btnListaMembrii = new JButton("Lista membrii");
		btnListaMembrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeniuFunctii.listaMembrii();
			}
		});
		contentPane.add(btnListaMembrii);

		JButton btnSolicitariInregistrare = new JButton(
				"Solicitari inregistrare");
		btnSolicitariInregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeniuFunctii.solicitariInregistrare();
			}
		});
		contentPane.add(btnSolicitariInregistrare);
		contentPane.add(label);
	}

}

package com.ssn.team1.biblioteca1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCautareCarte extends JFrame {

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
					FrameCautareCarte frame = new FrameCautareCarte();
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
	public FrameCautareCarte() {
		setTitle("Cautare carte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDupaTitlu = new JButton("Dupa titlu");
		btnDupaTitlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCautareDupaTitlu frameCautareDupaTitlu = new FrameCautareDupaTitlu();
				frameCautareDupaTitlu.setVisible(true);
			}
		});
		btnDupaTitlu.setBounds(151, 46, 103, 23);
		contentPane.add(btnDupaTitlu);
		
		JButton btnDupaAutor = new JButton("Dupa autor");
		btnDupaAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCautaDupaAutor frameCautaDupaAutor = new FrameCautaDupaAutor();
				frameCautaDupaAutor.setVisible(true);
			}
		});
		btnDupaAutor.setBounds(151, 114, 103, 23);
		contentPane.add(btnDupaAutor);
		
		JButton btnCauta = new JButton("Cauta !");
		btnCauta.setBounds(335, 227, 89, 23);
		contentPane.add(btnCauta);
		
		JButton btnAfiseazaToate = new JButton("Afiseaza toate");
		btnAfiseazaToate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MeniuFunctii.afiseazaToateCartile();
			}
		});
		btnAfiseazaToate.setBounds(151, 186, 103, 23);
		contentPane.add(btnAfiseazaToate);
	}

}

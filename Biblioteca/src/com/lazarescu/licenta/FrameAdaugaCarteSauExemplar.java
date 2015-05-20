package com.lazarescu.licenta;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameAdaugaCarteSauExemplar extends JFrame {

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
					FrameAdaugaCarteSauExemplar frame = new FrameAdaugaCarteSauExemplar();
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
	public FrameAdaugaCarteSauExemplar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAdaugaCarte = new JButton("Adauga carte");
		btnAdaugaCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdaugaCarte meniuAdaugaCarte = new FrameAdaugaCarte();
				meniuAdaugaCarte.setVisible(true);
			}
		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		contentPane.add(btnAdaugaCarte);

		JButton btnAdaugaExemplar = new JButton("Adauga exemplar");
		btnAdaugaExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrameAdaugaExemplar frameAdaugaExemplar = new FrameAdaugaExemplar();
				frameAdaugaExemplar.setVisible(true);
			}
		});
		contentPane.add(btnAdaugaExemplar);
	}

}

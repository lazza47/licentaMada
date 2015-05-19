package com.lazarescu.licenta.biblioteca;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FramePrincipalGuest extends JFrame {

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
					FramePrincipalGuest frame = new FramePrincipalGuest();
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
	public FramePrincipalGuest() {
		setTitle("Meniu guest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnCautaCarte = new JButton("Cauta carte");
		btnCautaCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCautareCarte frameCautareCarte = new FrameCautareCarte();
				frameCautareCarte.setVisible(true);
			}
		});
		contentPane.add(btnCautaCarte);

		JButton btnInregistrare = new JButton("Inregistrare");
		btnInregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdaugareMembruSauAdministrator guest = new FrameAdaugareMembruSauAdministrator(
						"guest");
				guest.setVisible(true);
			}
		});
		contentPane.add(btnInregistrare);
	}
}

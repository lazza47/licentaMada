package com.lazarescu.licenta.biblioteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FramePrincipalMembruNeinregistrat extends JFrame {

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
					FramePrincipalMembruNeinregistrat frame = new FramePrincipalMembruNeinregistrat();
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
	public FramePrincipalMembruNeinregistrat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnCautaCarte = new JButton("Cauta carte");
		btnCautaCarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameCautareCarte frameCautareCarte = new FrameCautareCarte();
				frameCautareCarte.setVisible(true);
			}
		});
		contentPane.add(btnCautaCarte, BorderLayout.CENTER);

		JLabel lblSolicitareInCurs = new JLabel(
				"Solicitare in curs de aprobare....");
		lblSolicitareInCurs.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSolicitareInCurs, BorderLayout.NORTH);
	}

}

package com.lazarescu.licenta;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameAdaugareUtilizatorAdministrator extends JFrame {

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
					FrameAdaugareUtilizatorAdministrator frame = new FrameAdaugareUtilizatorAdministrator();
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
	public FrameAdaugareUtilizatorAdministrator() {
		setTitle("Adauga utilizator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnAdaugareMembru = new JButton("Adaugare membru");
		btnAdaugareMembru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdaugareMembruSauAdministrator frame = new FrameAdaugareMembruSauAdministrator(
						"membru");
				frame.setVisible(true);
			}
		});
		contentPane.add(btnAdaugareMembru);

		JButton btnNewButton = new JButton("Adaugare administrator");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameAdaugareMembruSauAdministrator frame = new FrameAdaugareMembruSauAdministrator(
						"administrator");
				frame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
	}

}

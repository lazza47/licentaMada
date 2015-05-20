package com.lazarescu.licenta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FramePrincipalAdministrator extends JFrame {

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
			private FramePrincipalAdministrator frame;

			public void run() {
				try {
					frame = new FramePrincipalAdministrator();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipalAdministrator() {
		setTitle("Meniu Administrator");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String solicitariInregistrare = " - Sunt "
				+ Biblioteca.getInstance().getSolicitariInregistrare().size()
				+ " solicitari de inregistrare";
		InterfataUtilizator.showMessage(solicitariInregistrare);
		contentPane.setLayout(null);
		JLabel label = new JLabel("");
		label.setBounds(5, 6, 47, 31);
		contentPane.add(label);

		JLabel label_43 = new JLabel("");
		label_43.setBounds(52, 6, 47, 31);
		contentPane.add(label_43);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(99, 6, 47, 31);
		contentPane.add(label_1);

		JButton btnMembrii = new JButton("Membrii");
		btnMembrii.setBounds(28, 48, 396, 31);
		btnMembrii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameMembriAdministrator fm = new FrameMembriAdministrator();
				fm.setVisible(true);
			}
		});

		JLabel label_2 = new JLabel("");
		label_2.setBounds(146, 6, 47, 31);
		contentPane.add(label_2);

		JButton btnCarti = new JButton("Carti");
		btnCarti.setBounds(28, 6, 396, 31);
		btnCarti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameCarti meniuCarti = new FrameCarti();
				meniuCarti.setVisible(true);
			}
		});
		contentPane.add(btnCarti);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(240, 6, 47, 31);
		contentPane.add(label_3);

		JLabel label_44 = new JLabel("");
		label_44.setBounds(287, 6, 47, 31);
		contentPane.add(label_44);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(334, 6, 47, 31);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(381, 6, 47, 31);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setBounds(5, 37, 47, 31);
		contentPane.add(label_6);
		contentPane.add(btnMembrii);

		JButton btnOperatiuni = new JButton("Operatiuni");
		btnOperatiuni.setBounds(28, 90, 396, 31);
		btnOperatiuni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameOperatiuni operatiuni = new FrameOperatiuni();
				operatiuni.setVisible(true);
			}
		});

		JLabel label_7 = new JLabel("");
		label_7.setBounds(99, 37, 47, 31);
		contentPane.add(label_7);

		JLabel label_45 = new JLabel("");
		label_45.setBounds(146, 37, 47, 31);
		contentPane.add(label_45);

		JLabel label_46 = new JLabel("");
		label_46.setBounds(193, 37, 47, 31);
		contentPane.add(label_46);

		JLabel label_8 = new JLabel("");
		label_8.setBounds(240, 37, 47, 31);
		contentPane.add(label_8);

		JLabel label_47 = new JLabel("");
		label_47.setBounds(287, 37, 47, 31);
		contentPane.add(label_47);

		JLabel label_9 = new JLabel("");
		label_9.setBounds(334, 37, 47, 31);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("");
		label_10.setBounds(381, 37, 47, 31);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("");
		label_11.setBounds(5, 68, 47, 31);
		contentPane.add(label_11);

		JLabel label_48 = new JLabel("");
		label_48.setBounds(52, 68, 47, 31);
		contentPane.add(label_48);

		JLabel label_49 = new JLabel("");
		label_49.setBounds(99, 68, 47, 31);
		contentPane.add(label_49);
		contentPane.add(btnOperatiuni);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(193, 68, 47, 31);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("");
		label_13.setBounds(240, 68, 47, 31);
		contentPane.add(label_13);

		JLabel label_50 = new JLabel("");
		label_50.setBounds(287, 68, 47, 31);
		contentPane.add(label_50);

		JLabel label_14 = new JLabel("");
		label_14.setBounds(334, 68, 47, 31);
		contentPane.add(label_14);

		JLabel label_15 = new JLabel("");
		label_15.setBounds(381, 68, 47, 31);
		contentPane.add(label_15);

		JLabel label_16 = new JLabel("");
		label_16.setBounds(5, 99, 47, 31);
		contentPane.add(label_16);

		JLabel label_51 = new JLabel("");
		label_51.setBounds(52, 99, 47, 31);
		contentPane.add(label_51);

		JLabel label_17 = new JLabel("");
		label_17.setBounds(99, 99, 47, 31);
		contentPane.add(label_17);

		JLabel label_52 = new JLabel("");
		label_52.setBounds(146, 99, 47, 31);
		contentPane.add(label_52);

		JLabel label_53 = new JLabel("");
		label_53.setBounds(193, 161, 47, 31);
		contentPane.add(label_53);

		JLabel label_18 = new JLabel("");
		label_18.setBounds(240, 99, 47, 31);
		contentPane.add(label_18);

		JLabel label_54 = new JLabel("");
		label_54.setBounds(287, 99, 47, 31);
		contentPane.add(label_54);

		JLabel label_19 = new JLabel("");
		label_19.setBounds(334, 99, 47, 31);
		contentPane.add(label_19);

		JLabel label_20 = new JLabel("");
		label_20.setBounds(381, 99, 47, 31);
		contentPane.add(label_20);

		JLabel label_21 = new JLabel("");
		label_21.setBounds(5, 130, 47, 31);
		contentPane.add(label_21);

		JButton btnStatistici = new JButton("Statistici");
		btnStatistici.setBounds(28, 132, 396, 31);
		btnStatistici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameStatistici frameStatistici = new FrameStatistici();
				frameStatistici.setVisible(true);

			}
		});
		contentPane.add(btnStatistici);

		JLabel label_22 = new JLabel("");
		label_22.setBounds(99, 130, 47, 31);
		contentPane.add(label_22);

		JLabel label_55 = new JLabel("");
		label_55.setBounds(146, 130, 47, 31);
		contentPane.add(label_55);

		JLabel label_56 = new JLabel("");
		label_56.setBounds(193, 130, 47, 31);
		contentPane.add(label_56);

		JLabel label_23 = new JLabel("");
		label_23.setBounds(240, 130, 47, 31);
		contentPane.add(label_23);

		JLabel label_57 = new JLabel("");
		label_57.setBounds(287, 130, 47, 31);
		contentPane.add(label_57);

		JLabel label_24 = new JLabel("");
		label_24.setBounds(334, 130, 47, 31);
		contentPane.add(label_24);

		JLabel label_25 = new JLabel("");
		label_25.setBounds(381, 130, 47, 31);
		contentPane.add(label_25);

		JLabel label_26 = new JLabel("");
		label_26.setBounds(5, 161, 47, 31);
		contentPane.add(label_26);

		JLabel label_58 = new JLabel("");
		label_58.setBounds(52, 161, 47, 31);
		contentPane.add(label_58);

		JLabel label_27 = new JLabel("");
		label_27.setBounds(99, 161, 47, 31);
		contentPane.add(label_27);

		JButton btnSchimbareParola = new JButton("Schimbare parola");
		btnSchimbareParola.setBounds(28, 172, 396, 31);
		btnSchimbareParola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameSchimbareParola frameSchimbareParola = new FrameSchimbareParola();
				frameSchimbareParola.setVisible(true);
			}
		});
		contentPane.add(btnSchimbareParola);

		JLabel label_59 = new JLabel("");
		label_59.setBounds(193, 161, 47, 31);
		contentPane.add(label_59);

		JLabel label_28 = new JLabel("");
		label_28.setBounds(240, 161, 47, 31);
		contentPane.add(label_28);

		JLabel label_60 = new JLabel("");
		label_60.setBounds(287, 161, 47, 31);
		contentPane.add(label_60);

		JLabel label_29 = new JLabel("");
		label_29.setBounds(334, 161, 47, 31);
		contentPane.add(label_29);

		JLabel label_30 = new JLabel("");
		label_30.setBounds(381, 161, 47, 31);
		contentPane.add(label_30);

		JLabel label_61 = new JLabel("");
		label_61.setBounds(5, 192, 47, 31);
		contentPane.add(label_61);

		JLabel label_62 = new JLabel("");
		label_62.setBounds(52, 192, 47, 31);
		contentPane.add(label_62);

		JLabel label_32 = new JLabel("");
		label_32.setBounds(99, 192, 47, 31);
		contentPane.add(label_32);

		JLabel label_63 = new JLabel("");
		label_63.setBounds(146, 192, 47, 31);
		contentPane.add(label_63);

		JLabel label_33 = new JLabel("");
		label_33.setBounds(193, 192, 47, 31);
		contentPane.add(label_33);

		JLabel label_34 = new JLabel("");
		label_34.setBounds(240, 192, 47, 31);
		contentPane.add(label_34);

		JLabel label_31 = new JLabel("");
		label_31.setBounds(287, 192, 47, 31);
		contentPane.add(label_31);

		JLabel label_35 = new JLabel("");
		label_35.setBounds(334, 192, 47, 31);
		contentPane.add(label_35);

		JLabel label_36 = new JLabel("");
		label_36.setBounds(381, 192, 47, 31);
		contentPane.add(label_36);

		JLabel label_37 = new JLabel("");
		label_37.setBounds(5, 223, 47, 31);
		contentPane.add(label_37);

		JLabel label_64 = new JLabel("");
		label_64.setBounds(52, 223, 47, 31);
		contentPane.add(label_64);

		JLabel label_42 = new JLabel("");
		label_42.setBounds(99, 223, 47, 31);
		contentPane.add(label_42);

		JLabel label_65 = new JLabel("");
		label_65.setBounds(146, 223, 47, 31);
		contentPane.add(label_65);

		JLabel label_38 = new JLabel("");
		label_38.setBounds(193, 223, 47, 31);
		contentPane.add(label_38);

		JLabel label_39 = new JLabel("");
		label_39.setBounds(240, 223, 47, 31);
		contentPane.add(label_39);

		JLabel label_66 = new JLabel("");
		label_66.setBounds(287, 223, 47, 31);
		contentPane.add(label_66);

		JLabel label_40 = new JLabel("");
		label_40.setBounds(334, 223, 47, 31);
		contentPane.add(label_40);

		JLabel label_41 = new JLabel("");
		label_41.setBounds(381, 223, 47, 31);
		contentPane.add(label_41);
	}

}

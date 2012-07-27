package com.para.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.para.data.Constants;
import com.para.utils.Msn;

/**
 * 
 * @author Clisprail
 */
public class MessengerInterface extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	public MessengerInterface() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jComboBox1 = new javax.swing.JComboBox();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jScrollPane1.setViewportView(jList1);
		jList1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String selected = (String) jList1.getSelectedValue();
					Msn.openChat(selected.split("- ")[1]);
				}

			}

		});

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(20, 150, 320, 470);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Online", "Busy", "Away", "Invisible" }));
		getContentPane().add(jComboBox1);
		jComboBox1.setBounds(140, 120, 200, 20);
		getContentPane().add(jTextField1);
		jTextField1.setBounds(140, 30, 210, 20);

		jScrollPane2.setEnabled(false);

		jEditorPane1.setEditable(false);
		jEditorPane1.setEnabled(false);
		jScrollPane2.setViewportView(jEditorPane1);
		
		jEditorPane1.setContentType("text/html");
		
		String url = this.getClass().getResource("/com/para/images/msn.png")
				.toString();
		jEditorPane1.setText("<img src=\"" + url
				+ "\" width=\"100\" height=\"100\"/>");
		
		jEditorPane1.setOpaque(false);
		jEditorPane1.setEnabled(false);
		jEditorPane1.setBorder(null);
		jScrollPane2.setBorder(null);
		
		jScrollPane2
		.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
jScrollPane2
		.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		

		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(20, 10, 100, 100);

		jButton1.setText("Change");
		getContentPane().add(jButton1);
		jButton1.setBounds(20, 120, 110, 20);

		jLabel1.setText("Display name");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(210, 10, 80, 10);

		jLabel2.setText("Personal name");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(205, 50, 90, 14);
		getContentPane().add(jTextField2);
		jTextField2.setBounds(140, 70, 210, 20);

		jButton2.setText("Set");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(200, 96, 90, 20);

		jButton3.setText("Block");
		getContentPane().add(jButton3);
		jButton3.setBounds(180, 630, 80, 23);

		jButton4.setText("Logout");
		getContentPane().add(jButton4);
		jButton4.setBounds(260, 630, 80, 23);

		jButton5.setText("Add");
		getContentPane().add(jButton5);
		jButton5.setBounds(100, 630, 80, 23);

		jButton6.setText("Open");
		getContentPane().add(jButton6);
		jButton6.setBounds(20, 630, 80, 23);
		
		setTitle("Para MSN Messenger");
		
		setIconImage(Constants.getIcon());
		setResizable(false);

		new Center(this, 383, 696);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JEditorPane jEditorPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	public static javax.swing.JList jList1 = new javax.swing.JList();
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;

}

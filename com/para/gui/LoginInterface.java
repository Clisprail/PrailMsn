package com.para.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.para.data.Constants;
import com.para.login.Connect;

/**
 * 
 * @author Clisprail
 */
public class LoginInterface extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public LoginInterface() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jPasswordField1 = new javax.swing.JPasswordField();
		jCheckBox1 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jScrollPane1.setRequestFocusEnabled(false);
		jScrollPane1.setViewportView(jEditorPane1);

		jEditorPane1.setOpaque(false);
		jEditorPane1.setEnabled(false);
		jEditorPane1.setBorder(null);
		jScrollPane1.setBorder(null);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(100, 30, 100, 100);

		jScrollPane1
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		jEditorPane1.setContentType("text/html");
		jEditorPane1.setEditable(false);
		String url = this.getClass().getResource("/com/para/images/msn.png")
				.toString();
		jEditorPane1.setText("<img src=\"" + url
				+ "\" width=\"97\" height=\"97\"/>");

		jLabel1.setText("Email");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(130, 150, 34, 14);
		getContentPane().add(jTextField1);
		jTextField1.setBounds(10, 170, 270, 20);

		jLabel2.setText("Password");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(120, 190, 60, 20);
		getContentPane().add(jPasswordField1);
		jPasswordField1.setBounds(10, 210, 270, 20);

		jCheckBox1.setText("Remember me");
		getContentPane().add(jCheckBox1);
		jCheckBox1.setBounds(8, 240, 133, 16);

		jButton1.setText("Sign in");
		getContentPane().add(jButton1);
		jButton1.setBounds(100, 260, 90, 23);
		
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login();
				
			}
			
		});

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		setTitle("Para MSN Messenger");
		setResizable(false);
		setIconImage(Constants.getIcon());
		new Center(this, 300, 350);
	}

	protected void login() {
		dispose();
		new Connect(jTextField1.getText(), new String(jPasswordField1.getPassword()));
	}
	
	

	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JEditorPane jEditorPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextField1;
}

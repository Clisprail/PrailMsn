
package com.para.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import net.sf.jml.Email;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.message.MsnDatacastMessage;

import com.para.data.Constants;
import com.para.utils.Msn;

/**
 *
 * @author Clisprail
 */
public class ChatWindow extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private String email = null;
	
    public ChatWindow() {
        initComponents();
    }

    public void initFrame(final String name, final String email) {
    	this.email = email;
    	setTitle(name + " - " + email);
    }
    
    private String getEmail() {
    	return email;
    }
   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        DefaultCaret caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 630, 390);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);
        jTextArea2.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					addMessage(Constants.messenger.getOwner().getDisplayName(), sendMessage());
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
        	
        });

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 480, 630, 50);

        jToolBar1.setRollover(false);
        jToolBar1.setOpaque(true);
        jToolBar1.setFloatable(false);

        jButton1.setText("Nudge");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        
        jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MsnDatacastMessage nudgeMessage=new MsnDatacastMessage(); 		
				nudgeMessage.setId(1);
				MsnSwitchboard board = Msn.getSwitchboard(getTitle());
				board.sendMessage(nudgeMessage);
			}
        	
        });

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(10, 450, 630, 20);
        

        jButton2.setText("Send");
        getContentPane().add(jButton2);
        jButton2.setBounds(650, 480, 120, 50);
        jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addMessage(Constants.messenger.getOwner().getDisplayName(), sendMessage());
			}
        	
        });

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 54, 14);

        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jEditorPane1.setEnabled(false);
        jEditorPane1.setOpaque(false);
        jScrollPane3.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(655, 40, 97, 97);

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(655, 160, 97, 20);

        jLabel2.setText("User is typing a message...");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 430, 250, 14);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        setIconImage(Constants.getIcon());
		setResizable(false);

        new Center(this, 800, 600);
    }

    protected String sendMessage() {
    	final String message = jTextArea2.getText();
		Msn.sendMessage(Email.parseStr(getEmail()), message);
		jTextArea2.setText("");
		return message;
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    public void addMessage(final String name, final String message) {
    	final String text = jTextArea1.getText();
    	jTextArea1.setText(text + name + ": " + message);
    }
    
   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea jTextArea1 = new JTextArea();
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToolBar jToolBar1;
}

package com.para.boot;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.para.gui.LoginInterface;

public class Bootstrap {

	public static void main(String[] args) {
		/* windows default look
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		new LoginInterface().setVisible(true);*/
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager
							.setLookAndFeel(new org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel());
					JFrame.setDefaultLookAndFeelDecorated(true);
					new LoginInterface().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}

}

package com.para.boot;

import javax.swing.UIManager;

import com.para.gui.LoginInterface;

public class Bootstrap {

	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new LoginInterface().setVisible(true);
	}

}

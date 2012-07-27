package com.para.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.para.data.Constants;

public class Loader extends JFrame {
	private static final long serialVersionUID = 1L;

	public Loader() {
		setTitle("Para MSN");
		JLabel label1 = new JLabel("Signing in...");
		setResizable(false);
		add(label1);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		new Center(this, 250, 65);
		setVisible(true);
		Constants.loader = this;
		setIconImage(Constants.getIcon());
	}

}

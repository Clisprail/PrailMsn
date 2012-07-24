package com.para.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Center {
	
	public Center(final JFrame f, final int x, final int y) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int absoluteX = (screen.width - x) / 2;
		int absoluteY = (screen.height - y) / 2;
		f.setBounds(absoluteX, absoluteY, x, y);
	}

}

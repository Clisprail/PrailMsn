package com.para.gui;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import com.para.utils.Msn;

public class IconListRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;


	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		JLabel label = (JLabel) super.getListCellRendererComponent(list, value,
				index, isSelected, cellHasFocus);

		final String email = getEmail(label.getText());
		final ImageIcon img = Msn.getStatusImage(email);

		label.setIcon(img);
		return label;
	}
	
	private String getEmail(final String labelText) {
		return labelText.split(" - ")[1];
	}

}

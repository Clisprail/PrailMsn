package com.para.data;

import java.awt.Image;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import net.sf.jml.Email;
import net.sf.jml.MsnMessenger;

import com.para.gui.ChatWindow;
import com.para.gui.IconListRenderer;
import com.para.listeners.MsnListener;

public class Constants {
	
	public static MsnMessenger messenger = null;
	
	public static final DefaultListModel model = new DefaultListModel();
	
	public static final MsnListener listener = new MsnListener();
	
	public static JFrame loader = null;
	
	public static HashMap<Email, ChatWindow> chats = new HashMap<Email, ChatWindow>();
	
	public static IconListRenderer listRenderer = null;
	
	private static Image icon = getImage("/com/para/images/icon.png");
	
	public static ImageIcon online = getIconImage("/com/para/images/online.png");
	
	public static ImageIcon busy = getIconImage("/com/para/images/busy.png");
	
	public static ImageIcon away = getIconImage("/com/para/images/away.png");
	
	public static Image getIcon() {
		return icon;
	}
	
	private static Image getImage(final String resource) {
		try {
			return ImageIO.read(Constants.class
					.getResource(resource));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static ImageIcon getIconImage(final String resource) {
		try {
			return new ImageIcon(Constants.class
					.getResource(resource));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

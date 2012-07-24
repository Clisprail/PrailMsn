package com.para.data;

import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import net.sf.jml.Email;
import net.sf.jml.MsnMessenger;

import com.para.gui.ChatWindow;
import com.para.listeners.MsnListener;

public class Constants {
	
	public static MsnMessenger messenger = null;
	
	public static final DefaultListModel model = new DefaultListModel();
	
	public static final MsnListener listener = new MsnListener();
	
	public static JFrame loader = null;
	
	public static HashMap<Email, ChatWindow> chats = new HashMap<Email, ChatWindow>();

}

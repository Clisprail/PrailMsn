package com.para.utils;

import com.para.data.Constants;
import com.para.data.Log;
import com.para.gui.ChatWindow;

import net.sf.jml.Email;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnSwitchboard;

/**
 * 
 * @author Clisprail
 *
 */
public class Msn {
	
	public static void openChat(final Email email) {
		if(Constants.chats.get(email) == null) {
			final ChatWindow window = new ChatWindow();
			Constants.chats.put(email, window);
			window.setTitle(email.getEmailAddress());
			window.setVisible(true);
		}
	}
	
	public static void openChat(final String str) {
		openChat(Email.parseStr(str));
	}
	
	public static void sendMessage(final String email, final String message) {
		sendMessage(Email.parseStr(email), message);
	}
	
	public static void sendMessage(final Email email, final String message) {
		final MsnMessenger messenger = Constants.messenger;
		final MsnSwitchboard[] boards = messenger.getActiveSwitchboards();
		for(final MsnSwitchboard board : boards) {
			for(final MsnContact c : board.getAllContacts()) {
				if(c.getEmail().equals(email)) {
					Log.print("Sending message: " + email.toString() + " " + message);
					board.sendText(message);
					return;
				}
			}
		}
		Log.print("Sending message: " + email.toString() + " " + message);
		messenger.sendText(email, message);
	}
	
	public static void messageRecieved(final Email email, final MsnContact contact, final String message) {
		ChatWindow window = null;
		if(Constants.chats.get(email) == null) {
			window = new ChatWindow();
			Constants.chats.put(email, window);
			window.setTitle(email.getEmailAddress());
			window.setVisible(true);
		}
		window = window == null ? Constants.chats.get(email) : window;
		if(!window.isVisible()) {
			// user closed chat
			window.setVisible(true);
		}
		final String newline = window.jTextArea1.getText().isEmpty() ? "" : "\n";
		window.jTextArea1.setText(window.jTextArea1.getText() + newline + contact.getFriendlyName() + ": " + message);
	}

}

<<<<<<< HEAD
package com.para.utils;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import net.sf.jml.Email;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.MsnUserStatus;

import com.para.data.Constants;
import com.para.data.Log;
import com.para.gui.ChatWindow;

/**
 * 
 * @author Clisprail
 * 
 */
public class Msn {

	public static void openChat(final Email email) {
		if (Constants.chats.get(email) == null) {
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					final ChatWindow window = new ChatWindow();
					Constants.chats.put(email, window);
					window.initFrame(getContact(email).getDisplayName(), email.getEmailAddress());
					window.setVisible(true);
				}

			});
		}
	}
	
	public static ImageIcon getStatusImage(final String email) {
		final MsnContact c = getContact(email);
		final MsnUserStatus status = c.getStatus();
		if(status.equals(MsnUserStatus.ONLINE)) {
			return Constants.online;
		}
		if(status.equals(MsnUserStatus.BUSY)) {
			return Constants.busy;
		}
		if(status.equals(MsnUserStatus.AWAY)) {
			return Constants.away;
		}
		return null;
	}

	public static void setStatus(final MsnUserStatus status) {
		getMessenger().getOwner().setStatus(status);
	}

	public static MsnContact getContact(String email) {
		return getContact(Email.parseStr(email));
	}

	public static MsnContact getContact(Email email) {
		final MsnMessenger m = Constants.messenger;
		return m.getContactList().getContactByEmail(email);
	}

	public static MsnSwitchboard getSwitchboard(final String email) {
		return getSwitchboard(Email.parseStr(email));
	}

	public static MsnSwitchboard getSwitchboard(final Email email) {
		final MsnMessenger messenger = Constants.messenger;
		final MsnSwitchboard[] boards = messenger.getActiveSwitchboards();
		for (final MsnSwitchboard board : boards) {
			for (final MsnContact c : board.getAllContacts()) {
				if (c.getEmail().equals(email)) {
					return board;
				}
			}
		}
		// TODO
		messenger.sendText(email, "");
		return null;
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
		for (final MsnSwitchboard board : boards) {
			for (final MsnContact c : board.getAllContacts()) {
				if (c.getEmail().equals(email)) {
					Log.print("Sending message: " + email.toString() + " "
							+ message);
					board.sendText(message);
					return;
				}
			}
		}
		Log.print("Sending message: " + email.toString() + " " + message);
		messenger.sendText(email, message);
	}

	public static void messageRecieved(final Email email,
			final MsnContact contact, final String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ChatWindow window = null;
				if (Constants.chats.get(email) == null) {
					window = new ChatWindow();
					Constants.chats.put(email, window);
					window.initFrame(contact.getDisplayName(), email.getEmailAddress());
					window.setVisible(true);
				}
				window = window == null ? Constants.chats.get(email) : window;
				if (!window.isVisible()) {
					// user closed chat
					window.setVisible(true);
				}
				window.addMessage(contact.getFriendlyName(), message);

			}

		});
	}

	public static MsnMessenger getMessenger() {
		return Constants.messenger;
	}

	public static String getName() {
		return getUpperCase(getMessenger().getOwner().getDisplayName());
	}

	private static String getUpperCase(String name) {
		char[] stringArray = name.toCharArray();
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		return new String(stringArray);
	}

}
=======
package com.para.utils;

import net.sf.jml.Email;
import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnSwitchboard;

import com.para.data.Constants;
import com.para.data.Log;
import com.para.gui.ChatWindow;

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
	
	public static MsnContact getContact(String email) {
		return getContact(Email.parseStr(email));
	}
	
	public static MsnContact getContact(Email email) {
		final MsnMessenger m = Constants.messenger;
		return m.getContactList().getContactByEmail(email);
	}
	
	
	public static MsnSwitchboard getSwitchboard(final String email) {
		return getSwitchboard(Email.parseStr(email));
	}
	
	public static MsnSwitchboard getSwitchboard(final Email email) {
		final MsnMessenger messenger = Constants.messenger;
		final MsnSwitchboard[] boards = messenger.getActiveSwitchboards();
		for(final MsnSwitchboard board : boards) {
			for(final MsnContact c : board.getAllContacts()) {
				if(c.getEmail().equals(email)) {
					return board;
				}
			}
		}
		// TODO
		messenger.sendText(email, "");
		return null;
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
>>>>>>> e5762aef637ade1a0595bb2613349fad89875938

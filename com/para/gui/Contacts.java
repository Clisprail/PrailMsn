<<<<<<< HEAD
package com.para.gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnUserStatus;

import com.para.data.Constants;
import com.para.utils.Msn;

public class Contacts {
	public static ArrayList<String> contactList = new ArrayList<String>();
	
	public static void update() {
		final DefaultListModel model = new DefaultListModel();
		for(final String email : contactList) {
			final MsnContact c = Msn.getContact(email);
			model.addElement(c.getDisplayName() + " - " + c.getEmail().getEmailAddress());
		}
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				IconListRenderer r = Constants.listRenderer;
				if(r == null) {
					r = new IconListRenderer();
					Constants.listRenderer = r;
				}
				getList().setCellRenderer(r);
				getList().setModel(model);
			}
			
		});
	}
	
	private static JList getList() {
		return MessengerInterface.jList1;
	}
	
	public static void add(final String email) {
		if(contactList.contains(email)) {
			return;
		}
		contactList.add(email);
		update();
	}
	
	public static void remove(final String email) {
		contactList.remove(email);
		update();
	}
	
	public static void addAll() {
		final MsnMessenger messenger = Constants.messenger;
		for(MsnContact c : messenger.getContactList().getContacts()) {
			if(!c.getStatus().equals(MsnUserStatus.OFFLINE)) {
				if(contactList.contains(c.getEmail().getEmailAddress())) {
					continue;
				}
				contactList.add(c.getEmail().getEmailAddress());
			}
		}
		update();
	}
	
	public static void typingMessage(String email) {
		// called when user is typing message to you
		// TODO
	}
 	
	

}
=======
package com.para.gui;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnUserStatus;

import com.para.data.Constants;
import com.para.utils.Msn;

public class Contacts {
	public static ArrayList<String> contactList = new ArrayList<String>();
	
	public static void update() {
		final DefaultListModel model = new DefaultListModel();
		for(final String email : contactList) {
			final MsnContact c = Msn.getContact(email);
			model.addElement(c.getDisplayName() + " - " + c.getEmail().getEmailAddress());
		}
		getList().setModel(model);
	}
	
	private static JList getList() {
		return MessengerInterface.jList1;
	}
	
	public static void add(final String email) {
		contactList.add(email);
		update();
	}
	
	public static void remove(final String email) {
		contactList.remove(email);
		update();
	}
	
	public static void addAll() {
		final MsnMessenger messenger = Constants.messenger;
		for(MsnContact c : messenger.getContactList().getContacts()) {
			if(!c.getStatus().equals(MsnUserStatus.OFFLINE)) {
				contactList.add(c.getEmail().getEmailAddress());
			}
		}
		update();
	}
	
	public static void typingMessage(String email) {
		// called when user is typing message to you
	}
 	
	

}
>>>>>>> e5762aef637ade1a0595bb2613349fad89875938

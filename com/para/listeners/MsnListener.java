package com.para.listeners;

import com.para.data.Constants;
import com.para.data.Log;
import com.para.gui.Contacts;
import com.para.gui.MessengerInterface;
import com.para.utils.Msn;

import net.sf.jml.MsnContact;
import net.sf.jml.MsnContactPending;
import net.sf.jml.MsnFileTransfer;
import net.sf.jml.MsnGroup;
import net.sf.jml.MsnList;
import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnSwitchboard;
import net.sf.jml.event.MsnContactListListener;
import net.sf.jml.event.MsnEmailListener;
import net.sf.jml.event.MsnFileTransferListener;
import net.sf.jml.event.MsnMessageListener;
import net.sf.jml.event.MsnMessengerListener;
import net.sf.jml.event.MsnSwitchboardListener;
import net.sf.jml.message.MsnControlMessage;
import net.sf.jml.message.MsnDatacastMessage;
import net.sf.jml.message.MsnEmailActivityMessage;
import net.sf.jml.message.MsnEmailInitEmailData;
import net.sf.jml.message.MsnEmailInitMessage;
import net.sf.jml.message.MsnEmailNotifyMessage;
import net.sf.jml.message.MsnInstantMessage;
import net.sf.jml.message.MsnSystemMessage;
import net.sf.jml.message.MsnUnknownMessage;
import net.sf.jml.message.p2p.MsnP2PMessage;

/**
 * 
 * @author Clisprail
 *
 */
public class MsnListener implements MsnContactListListener, MsnEmailListener,
		MsnMessageListener, MsnMessengerListener, MsnFileTransferListener,
		MsnSwitchboardListener {

	@Override
	public void contactAddCompleted(MsnMessenger arg0, MsnContact arg1,
			MsnList arg2) {

	}

	@Override
	public void contactAddInGroupCompleted(MsnMessenger arg0, MsnContact arg1,
			MsnGroup arg2) {

	}

	@Override
	public void contactAddedMe(MsnMessenger m, MsnContact c) {
		Log.print(c.getEmail().toString() + " added you.");
		m.addFriend(c.getEmail(), c.getEmail().toString());

	}

	@Override
	public void contactAddedMe(MsnMessenger m, MsnContactPending[] arr) {
		for (MsnContactPending c : arr) {
			Log.print(c.getEmail().toString() + " added you.");
			m.addFriend(c.getEmail(), c.getEmail().toString());
		}

	}

	@Override
	public void contactListInitCompleted(MsnMessenger m) {
		Log.print("contactListInitCompleted");
		Contacts.addAll();
	}

	@Override
	public void contactListSyncCompleted(MsnMessenger m) {
		
	}

	@Override
	public void contactPersonalMessageChanged(MsnMessenger arg0, MsnContact arg1) {

	}

	@Override
	public void contactRemoveCompleted(MsnMessenger arg0, MsnContact arg1,
			MsnList arg2) {

	}

	@Override
	public void contactRemoveFromGroupCompleted(MsnMessenger arg0,
			MsnContact arg1, MsnGroup arg2) {

	}

	@Override
	public void contactRemovedMe(MsnMessenger arg0, MsnContact arg1) {

	}

	@Override
	public void contactStatusChanged(MsnMessenger arg0, MsnContact arg1) {

	}

	@Override
	public void groupAddCompleted(MsnMessenger arg0, MsnGroup arg1) {

	}

	@Override
	public void groupRemoveCompleted(MsnMessenger arg0, MsnGroup arg1) {

	}

	@Override
	public void ownerDisplayNameChanged(MsnMessenger arg0) {

	}

	@Override
	public void ownerStatusChanged(MsnMessenger arg0) {

	}

	@Override
	public void activityEmailNotificationReceived(MsnSwitchboard arg0,
			MsnEmailActivityMessage arg1, MsnContact arg2) {

	}

	@Override
	public void initialEmailDataReceived(MsnSwitchboard arg0,
			MsnEmailInitEmailData arg1, MsnContact arg2) {

	}

	@Override
	public void initialEmailNotificationReceived(MsnSwitchboard arg0,
			MsnEmailInitMessage arg1, MsnContact arg2) {

	}

	@Override
	public void newEmailNotificationReceived(MsnSwitchboard arg0,
			MsnEmailNotifyMessage arg1, MsnContact arg2) {

	}

	@Override
	public void controlMessageReceived(MsnSwitchboard arg0,
			MsnControlMessage arg1, MsnContact arg2) {

	}

	@Override
	public void datacastMessageReceived(MsnSwitchboard arg0,
			MsnDatacastMessage arg1, MsnContact arg2) {

	}

	@Override
	public void instantMessageReceived(MsnSwitchboard switchboard,
			MsnInstantMessage message, MsnContact contact) {
		Log.print(contact.getDisplayName() + " " + message.getContent());
		Msn.messageRecieved(contact.getEmail(), contact, message.getContent());
	}

	@Override
	public void offlineMessageReceived(String arg0, String arg1, String arg2,
			MsnContact arg3) {

	}

	@Override
	public void p2pMessageReceived(MsnSwitchboard arg0, MsnP2PMessage arg1,
			MsnContact arg2) {

	}

	@Override
	public void systemMessageReceived(MsnMessenger arg0, MsnSystemMessage arg1) {

	}

	@Override
	public void unknownMessageReceived(MsnSwitchboard arg0,
			MsnUnknownMessage arg1, MsnContact arg2) {

	}

	@Override
	public void exceptionCaught(MsnMessenger arg0, Throwable arg1) {

	}

	@Override
	public void loginCompleted(MsnMessenger messenger) {
		Log.print("Logged " + messenger.getOwner().getEmail().toString()
				+ " in.");
		Constants.loader.dispose();
		new MessengerInterface().setVisible(true);
		Constants.messenger = messenger;
	}

	@Override
	public void logout(MsnMessenger arg0) {

	}

	@Override
	public void contactJoinSwitchboard(MsnSwitchboard arg0, MsnContact arg1) {

	}

	@Override
	public void contactLeaveSwitchboard(MsnSwitchboard arg0, MsnContact arg1) {

	}

	@Override
	public void switchboardClosed(MsnSwitchboard arg0) {

	}

	@Override
	public void switchboardStarted(MsnSwitchboard arg0) {

	}

	@Override
	public void fileTransferFinished(MsnFileTransfer f) {

	}

	@Override
	public void fileTransferProcess(MsnFileTransfer f) {

	}

	@Override
	public void fileTransferRequestReceived(MsnFileTransfer f) {
		f.start();
	}

	@Override
	public void fileTransferStarted(MsnFileTransfer arg0) {

	}

}

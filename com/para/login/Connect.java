package com.para.login;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.para.data.Constants;
import com.para.gui.Center;
import com.para.listeners.MsnListener;

import net.sf.jml.MsnMessenger;
import net.sf.jml.MsnProtocol;
import net.sf.jml.impl.MsnMessengerFactory;

/**
 * 
 * @author Clisprail
 *
 */
public class Connect {
	
	public Connect(final String username, final String password) {
		MsnMessenger messenger = MsnMessengerFactory.createMsnMessenger(username, password);
		messenger.setSupportedProtocol(new MsnProtocol[] { MsnProtocol.MSNP12 });
		messenger.setLogIncoming(false);
		messenger.setLogOutgoing(false);
		final MsnListener listener = Constants.listener;
		messenger.addContactListListener(listener);
		messenger.addEmailListener(listener);
		messenger.addFileTransferListener(listener);
		messenger.addMessageListener(listener);
		messenger.addMessengerListener(listener);
		messenger.addSwitchboardListener(listener);
		messenger.login();
		loader();
	}
	
	public void loader() {
		final JFrame frame = new JFrame("Para msn");
		JLabel label1 = new JLabel("Logging in...");
		frame.setResizable(false);
		frame.add(label1);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		new Center(frame, 250, 65);
		frame.setVisible(true);
		Constants.loader = frame;
	}

}

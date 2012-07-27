package com.para.login;

import javax.swing.SwingUtilities;

import com.para.data.Constants;
import com.para.gui.Loader;
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
		messenger.getOwner().setInitDisplayName(username.split("@")[0]);
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
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Loader().setVisible(true);
			}
			
		});
	}

}

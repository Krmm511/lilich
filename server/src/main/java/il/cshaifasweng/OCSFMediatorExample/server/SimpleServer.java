package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;

import java.io.IOException;
import java.util.List;

import il.cshaifasweng.OCSFMediatorExample.entities.Item;
import il.cshaifasweng.OCSFMediatorExample.database.Database; //***to implement***

public class SimpleServer extends AbstractServer {

	public SimpleServer(int port) {
		super(port);
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		if (msg == null) return;

		String msgString = msg.toString();
		String[] parts = msgString.split(" ");

		try {
			switch (parts[0]) {
				case "#catalog" -> {
					List<Item> items = Database.getAllItems();
					client.sendToClient(items);
				}
				case "#item" -> {
					if (parts.length >= 2) {
						int itemId = Integer.parseInt(parts[1]);
						Item item = Database.getItemById(itemId);
						client.sendToClient(item);
					}
				}
				case "#update" -> {
					if (parts.length >= 3) {
						int itemId = Integer.parseInt(parts[1]);
						double newPrice = Double.parseDouble(parts[2]);
						Database.updateItemPrice(itemId, newPrice);
						List<Item> updatedItems = Database.getAllItems();
						client.sendToClient(updatedItems);
					}
				}
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

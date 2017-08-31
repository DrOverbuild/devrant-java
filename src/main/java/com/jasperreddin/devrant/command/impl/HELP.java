package com.jasperreddin.devrant.command.impl;

import com.jasperreddin.devrant.DevRantClient;
import com.jasperreddin.devrant.command.Command;

public class HELP implements Command {
	DevRantClient client;

	public HELP(DevRantClient client){
		this.client = client;
	}

	@Override
	public boolean execute(String[] args) {
		if(args.length == 1){
			Command c = client.getParser().parseCommand(args[0]);
			if (c == null){
				client.println("Unknown command.");
				return true;
			}

			client.println("");

			if (c.getName().equalsIgnoreCase(c.getShortcut())){
				client.println(c.getName());
			} else {
				client.println(c.getName() + " or " + c.getShortcut());
			}

			client.println(c.getDesc());
			client.println("Usage: " + c.getUsage());
			client.println("");
			return true;
		}

		for(Command c:client.getParser().getCommands()){
			client.println(c.getName()+": "+c.getDesc());
		}

		return true;
	}

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public String getShortcut() {
		return "help";
	}

	@Override
	public String getUsage() {
		return "help or help <command>";
	}

	@Override
	public String getDesc() {
		return "Lists all the commands or gives information about a specific command.";
	}

}

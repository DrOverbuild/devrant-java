package com.jasperreddin.devrant.command;

import com.jasperreddin.devrant.DevRantClient;
import com.jasperreddin.devrant.command.impl.HELP;
import com.jasperreddin.devrant.command.impl.RANTS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {
	List<Command> commands = new ArrayList<>();
	DevRantClient client;

	public CommandParser(DevRantClient client) {
		this.client = client;

		addCommand(new HELP(client));
		addCommand(new RANTS(client.getDevRant(), client));
	}

	public Command parseCommand(String str){
		// Get first word of string
		String commandString = str.split(" ")[0];

		// Find the command
		for(Command c : commands){
			if(commandString.equalsIgnoreCase(c.getName())||commandString.equalsIgnoreCase(c.getShortcut())){
				return c;
			}
		}
		return null;
	}

	public static String[] parseArgs(String userInput){
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(userInput.split("\\s")));

		list.remove(0);

		String[] args = new String[list.size()];

		return list.toArray(args);
	}

	public void onCommand(String txt){
		Command command = parseCommand(txt);

		if(command == null){
			client.println("Unknown command. Type /help for a list of commands.");

//			TerminalIRC.printlnWithoutStashing("Unknown command. Type /help for a list of commands.");
			return;
		}

		String[] args = parseArgs(txt);

		try {
			if (!command.execute(args)) {
				client.println("Usage: " + command.getUsage());
//			TerminalIRC.printlnWithoutStashing("Usage: " + command.getUsage());
			}
		} catch (Exception e){
			client.println("Exception executing command.");
			e.printStackTrace();
		}
	}

	public void addCommand(Command command){
		commands.add(command);
	}

	public List<Command> getCommands() {
		return commands;
	}
}

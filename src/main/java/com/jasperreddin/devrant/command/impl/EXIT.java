package com.jasperreddin.devrant.command.impl;

import com.jasperreddin.devrant.command.Command;

public class EXIT implements Command {
	@Override
	public boolean execute(String[] args) {
		System.exit(0);

		return true;
	}

	@Override
	public String getName() {
		return "exit";
	}

	@Override
	public String getShortcut() {
		return "quit";
	}

	@Override
	public String getUsage() {
		return "quit or exit";
	}

	@Override
	public String getDesc() {
		return "Exits out of Devrant-Java";
	}
}

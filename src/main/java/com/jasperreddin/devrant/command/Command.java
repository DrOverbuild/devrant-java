package com.jasperreddin.devrant.command;

import com.jasperreddin.devrant.DevRantClient;

public interface Command {
	boolean execute(String[] args);

	String getName();
	String getShortcut();
	String getUsage();
	String getDesc();
}

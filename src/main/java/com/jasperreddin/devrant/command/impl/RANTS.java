package com.jasperreddin.devrant.command.impl;

import com.jasperreddin.devrant.DevRantClient;
import com.jasperreddin.devrant.command.Command;
import com.scorpiac.javarant.DevRant;
import com.scorpiac.javarant.Range;
import com.scorpiac.javarant.Rant;
import com.scorpiac.javarant.Sort;

import java.util.List;
import java.util.Optional;

public class RANTS implements Command {
	DevRant devRant;
	DevRantClient client;

	public RANTS(DevRant devRant, DevRantClient client) {
		this.devRant = devRant;
		this.client = client;
	}

	@Override
	public boolean execute(String[] args) {
		Sort sort = Sort.RECENT;
		int amount = 10;
		int page = 0;
		Range range = null;

		boolean top = false;

		if (args.length >= 1) {
			sort = parseSort(args[0]);

			if (args[0].equalsIgnoreCase("top")) {
				top = true;
			}
		}

		if (args.length >= 2) {
			try {
				amount = Integer.parseInt(args[1]);
			} catch (NumberFormatException e){
				range = parseRange(args[1]);
			}
		}

		if (args.length >= 3) {
			try {
				page = Integer.parseInt(args[2]);
			} catch (NumberFormatException e){
				range = parseRange(args[1]);
			}
		}

		if (args.length >= 4) {
			range = parseRange(args[3]);
		}

		if (top) {
			if (range == null) {
				return false;
			}

			sort = Sort.TOP;
		}

		client.println("Getting rants...");
		client.println("Sorting by " + sort);

		List<Rant> rants;

		Optional<List<Rant>> rantsOpt = devRant.getFeed().getRants(sort,amount,page);

		if (rantsOpt.isPresent()){
			rants = rantsOpt.get();
		} else {
			client.println("Unable to get rants.");
			return true;
		}

		client.println("Fetched " + rants.size() + " rants.");

//		if (rants.size() > 0) {
//			client.println("USER: " + rants.get(0).getUser() + " ID: " + rants.get(0).getId());
//			client.println("SCORE: " + rants.get(0).getScore() + " VOTE STATE: " + rants.get(0).getVoteState());
//			client.println("COMMENTS: " + rants.get(0).getCommentCount() + " LINK: " + rants.get(0).getLink());
//		}

		for (Rant rant : rants) {
			StringBuilder message = new StringBuilder();
			if (rant.getUser() != null) {
				message.append(" - From ").append(rant.getUser().getUsername()).append(": ");
			}
			String content = rant.getText();

			int maxCharCount = client.getTerminal().getWidth() - message.length() - 3;

			content = content.replace('\n',' ');

			if (content.length() > maxCharCount) {
				content = content.substring(0, maxCharCount - 1);
				message.append(content).append("...");
			} else {
				message.append(content);
			}

			client.println(message.toString());
		}

		return true;
	}

	public Sort parseSort(String str){
		switch (str.toLowerCase()){
			case "algo":
				return Sort.ALGO;
			case "recent":
				return Sort.RECENT;
			default:
				return null;
		}
	}

	public Range parseRange(String str){
		return Range.valueOf(str.toUpperCase());
	}

	@Override
	public String getName() {
		return "rants";
	}

	@Override
	public String getShortcut() {
		return "r";
	}

	@Override
	public String getUsage() {
		return "rant [algo|recent|top] <amount> <page> [day|week|month|all]";
	}

	@Override
	public String getDesc() {
		return "List rants by algorithm, recent, or top. Params:\n - amount: amount per page\n - page: page to view (starting at 0)";
	}
}

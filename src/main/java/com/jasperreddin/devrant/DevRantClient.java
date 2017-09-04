package com.jasperreddin.devrant;

import com.jasperreddin.devrant.command.CommandParser;
import com.scorpiac.javarant.DevRant;
import com.scorpiac.javarant.News;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.Optional;

public class DevRantClient {

	public static DevRantClient INSTANCE;

	Terminal terminal;
	LineReader lineReader;

	DevRant devRant;

	CommandParser parser;

	public static void main(String[] args) {
		INSTANCE = new DevRantClient();
		INSTANCE.run();
	}

	public DevRantClient() {
		try {
			this.terminal = TerminalBuilder.terminal();
			this.lineReader = LineReaderBuilder.builder().terminal(this.terminal)
					.appName("DevRant Java Client").build();
		} catch (IOException e) {
			System.out.println("Error initializing JLine. Exiting program...");
			System.exit(0);
		}

		this.devRant = new DevRant();
		this.parser = new CommandParser(this);
	}

	public void run() {

		ASCIIArt.printDRJ(this);

		println("");

		println("Welcome to DevRant Java, a terminal client written in Java.");
		println("Loading MOTD...");
		println("");

		Optional<News> newsOP = devRant.getFeed().getNews();

		if (newsOP.isPresent()){
			News news = newsOP.get();
			println(news.getHeadline());
			println(news.getBody());
			println(news.getFooter());
		} else {
			println("Unable to unwrap MOTD");
		}

		println("");

		while (true) {
			String line = lineReader.readLine("devrant > ");

			if (line == null || line.isEmpty()) {
				continue;
			}

			line = line.trim();

			parser.onCommand(line);
		}
	}

	public void println(String str){
		getTerminal().writer().println(str);
		getTerminal().writer().flush();
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public LineReader getLineReader() {
		return lineReader;
	}

	public DevRant getDevRant() {
		return devRant;
	}

	public CommandParser getParser() {
		return parser;
	}
}

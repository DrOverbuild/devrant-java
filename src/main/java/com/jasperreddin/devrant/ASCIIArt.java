package com.jasperreddin.devrant;

public class ASCIIArt {

	public static void printDRJ(DevRantClient client) {
		int width = client.terminal.getWidth();
		if (width >= 100) {
			printDRJLarge(client);
			return;
		}

		if (width >=75) {
			printDRJMed(client);
			return;
		}

		if (width >=45 ) {
			printDRJSmall(client);
			return;
		}

		printDRJTiny(client);
	}

	/**
	 * For terminals 100 characters or greater in width
	 * @param client
	 */
	public static void printDRJLarge(DevRantClient client) {
		client.println("");
		client.println(" 88888888ba,   88888888888 8b           d8 88888888ba         db        888b      88 888888888888");
		client.println(" 88      `\"8b  88          `8b         d8' 88      \"8b       d88b       8888b     88      88");
		client.println(" 88        `8b 88           `8b       d8'  88      ,8P      d8'`8b      88 `8b    88      88");
		client.println(" 88         88 88aaaaa       `8b     d8'   88aaaaaa8P'     d8'  `8b     88  `8b   88      88");
		client.println(" 88         88 88\"\"\"\"\"        `8b   d8'    88\"\"\"\"88'      d8YaaaaY8b    88   `8b  88      88");
		client.println(" 88         8P 88              `8b d8'     88    `8b     d8\"\"\"\"\"\"\"\"8b   88    `8b 88      88");
		client.println(" 88      .a8P  88               `888'      88     `8b   d8'        `8b  88     `8888      88");
		client.println(" 88888888Y\"'   88888888888       `8'       88      `8b d8'          `8b 88      `888      88");
		client.println("");
		client.println("");
		client.println("");
		client.println("             88       db  8b           d8  db");
		client.println("             88      d88b `8b         d8' d88b");
		client.println("             88     d8'`8b `8b       d8' d8'`8b");
		client.println("             88    d8'  `8b `8b     d8' d8'  `8b");
		client.println("             88   d8YaaaaY8b `8b   d8' d8YaaaaY8b");
		client.println("             88  d8\"\"\"\"\"\"\"\"8b `8b d8' d8\"\"\"\"\"\"\"\"8b");
		client.println("     88,   ,d88 d8'        `8b `888' d8'        `8b");
		client.println("       Y8888P\" d8'          `8b `8' d8'          `8b");
	}

	/**
	 * For terminals 75 characters to 99 characters in width
	 * @param client
	 */
	public static void printDRJMed(DevRantClient client) {
		client.println("  888888ba   88888888b dP     dP  888888ba   .d888888  888888ba  d888888P ");
		client.println("  88    `8b  88        88     88  88    `8b d8'    88  88    `8b    88    ");
		client.println("  88     88 a88aaaa    88    .8P a88aaaa8P' 88aaaaa88a 88     88    88    ");
		client.println("  88     88  88        88    d8'  88   `8b. 88     88  88     88    88    ");
		client.println("  88    .8P  88        88  .d8P   88     88 88     88  88     88    88    ");
		client.println("  8888888P   88888888P 888888'    dP     dP 88     88  dP     dP    dP    ");
		client.println("                                                                        ");
		client.println("                                                                        ");
		client.println("         dP  .d888888  dP     dP  .d888888  ");
		client.println("         88 d8'    88  88     88 d8'    88  ");
		client.println("         88 88aaaaa88a 88    .8P 88aaaaa88a ");
		client.println("         88 88     88  88    d8' 88     88  ");
		client.println("  88.  .d8P 88     88  88  .d8P  88     88  ");
		client.println("   `Y8888'  88     88  888888'   88     88  ");
	}

	/**
	 * For terminals 45 characters to 74 characters in width
	 * @param client
	 */
	public static void printDRJSmall(DevRantClient client) {
		client.println("   ___  _____   _____    _   _  _ _____  ");
		client.println("  |   \\| __\\ \\ / / _ \\  /_\\ | \\| |_   _| ");
		client.println("  | |) | _| \\ \\V /|   / / _ \\| .` | | |   ");
		client.println("  |___/|___| \\_/ |_|_\\/_/ \\_\\_|\\_| |_|   ");
		client.println("                                         ");
		client.println("      _  ___   ___    ");
		client.println("   _ | |/_\\ \\ / /_\\   ");
		client.println("  | || / _ \\ V / _ \\  ");
		client.println("   \\__/_/ \\_\\_/_/ \\_\\ ");
	}

	/**
	 * Honestly nobody should have a terminal this small.
	 * @param client
	 */
	public static void printDRJTiny(DevRantClient client) {
		client.println("");
		client.println("  DEVRANT");
		client.println("  JAVA");
		client.println("");
	}
}

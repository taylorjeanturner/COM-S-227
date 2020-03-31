package hw1;

/**
 * This class represents a wireless printer.
 * 
 * @author Taylor Turner
 */
public class WirelessPrinter {
	/**
	 * Number of pages per ink cartridge
	 */
	public static final int PAGES_PER_CARTRIDGE = 1000;
	/**
	 * Amount of paper the tray can hold
	 */
	public static final int TRAY_CAPACITY = 500;
	/**
	 * Ink level of a new cartridge
	 */
	public static final double NEW_CARTRIDGE_INK_LEVEL = 1.0;
	/**
	 * Connection status of printer
	 */
	private boolean isConnect;
	/**
	 * Current ink level of printer
	 */
	private double inkLevel;
	/**
	 * Current paper level of printer
	 */
	private int paperLevel;
	/**
	 * Number of pages printed
	 */
	private int totalPagesPrinted;
	/**
	 * Total amount of paper used
	 */
	private int totalPaperUsed;
	/**
	 * Power status of printer
	 */
	private boolean isOn;

	/**
	 * Create a new printer.
	 */
	public WirelessPrinter() {
		inkLevel = NEW_CARTRIDGE_INK_LEVEL / 2;
		paperLevel = 0;
		totalPaperUsed = 0;
		totalPagesPrinted = 0;
		isOn = false;
		isConnect = false;
	}

	/**
	 * Create a new printer with a specified amount of ink and paper.
	 */
	public WirelessPrinter(double ink, int paper) {
		inkLevel = Math.min(ink, NEW_CARTRIDGE_INK_LEVEL);
		paperLevel = Math.min(paper, TRAY_CAPACITY);
		totalPaperUsed = 0;
		totalPagesPrinted = 0;
		isOn = false;
		isConnect = false;

	}

	/**
	 * Connects the printer to the network.
	 */
	public void connect() {
		isConnect = true;
	}

	/**
	 * Disconnects the printer to the network.
	 */
	public void disconnect() {
		isConnect = false;
	}

	/**
	 * Returns the current ink level.
	 * 
	 * @return ink level of printer
	 */
	public double getInkLevel() {
		return Math.round(inkLevel * 100.0) / 100.0;
	}

	/**
	 * Returns the current paper level in a percentage.
	 * 
	 * @return paper level of printer in a percentage
	 */
	public int getPaperLevel() {
		int paperLevelPercent = (int) ((paperLevel * 1.0 / TRAY_CAPACITY) * 100);
		return paperLevelPercent;
	}

	/**
	 * Returns the exact paper level.
	 * 
	 * @return exact paper level
	 */
	public int getPaperLevelExact() {
		return paperLevel;
	}

	/**
	 * Returns the total number of pages printed with full ink.
	 * 
	 * @return total number of pages printed
	 */
	public int getTotalPagesPrinted() {
		return totalPagesPrinted;
	}

	/**
	 * Returns the total number of pages of papers used.
	 * 
	 * @return total number of used pages
	 */
	public int getTotalPaperUsed() {
		return totalPaperUsed;
	}

	/**
	 * Returns the status of current wireless connection.
	 * 
	 * @return true if printer is connected, false otherwise
	 */
	public boolean isConnected() {
		return isConnect;
	}

	/**
	 * Returns the power status of the printer
	 * 
	 * @return true if printer is on, false otherwise
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * Loads number of pages into the printer
	 * 
	 * @param pages number of pages to load
	 */
	public void loadPaper(int pages) {
		paperLevel = Math.min(paperLevel + pages, TRAY_CAPACITY);

	}

	/**
	 * Prints certain number of pages
	 * 
	 * @param pages number of pages to print
	 */
	public void print(int pages) {
		if (!isConnected())
			return;

		int paperPrinted = Math.min(pages, paperLevel);
		paperLevel = paperLevel - paperPrinted;
		inkLevel = inkLevel - Math.min(inkLevel, paperPrinted * 0.001);
		totalPagesPrinted = totalPagesPrinted + paperPrinted;
		totalPaperUsed = totalPaperUsed + paperPrinted;
	}

	/**
	 * Replaces the ink cartridge
	 */
	public void replaceCartridge() {
		inkLevel = NEW_CARTRIDGE_INK_LEVEL;
	}

	/**
	 * Turns off printer
	 */
	public void turnOff() {
		isConnect = false;
		isOn = false;
	}

	/**
	 * Turns on printer
	 */
	public void turnOn() {
		isConnect = true;
		isOn = true;
	}
}

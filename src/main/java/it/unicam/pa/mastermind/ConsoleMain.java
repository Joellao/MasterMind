package it.unicam.pa.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import it.unicam.pa.mastermind.breaker.CodeBreaker;
import it.unicam.pa.mastermind.maker.CodeMaker;
import it.unicam.pa.mastermind.view.ConsoleView;

/**
 * Responsabilità: Punto di avvio del programma, gestisce l'input iniziale componendo i parametri di gioco
 * @author joel
 *
 */
public class ConsoleMain {

	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private int playersNumber = 2;
	private int attempts = 9;
	private int codeLength = 4;
	private int colorLength = 8;
	private List<CodeMaker> cmList = new ArrayList<CodeMaker>();
	private List<CodeBreaker> cbList = new ArrayList<CodeBreaker>();

	public ConsoleMain() throws IOException {
		printTitle();
		getPlayerNumber();
		getAttemptsNumber();
		getColorLengthNumber();
		getCodeLengthNumber();
		getMakerType();
		getBreakerType();

	}

	public static void main(String[] args) throws IOException {
		new ConsoleMain().startGame();
	}

	private void startGame() {
		GameManager gm = new GameManager(this.cbList, this.cmList, this.codeLength, this.colorLength);
		gm.play(new ConsoleView(this.colorLength));
	}

	private void printTitle() {
		System.out.println("                  _                  _           _ \r\n"
				+ "  /\\/\\   __ _ ___| |_ ___ _ __ /\\/\\ (_)_ __   __| |\r\n"
				+ " /    \\ / _` / __| __/ _ \\ '__/    \\| | '_ \\ / _` |\r\n"
				+ "/ /\\/\\ \\ (_| \\__ \\ ||  __/ | / /\\/\\ \\ | | | | (_| |\r\n"
				+ "\\/    \\/\\__,_|___/\\__\\___|_| \\/    \\/_|_| |_|\\__,_|\r\n"
				+ "              [Made with <3 by Joel]\r\n" + "                                                   ");
	}

	/**
	 * 
	 * @return Linea di input
	 * @throws IOException
	 */
	private String returnLine() throws IOException {
		String line = input.readLine();
		return line;
	}

	/**
	 * 
	 * @return Un intero da una linea
	 * @throws IOException
	 */
	private int returnNumberFromLine() throws IOException {
		return (Integer.parseInt(returnLine()));
	}

	private void getPlayerNumber() throws IOException {
		System.out.print("Inserisci il numero dei giocatori (default: " + this.playersNumber + "): ");
		try {
			this.playersNumber = returnNumberFromLine();
		} catch (NumberFormatException e) {
		}

	}

	private void getAttemptsNumber() throws IOException {
		System.out.print("Inserisci il numero dei tentativi (default:" + this.attempts + "): ");
		try {
			this.attempts = returnNumberFromLine();
		} catch (NumberFormatException e) {
		}

	}

	private void getCodeLengthNumber() throws IOException {
		System.out.print("Inserisci la lunghezza del codice (default: " + this.codeLength + "): ");
		try {
			this.codeLength = returnNumberFromLine();
		} catch (NumberFormatException e) {
		}

	}

	private void getColorLengthNumber() throws IOException {
		System.out.print("Inserisci la lunghezza dei colori (default: " + this.colorLength + ") (1-8): ");
		try {
			int numero = returnNumberFromLine();
			while (numero < 1 && numero > 1) {
				System.out.print("Inserisci la lunghezza dei colori (1-8): ");
				numero = returnNumberFromLine();
			}
			this.colorLength = numero;
		} catch (NumberFormatException e) {
		}

	}

	/**
	 * Mette nella lista dei CodeMaker l'istanza del CM opportuno
	 * 
	 * @throws IOException
	 */
	private void getMakerType() throws IOException {
		System.out.println("\n\nAdesso scegli chi vuoi che crei il tuo codice");
		for (int i = 0; i < this.playersNumber; i++) {
			System.out.print("Scegli il tipo del maker (" + (i + 1) + ") del codice (default: bot)(bot/umano) ");
			String type = returnLine();
			this.cmList.add(RegisterCM.getInstance().getCM((type.isBlank() || type.isEmpty()) ? "bot" : type)
					.createCodeMaker(new ConsoleView(this.colorLength), this.codeLength, this.colorLength));
		}
		System.out.println("\n\n");
	}

	/**
	 * Prima fa scegliere un nome per il giocatore Mette nella lista dei CodeBreaker
	 * l'istanza del CB opportuno
	 * 
	 * @throws IOException
	 */
	private void getBreakerType() throws IOException {
		System.out.println("\n\n E' arrivato il momento di scegliere il nome del giocatore ed il tipo");
		for (int i = 0; i < this.playersNumber; i++) {
			String name;
			while(true) {
				System.out.print("Scegli il nome del giocatore(" + (i + 1) + "): ");
				name = returnLine();
				if(!name.isBlank() || !name.isEmpty()) {
					break;
				}
			}
			System.out.print("Scegli il tipo del breaker(" + (i + 1) + ") del codice(default: umano) (umano) ");
			String type = returnLine();
			this.cbList.add(RegisterCB.getInstance().getCB((type.isBlank() || type.isEmpty()) ? "umano" : type)
					.createCodeBreaker(new ConsoleView(this.colorLength), this.codeLength, name, this.attempts));
		}
		System.out.println("\n\n");
	}

}

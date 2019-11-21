package it.unicam.pa.mastermind.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import it.unicam.pa.mastermind.ColorStack;
import it.unicam.pa.mastermind.breaker.CodeBreaker;
import it.unicam.pa.mastermind.endgame.WinCouple;
import it.unicam.pa.mastermind.enums.CheckResult;
import it.unicam.pa.mastermind.enums.Colors;

/**
 * Responsabilità: Controllare l'input e output dalla console, andando a
 * costruire i vari tentativi e mostrare il risultato di ogni tentativo
 * 
 * @author joel
 *
 */
public class ConsoleView implements View {
	private BufferedReader input;
	private int length;

	// Caratteri ANSI di Escape per i colori. Da notare bene che su Windows nel CMD
	// non si vedono

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_BLUE = "\u001B[44m";
	public static final String ANSI_BROWN = "\u001B[48;5;136m";
	public static final String ANSI_CYAN = "\u001B[46m";
	public static final String ANSI_GREEN = "\u001B[42m";
	public static final String ANSI_MAGENTA = "\u001B[45;5m";
	public static final String ANSI_RED = "\u001B[41m";
	public static final String ANSI_YELLOW = "\u001B[43m";
	public static final String ANSI_PURPLE = "\u001B[45m";

	public static final String ANSI_BLACK = "\u001B[40m";
	public static final String ANSI_GREY = "\u001B[47m";
	public static final String ANSI_WHITE = "\u001B[48;5;255m";


	public ConsoleView(int length) {
		this.input = new BufferedReader(new InputStreamReader(System.in));
		this.length = length;
	}

	/**
	 * Ricava un colore dall'input dell'utente
	 * 
	 * @return un colore
	 */
	@Override
	public Colors getColor() {
		Colors color = null;
		try {
			color = this.indexedEnum(inputColor());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return color;
	}

	/**
	 * Prende una stringa dall'utente e lo converte in intero da restituire a
	 * <code>getColor()</code>
	 * 
	 * @return intero per <code>getColor()</code>
	 * @throws IOException
	 */
	public int inputColor() throws IOException {
		printBoard();
		while (true) {
			System.out.print("Scegli un colore (1-" + this.length + "): ");
			String line = input.readLine();
			int color = (Integer.parseInt(line)) - 1;
			if (color >= this.length) {
				System.out.println("\nDevi inserire un numero minore di " + (this.length + 1));
			} else {
				return color;
			}
		}
	}

	/**
	 * Stampa la tavola dei colori
	 */
	@Override
	public void printBoard() {
		for (int i = 0; i < this.length; i++) {
			System.out.print(String.format("|%-4d|", (i + 1)));
		}
		System.out.println();
		Colors[] colors = Colors.values();
		IntStream.range(0, this.length).forEach(x -> printColor(colors[x]));
		System.out.println("\n\n");
	}

	public void printColor(Colors color) {
		switch (color) {
		case BLUE:
			System.out.print("|" + ANSI_BLUE + "    " + ANSI_RESET + "|");
			break;
		case BROWN:
			System.out.print("|" + ANSI_BROWN + "    " + ANSI_RESET + "|");
			break;
		case CYAN:
			System.out.print("|" + ANSI_CYAN + "    " + ANSI_RESET + "|");
			break;
		case GREEN:
			System.out.print("|" + ANSI_GREEN + "    " + ANSI_RESET + "|");
			break;
		case MAGENTA:
			System.out.print("|" + ANSI_MAGENTA + "    " + ANSI_RESET + "|");
			break;
		case RED:
			System.out.print("|" + ANSI_RED + "    " + ANSI_RESET + "|");
			break;
		case YELLOW:
			System.out.print("|" + ANSI_YELLOW + "    " + ANSI_RESET + "|");
			break;
		case PURPLE:
			System.out.print("|" + ANSI_PURPLE + "    " + ANSI_RESET + "|");
			break;
		}
	}

	/**
	 * Stampa i pegs per vedere il risultato del tentativo
	 */
	@Override
	public void printPegs(List<CheckResult> pegs) {
		for (CheckResult peg : pegs) {
			switch (peg) {
			case BLACK:
				System.out.print("|" + ANSI_BLACK + "    " + ANSI_RESET + "|");
				break;
			case GREY:
				System.out.print("|" + ANSI_GREY + "    " + ANSI_RESET + "|");
				break;
			case WHITE:
				System.out.print("|" + ANSI_WHITE + "    " + ANSI_RESET + "|");
				break;
			}
		}
		System.out.println("\n\n");
	}

	/**
	 * Stampa il vincitore della partita
	 */

	@Override
	public void printWinner(WinCouple couple) {
		if (couple.getWinner() == null) {
			System.out.println("Non abbiamo nessun vincitore");
		} else {
			System.out.println("Il vincitore e': " + couple.getWinner());
		}
	}

	/**
	 * Stampa la sequenza da decifrare
	 */

	@Override
	public void printCode(ColorStack code) {
		System.out.println("La sequenza da indovinare era: ");
		Arrays.stream(code.getStack()).forEach(x -> printColor(x));
	}

	/**
	 * Stampa il nome del giocatore che ha il turno
	 */
	@Override
	public void printTurnRound(CodeBreaker breaker) {
		System.out.println("Turno di: " + breaker.getName());
	}

}

package it.unicam.pa.mastermind.breaker;

import java.util.Arrays;

import it.unicam.pa.mastermind.ColorStack;
import it.unicam.pa.mastermind.enums.Colors;
import it.unicam.pa.mastermind.view.View;

/**
 * CodeBreaker interattivo, utilizza l'input per creare un ColorStack da fare il
 * tentativo
 * 
 * @author joel
 *
 */
public class InteractiveCB implements CodeBreaker {
	private String name;
	private View input;
	private int codeLength;
	private int attemptsRemaining;

	public InteractiveCB(View v, int codeLength, String name, int attempts) {
		this.input = v;
		this.codeLength = codeLength;
		this.name = name;
		this.attemptsRemaining = attempts;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * Crea un stack di colori così da utilizzarlo come tentativo per decifrare il
	 * codice Diminiuisce il numero dei tentativi rimasti ogni turno
	 */
	@Override
	public ColorStack makeAttempt() {
		Colors[] stack = new Colors[this.codeLength];
		for (int i = 0; i < this.codeLength; i++) {
			Colors color = this.input.getColor();
			boolean contained = Arrays.stream(stack).anyMatch(c -> color.equals(c));
			if (!contained) {
				stack[i] = color;
			} else {
				System.out.println("Questo colore esiste già");
				i--;
			}
		}
		this.attemptsRemaining--;
		return new ColorStack(stack);
	}

	@Override
	public int getAttempts() {
		return this.attemptsRemaining;
	}



}

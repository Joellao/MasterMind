package it.unicam.pa.mastermind.maker;

import java.util.Arrays;

import it.unicam.pa.mastermind.ColorStack;
import it.unicam.pa.mastermind.enums.Colors;
import it.unicam.pa.mastermind.view.View;

/**
 * 
 */

/**
 * CodeMaker interattivo, i colori per il codice sono scelti dall'utente
 * 
 * @author joel
 *
 */
public class InteractiveCM implements CodeMaker {
	private View input;
	private int codeLength;

	public InteractiveCM(View v, int codeLength, int colorsLength) {
		this.input = v;
		this.codeLength = codeLength;
	}

	/**
	 * Crea un ColorStack che contiene i colori per il codice da decifrare
	 */
	@Override
	public ColorStack generateCode() {
		Colors[] colorArray = new Colors[codeLength];
		for (int i = 0; i < codeLength; i++) {
			Colors color = this.input.getColor();
			boolean contained = Arrays.stream(colorArray).anyMatch(c -> color.equals(c));
			if (!contained) {
				colorArray[i] = color;
			} else {
				System.out.println("Questo colore esiste già");
				i--;
			}

		}
		return new ColorStack(colorArray);
	}

}

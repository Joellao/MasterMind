package it.unicam.pa.mastermind.maker;

import java.util.Arrays;
/**
 * 
 */
import java.util.Random;

import it.unicam.pa.mastermind.ColorStack;
import it.unicam.pa.mastermind.enums.Colors;

/**
 * CodeMaker bot, i colori per il codice sono scelti in modo randomico
 * 
 * @author joel
 *
 */
public class BotCM implements CodeMaker {
	private int codeLength;
	private int colorsLength;

	public BotCM(int codeLength, int colorsLength) {
		this.codeLength = codeLength;
		this.colorsLength = colorsLength;
	}

	/**
	 * Metodo per avere un Enum random di Colors
	 * 
	 * @param limit limita il numero random generato
	 * @return Enum di Colors
	 */
	private Colors randomEnum(int limit) {
		if(limit<=0) {
			throw new IllegalArgumentException("Il limite deve essere maggiore di 0");
		}
		Random rand = new Random();
		Colors[] values = Colors.values();
		int x = rand.nextInt(limit);
		return values[x];
	}

	/**
	 * Ritorna un ColorStack generato in modo randomico. Non ammettiamo colori
	 * duplicati
	 */
	@Override
	public ColorStack generateCode() {
		Colors[] colorArray = new Colors[this.codeLength];
		for (int i = 0; i < this.codeLength; i++) {
			Colors color = randomEnum(this.colorsLength);
			boolean contained = Arrays.stream(colorArray).anyMatch(c -> color.equals(c)); // colors::equals
			if (!contained) {
				colorArray[i] = color;
			} else {
				i--;
			}
		}
		return new ColorStack(colorArray);
	}

}

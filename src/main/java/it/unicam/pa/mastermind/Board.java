package it.unicam.pa.mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import it.unicam.pa.mastermind.enums.CheckResult;
import it.unicam.pa.mastermind.enums.Colors;
import it.unicam.pa.mastermind.maker.CodeMaker;

/**
 * Responsabilità: Gestire la tavola di gioco, andando salvarsi il codice da decrittare insieme alla
 * lunghezza del codice e i tentativi fatti
 * 
 * @author Joel
 *
 */
public class Board {
	private ColorStack code;
	private List<ColorStack> attempts;
	private int codeLength;

	public Board(CodeMaker codeMaker, int codeLength, int colorLength) {
		this.codeLength = codeLength;
		this.code = codeMaker.generateCode();
		this.attempts = new ArrayList<ColorStack>();
	}

	/**
	 * Prende l'ultimo tentativo e controlla con il codice, restituisce una di tutti
	 * neri se il tentativo è uguale al codice, altrimenti continua i controlli
	 * 
	 * @return Lista dei 'pegs' ricavato dal risultato del confronto
	 */
	public List<CheckResult> checkCode() {
		ColorStack lastAttempt = this.attempts.get(this.attempts.size() - 1);
		List<CheckResult> result = new ArrayList<CheckResult>();

		if (this.code.equals(lastAttempt)) {
			for (int i = 0; i < this.codeLength; i++) {
				result.add(CheckResult.BLACK);
			}
		} else {
			return checkCode(this.code.getStack(), lastAttempt.getStack());
		}

		return result;
	}

	/**
	 * Ritorna una lista con i pegs Neri, Grigi e Bianchi. Nero per colore trovato e
	 * nella posizione giusta, Grigio se trovato ma non nella posizione giusta,
	 * Bianco per colore non trovato.
	 * 
	 * Alla fine applichiamo un shuffle così vengono mischiati e non si sa quale
	 * colore è riferito a quale posizione
	 * 
	 * @param codeStack array contenente il codice da decrittare
	 * @param attemptStack array contentente il codice dell'ultimo tentativo fatto
	 * @return Lista dei pegs
	 */
	private List<CheckResult> checkCode(Colors[] codeStack, Colors[] attemptStack) {
		CheckResult piece = null;
		List<CheckResult> result = new ArrayList<CheckResult>();
		for (int i = 0; i < codeStack.length; i++) {
			for (int j = 0; j < attemptStack.length; j++) {
				if (codeStack[i].equals(attemptStack[j])) {
					if(i==j) {
						piece = CheckResult.BLACK;
					}else {
						piece = CheckResult.GREY;
					}
					attemptStack[j] = null;
					break;
				}else {
					piece = CheckResult.WHITE;
				}
			}
			result.add(piece);
		}
		Collections.shuffle(result, new Random());
		return result;
	}

	public ColorStack getCode() {
		return code;
	}

	public void newAttempt(ColorStack attempt) {
		this.attempts.add(attempt);
	}

}

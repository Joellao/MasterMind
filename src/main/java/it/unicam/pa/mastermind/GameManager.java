package it.unicam.pa.mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unicam.pa.mastermind.breaker.CodeBreaker;
import it.unicam.pa.mastermind.endgame.WinCouple;
import it.unicam.pa.mastermind.enums.CheckResult;
import it.unicam.pa.mastermind.maker.CodeMaker;
import it.unicam.pa.mastermind.view.View;

/**
 * Responsabilità: Coordinare i turni di gioco degli giocatori, facendo fare il tentativo per indovinare
 * il codice
 * 
 * @author Joel
 *
 */
public class GameManager {

	private List<Couple> couple = new ArrayList<Couple>();
	private int turn;

	/**
	 * Creiamo la couple con le informazioni ricavate nella fase iniziale
	 * 
	 * @param cbList lista dei breaker
	 * @param cmList lista dei maker
	 * @param codeLength lunghezza codice
	 * @param colorLength lunghezza colori
	 */
	public GameManager(List<CodeBreaker> cbList, List<CodeMaker> cmList, int codeLength, int colorLength) {
		for (int i = 0; i < cbList.size(); i++) {
			this.couple.add(new Couple(cbList.get(i), new Board(cmList.get(i), codeLength, colorLength)));
		}
		this.turn = 0;
	}

	/**
	 * Metodo per iniziare a giocare, gestisce il turno e controlla se il risultato
	 * di un controllo di tentativo abbia i 4 Peg neri che servono per finire il
	 * gioco. Il gioco finisce se si hanno 4 peg neri oppure il numero dei tentativi
	 * è uguale a 0. Dopo stampiamo il vincitore oppure chi non ha vinto
	 * 
	 * Il gioco finisce appena si decifra almeno un codice oppure quando finiscono i tentativi
	 * 
	 */
	public void play(View output) {
		Couple couple = this.couple.get(currentTurn());
		int attemptsRemaining = couple.getBreaker().getAttempts();
		CodeBreaker breaker = couple.getBreaker();
		Board board = this.couple.get(currentTurn()).getBoard();
		do {

			output.printTurnRound(breaker);
			consumeTurn();
			List<CheckResult> pegs = board.checkCode();
			if (Collections.frequency(pegs, CheckResult.BLACK) == 4) {
				output.printWinner(new WinCouple(couple));
				output.printCode(board.getCode());
				return;
			} else {
				output.printPegs(pegs);
			}

			this.turn = this.opponentTurn();
			breaker = this.couple.get(currentTurn()).getBreaker();
			board = this.couple.get(currentTurn()).getBoard();
			attemptsRemaining = breaker.getAttempts();
		} while (attemptsRemaining > 0);
		
		output.printWinner(new WinCouple(null));
	}

	/**
	 * Fa fare al CodeBreaker il tentativo per indovinare
	 */
	private void consumeTurn() {
		ColorStack stack = this.couple.get(currentTurn()).getBreaker().makeAttempt();
		this.couple.get(currentTurn()).getBoard().newAttempt(stack);
	}

	private int currentTurn() {
		return turn;
	}

	private int opponentTurn() {
		return (turn + 1) % this.couple.size();
	}
	
	
}

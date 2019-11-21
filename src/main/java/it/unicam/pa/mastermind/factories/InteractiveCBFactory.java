package it.unicam.pa.mastermind.factories;

import it.unicam.pa.mastermind.breaker.CodeBreaker;
import it.unicam.pa.mastermind.breaker.InteractiveCB;
import it.unicam.pa.mastermind.view.View;

/**
 * Crea un CodeBreaker interattivo con i parametri opportuni
 * 
 * @author joel
 *
 */
public class InteractiveCBFactory implements CBFactory {

	@Override
	public CodeBreaker createCodeBreaker(View v, int codeLength, String name, int attempts) {
		return new InteractiveCB(v, codeLength, name, attempts);
	}

}

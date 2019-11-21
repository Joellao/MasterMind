package it.unicam.pa.mastermind.factories;

import it.unicam.pa.mastermind.breaker.CodeBreaker;
import it.unicam.pa.mastermind.view.View;

/**
 * Factory per il CodeBreaker
 * 
 * @author joel
 *
 */
@FunctionalInterface
public interface CBFactory {
	public CodeBreaker createCodeBreaker(View v, int codeLength, String name, int attempts);
}

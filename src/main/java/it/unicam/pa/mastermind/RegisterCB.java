package it.unicam.pa.mastermind;

import it.unicam.pa.mastermind.factories.CBFactory;
import it.unicam.pa.mastermind.factories.InteractiveCBFactory;

/**
 * Ritorna un CodeBreaker in base a quello che ha scelto l'utente
 * 
 * @author joel
 *
 */
public class RegisterCB {
	private static RegisterCB instance;

	/**
	 * Si controlla se l'istanza esiste o no, se non esiste la si crea
	 * 
	 * @return L'istanza da evocare per avere il factory giusto
	 */
	public static RegisterCB getInstance() {
		if (instance == null) {
			instance = new RegisterCB();
		}
		return instance;
	}

	/**
	 * 
	 * @param type tipo del codebreaker, preso come parametro iniziale
	 * @return Factory Opportuno
	 */
	public CBFactory getCB(String type) {
		switch (type) {
		case "umano":
			return new InteractiveCBFactory();
		case "bot":
			return null;
		default:
			return null;
		}
	}
}

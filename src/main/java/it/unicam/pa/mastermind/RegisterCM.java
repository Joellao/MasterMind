package it.unicam.pa.mastermind;

import it.unicam.pa.mastermind.factories.BotCMFactory;
import it.unicam.pa.mastermind.factories.CMFactory;
import it.unicam.pa.mastermind.factories.InteractiveCMFactory;

/**
 * Ritorna un CodeMaker in base a quello che ha scelto l'utente
 * 
 * @author joel
 *
 */
public class RegisterCM {
	private static RegisterCM instance;

	/**
	 * Si controlla se l'istanza esiste o no, se non esiste la si crea
	 * 
	 * @return L'istanza da evocare per avere il factory giusto
	 */
	public static RegisterCM getInstance() {
		if (instance == null) {
			instance = new RegisterCM();
		}
		return instance;
	}

	/**
	 * 
	 * @param type tipo del code maker, preso come parametro iniziale
	 * @return Factory opportuno
	 */
	public CMFactory getCM(String type) {
		switch (type) {
		case "umano":
			return new InteractiveCMFactory();
		case "bot":
			return new BotCMFactory();
		default:
			return null;
		}
	}
}

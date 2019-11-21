package it.unicam.pa.mastermind.factories;

import it.unicam.pa.mastermind.maker.CodeMaker;
import it.unicam.pa.mastermind.maker.InteractiveCM;
import it.unicam.pa.mastermind.view.View;

/**
 * Crea un CodeMaker interattivo con i parametri opportuni
 * 
 * @author joel
 *
 */
public class InteractiveCMFactory implements CMFactory {

	@Override
	public CodeMaker createCodeMaker(View v, int codeLength, int colorLength) {
		return new InteractiveCM(v, codeLength, colorLength);
	}

}

package it.unicam.pa.mastermind.factories;

import it.unicam.pa.mastermind.maker.BotCM;
import it.unicam.pa.mastermind.maker.CodeMaker;
import it.unicam.pa.mastermind.view.View;

/**
 * Ritorna un CodeMaker di tipo Bot
 * 
 * @author joel
 *
 */
public class BotCMFactory implements CMFactory {

	@Override
	public CodeMaker createCodeMaker(View v, int codeLength, int colorLength) {
		return new BotCM(codeLength, colorLength);
	}

}

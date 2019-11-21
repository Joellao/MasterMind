/**
 * 
 */
package it.unicam.pa.mastermind.factories;

import it.unicam.pa.mastermind.maker.CodeMaker;
import it.unicam.pa.mastermind.view.View;

/**
 * Factory per il CodeMaker
 * 
 * @author joel
 *
 */
@FunctionalInterface
public interface CMFactory {
	public CodeMaker createCodeMaker(View v, int codeLength, int colorLength);
}

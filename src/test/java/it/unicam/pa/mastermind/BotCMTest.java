package it.unicam.pa.mastermind;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import it.unicam.pa.mastermind.maker.BotCM;
import it.unicam.pa.mastermind.maker.CodeMaker;

public class BotCMTest {

	@Test
	public void shouldThrowIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> new BotCM(4, 0).generateCode());
	}
	
	@Test
	public void shouldHaveSameLengthRandomColors() {
		int colorLength = 4;
		int codeLength = 4;
		CodeMaker bot = new BotCM(codeLength, colorLength);
		ColorStack stack = bot.generateCode();
		assertTrue(stack.getStack().length == colorLength);
	}

}

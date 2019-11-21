package it.unicam.pa.mastermind;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.unicam.pa.mastermind.maker.BotCM;

public class BoardTest {

	@Test
	public void shouldBeSameLength() {
		int codeLength = 4;
		Board b = new Board(new BotCM(codeLength, 4), 4, 0);
		assertTrue(b.getCode().getStack().length == codeLength);
	}

}

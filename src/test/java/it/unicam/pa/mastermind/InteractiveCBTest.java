package it.unicam.pa.mastermind;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.pa.mastermind.breaker.InteractiveCB;
import it.unicam.pa.mastermind.enums.Colors;
import it.unicam.pa.mastermind.view.ConsoleView;

class InteractiveCBTest {

	@Test
	void shouldHaveSameAttemptsNumber() {
		InteractiveCB cb = new InteractiveCB(null,4,"",4);
		assertTrue(cb.getAttempts()==4);
	}
	
	@Test
	void shouldHaveSameAttempt() {
		InteractiveCB cb = new InteractiveCB(new ConsoleView(4),4,"",4);
		Colors[] colors = new Colors[4];
		colors[0] = Colors.BLUE;
		colors[1] = Colors.BROWN;
		colors[2] = Colors.CYAN;
		colors[3] = Colors.GREEN;
		ColorStack cs = new ColorStack(colors);
		//Inserire 1 2 3 4
		assertTrue(cs.equals(cb.makeAttempt()));
	}

}

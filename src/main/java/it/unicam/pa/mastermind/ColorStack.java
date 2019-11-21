package it.unicam.pa.mastermind;

import java.util.Arrays;

import it.unicam.pa.mastermind.enums.Colors;

/**
 * Responsabilità: salvare il codice composto dagli ENUM
 * 
 * @author Joel
 *
 */
public class ColorStack {
	private Colors[] stack;

	public ColorStack(Colors[] props) {
		this.stack = props;
	}

	public Colors[] getStack() {
		return this.stack;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(stack);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorStack other = (ColorStack) obj;
		if (!Arrays.equals(stack, other.stack))
			return false;
		return true;
	}

}

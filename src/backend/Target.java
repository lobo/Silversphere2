package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Target extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Target
	 * 
	 */
	public Target() {
		super();
	}

	/**
	 * Sets content from actual to cardinal given
	 * 
	 * @param content
	 * @param actual
	 * @param cardinal
	 * @return True if able to set content successfully, False if not
	 */
	public boolean setContent(Content content, Point actual, Cardinal cardinal)
			throws PositionOutOfBoundsException {
		Boolean ableToSetContent = super.setContent(content, actual, cardinal);
		if (ableToSetContent && ((this.getContent()) instanceof Player) && interruptorActive()) {
			this.getContent().getBoard().setState(State.WIN);
		}
		return ableToSetContent;
	}

	/**
	 * Checks whether the boards interrupter has been activated
	 * 
	 * @return True if the board's interrupter is active, False if not
	 */
	public boolean interruptorActive() {
		return (this.getContent().getBoard().isInterruptorActive());
	}

}
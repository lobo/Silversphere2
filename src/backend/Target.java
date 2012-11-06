package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Target extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	public Target() {
		super();
	}

	@Override
	public boolean setContent(Content content, Point actual, Cardinal cardinal)
			throws PositionOutOfBoundsException {
		Boolean ableToSetContent = super.setContent(content, actual, cardinal);
		if (ableToSetContent && ((this.getContent()) instanceof Player) && interruptorActive()) {
			this.getContent().getBoard().getInstanceBoardListener().win();
		}
		return ableToSetContent;
	}

	public boolean interruptorActive() {
		return (this.getContent().getBoard().isInterruptorActive());
	}

}
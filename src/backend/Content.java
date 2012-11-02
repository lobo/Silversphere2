package backend;

import java.awt.Point;
import java.io.Serializable;

public abstract class Content implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Point position;
	private final Board board;

	public Content(Point point, Board board) {
		this.position = point;
		this.board = board;
	}

	/**
	 * Sets a new position for the movable
	 * 
	 * @param direction
	 *            Cardinal with the direction of movement
	 */
	public void setPosition(Cardinal direction) {
		if ((board.validPosition(position))) {
			position.x += direction.getDirX();
			position.y += direction.getDirY();
		}
	}

	public abstract boolean move(Point going, Cardinal cardinal);

	public abstract boolean remove();

	/**
	 * Gets the board.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Gets the position.
	 */
	public Point getPosition() {
		return position;
	}
}
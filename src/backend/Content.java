package backend;

import java.awt.Point;
import java.io.Serializable;

public abstract class Content implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Point position;
	private final Board board;
	
	/**
	 * Creates a new Content
	 * 
	 * @param point
	 * @param board
	 */
	public Content(Point point, Board board) {
		this.position = point;
		this.board = board;
	}

	/**
	 * Sets Content at a given position
	 * 
	 * @param direction
	 */
	public void setPosition(Cardinal direction) {
		if ((board.validPosition(position))) {
			position.x += direction.getDirX();
			position.y += direction.getDirY();
		}
	}

	/**
	 * Moves Content from one Position to a Cardinal given
	 * 
	 * @param going
	 * @param cardinal
	 * @return True if movement was successful, False if not
	 */
	public abstract boolean move(Point actualPlace, Cardinal cardinal);
	
	/**
	 * Removes content from play
	 * 
	 * @return True if removal was successful, False if not
	 */
	public abstract boolean remove();

	/**
	 * Returns the content's Board
	 * 
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Returns position of content
	 * 
	 */
	public Point getPosition() {
		return position;
	}
	
	public abstract void react(Point ActualPlace);
	
	public abstract boolean interuptorReact();
}
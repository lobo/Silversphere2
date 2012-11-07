package backend;

import java.awt.Point;
import java.io.Serializable;

public class Player extends Content implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Player
	 * 
	 * @param point
	 * @param board
	 */
	public Player(Point point, Board board) {
		super(point, board);
	}


	/**
	 * Ends Game if Player is removed from play
	 * 
	 * @return False always
	 */
	public boolean remove() {
		this.getBoard().setState(State.LOSE);
		return false;
	}

	/**
	 * Under no circumstance will Player be asked to moves
	 * 
	 * @return False always
	 */
	@Override
	public boolean move(Point going, Cardinal cardinal) {
		return false;
	}


	@Override
	public void react(Point actualPlace) {
		remove();
	}
}
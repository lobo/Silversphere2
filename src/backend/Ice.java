package backend;

import java.awt.Point;
import java.io.Serializable;

public class Ice extends Box implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Board board;

	/**
	 * Creates a new Ice
	 * 
	 * @param point 
	 * @param board
	 */
	public Ice(Point point, Board board) {
		super(point, board);
		this.board = board;
	}

	/**
	 * Moves Ice from position given in th direction of the cardinal given until the next incoming Cell
	 * is unaccessible
	 * 
	 * @param boxActualPlace
	 * @param cardinal
	 */
	public boolean move(Point boxActualPlace, Cardinal cardinal) {

		Point boxNextPlace = this.getBoard().SetPositionCardinal(boxActualPlace, cardinal);
		
		if(!(this.getBoard().getCell(boxNextPlace).isAccesible())){
			return false;
		}
		
		
		while ((this.getBoard().getCell(boxNextPlace).isAccesible()) && ((ContentOperations)(board.getCell(boxActualPlace))).getContent() != null) {
			super.move(boxActualPlace, cardinal);
			boxActualPlace = boxNextPlace;
			boxNextPlace = this.getBoard().SetPositionCardinal(boxNextPlace,cardinal);
		}

		return true;
	}

	/**
	 * Removes Ice from play
	 * 
	 * @return True always
	 */
	public boolean remove() {
		((ContentOperations) (this.getBoard().getCell(this.getPosition()))).removeContent();
		return true;
	}
	
	@Override
	public void react(Point actualPlace) {
		remove();
	}
}
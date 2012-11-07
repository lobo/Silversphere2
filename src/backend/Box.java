package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Box extends Content implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates a new Box
	 * 
	 * @param point
	 * @param board
	 */
	public Box(Point point, Board board) {
		super(point, board);
	}

	
	/**
	 * Moves Box from one place to another(Specified by the boxActualPlace and cardinal), given that the move is possible
	 * under the games restrictions
	 * 
	 * @param boxActualPlace
	 * @param cardinal
	 * @return True if box was able to move successfully
	 * @throws PositionOutOfBoundsException
	 */
	public boolean move(Point boxActualPlace, Cardinal cardinal) throws PositionOutOfBoundsException {
		
		Point boxNextPlace = this.getBoard().SetPositionCardinal(boxActualPlace, cardinal);
		
		if (this.getBoard().validPosition(boxNextPlace)) {
			if (this.getBoard().getCell(boxNextPlace) instanceof ContentOperations && ((ContentOperations) this.getBoard().getCell(boxNextPlace)).getContent() == null) {
				if (this.getBoard().getCell(boxNextPlace).setContent(this, boxNextPlace, cardinal)) {
					if (((ContentOperations) this.getBoard().getCell(boxActualPlace)).getContent() != null) {
						((ContentOperations) this.getBoard().getCell(boxActualPlace)).getContent().setPosition(cardinal);
						((ContentOperations) this.getBoard().getCell(boxActualPlace)).removeContent();
						return true;
					}
					return true;
				}

			} else if (((ContentOperations)(this.getBoard().getCell(boxActualPlace))).getContent() == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes Box from play(Would never occur under the games restrictions)
	 * 
	 * @return False
	 */
	@Override
	public boolean remove() {
		return false;
	}
	
	public void react(Point boxActualPlace){
		getBoard().putCell(new WaterBox(), boxActualPlace);
	}


	@Override
	public boolean interuptorReact() {
		return false;
	}

}
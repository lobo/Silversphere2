package backend;

import java.awt.Point;
import java.io.Serializable;

public class Ice extends Box implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Board board;

	public Ice(Point point, Board board) {
		super(point, board);
		this.board = board;
	}

	@Override
	public boolean move(Point boxActualPlace, Cardinal cardinal) {

		Point boxNextPlace = this.getBoard().SetPositionCardinal(
				boxActualPlace, cardinal);

		while ((((ContentOperations) board.getCell(boxNextPlace)).getContent() != null)
				|| (board.getCell(boxNextPlace) instanceof Water && board
						.getCell(boxActualPlace) instanceof Water)) {
			super.move(boxActualPlace, cardinal);
			boxActualPlace = boxNextPlace;
			boxNextPlace = this.getBoard().SetPositionCardinal(boxNextPlace,
					cardinal);
		}

		return true;
	}

	@Override
	public boolean remove() {
		((ContentOperations) (this.getBoard().getCell(this.getPosition())))
				.removeContent();
		return true;
	}
}
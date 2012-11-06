package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Box extends Content implements Serializable {

	private static final long serialVersionUID = 1L;

	public Box(Point point, Board board) {
		super(point, board);
	}

	@Override
	public boolean move(Point boxActualPlace, Cardinal cardinal)
			throws PositionOutOfBoundsException {

		Point boxNextPlace = this.getBoard().SetPositionCardinal(boxActualPlace, cardinal);
		if (this.getBoard().validPosition(boxNextPlace)) {
			// posicion valido
			if (this.getBoard().getCell(boxNextPlace) instanceof ContentOperations && ((ContentOperations) this.getBoard().getCell(boxNextPlace)).getContent() == null) {
				// si el prox cell es un piso y su contenido es nulo
				if (this.getBoard().getCell(boxNextPlace).setContent(this, boxNextPlace, cardinal)) {
					// si se pudo setear la caja en el nuevo lugar sin problema
					if (((ContentOperations) this.getBoard().getCell(boxActualPlace)).getContent() != null) {
						// si hay un contenido en la posicion actual
						((ContentOperations) this.getBoard().getCell(boxActualPlace)).getContent().setPosition(cardinal);
						// muevo la caja a la posicion del cardinal
						((ContentOperations) this.getBoard().getCell(boxActualPlace)).removeContent();
						// saco la caja del lugar actual
						return true;
					}
					return true;
				}

			} else if (((ContentOperations)(this.getBoard().getCell(boxActualPlace))).getContent() == null) {
				// si se pudo remover bien la caja de su posicion actual
				// entonces el moviemiento fue un exito
				return true;
			}
		}
		return false;
	}

	/**
	 * Would remove a box, but this wont never happen, as it falls in the water.
	 */
	@Override
	public boolean remove() {
		return false;
	}

}
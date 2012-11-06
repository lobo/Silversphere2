package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Water extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	public Water() {

	}

	@Override
	public boolean setContent(Content content) {
		// testing(creo q nunca lo vamos a usar)
		return false;
	}

	@Override
	public boolean isAccesible() {
		return true;
	}

	@Override
	public boolean setContent(Content content, Point boxActualPlace,Cardinal cardinal) throws PositionOutOfBoundsException {
		Boolean ableToSetContent = super.setContent(content, boxActualPlace,cardinal);
		if (ableToSetContent) {
			if (content instanceof Ice || content instanceof Player) {
				return content.remove();
			} else {
				content.getBoard().putCell(new WaterBox(), boxActualPlace);
				/***
				 * No se si es boxActualPlace, cardinal o otras cosa, porbamos
				 * con ese
				 */
			}
		}
		return ableToSetContent;
	}
}
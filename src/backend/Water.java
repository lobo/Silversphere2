package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Water extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Water
	 * 
	 */
	public Water() {
	}

	/**
	 *Water will always be accessible
	 *
	 * @return True Always
	 */
	public boolean isAccesible() {
		return true;
	}

	/**
	 * Sets content from actual to cardinal given
	 * 
	 * @throws PositionOutOfBoundsException
	 * @param content
	 * @param boxActualPlace
	 * @param cardinal
	 * @return True if able to set content successfully, False if not
	 */
	public boolean setContent(Content content, Point boxActualPlace,Cardinal cardinal) throws PositionOutOfBoundsException {
		Boolean ableToSetContent = super.setContent(content, boxActualPlace,cardinal);
		if (ableToSetContent) {
			if (content instanceof Ice || content instanceof Player) {
				return content.remove();
			} else {
				content.getBoard().putCell(new WaterBox(), boxActualPlace);
			}
		}
		return ableToSetContent;
	}
}
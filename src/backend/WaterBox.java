package backend;

import java.awt.Point;
import java.io.Serializable;

public class WaterBox extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Waterbox
	 * 
	 */
	public WaterBox() {
		super();
	}
	
	/**
	 * Sets content from actual to cardinal given
	 * 
	 * @return True if able to set content, False if not
	 */
	public boolean setContent(Content content, Point actual, Cardinal cardinal) {
		return super.setContent(content, actual, cardinal);
	}
}
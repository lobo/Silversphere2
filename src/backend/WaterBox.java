package backend;

import java.awt.Point;
import java.io.Serializable;

public class WaterBox extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	public WaterBox() {
		super();
	}
	
	@Override
	public boolean setContent(Content content, Point actual, Cardinal cardinal) {
		return super.setContent(content, actual, cardinal);
	}
}
package backend;

import java.awt.Point;
import java.io.Serializable;

public class Interruptor extends Floor implements Serializable {

	private static final long serialVersionUID = 1L;

	public Interruptor() {
		super();
	}

	public boolean activation() {
		if (this.getContent() instanceof Ice) {
			this.getContent().getBoard().activateInterruptor();
			return true;
		}
		return false;
	}

	@Override
	public boolean setContent(Content content, Point actual, Cardinal cardinal) {
		boolean ableToSetContent = super.setContent(content, actual, cardinal);
		if (ableToSetContent) {
			activation();
			return true;
		}
		return false;
	}

}
package backend;

import java.awt.Point;
import java.io.Serializable;

public class Floor extends Cell implements ContentOperations, Serializable {

	private static final long serialVersionUID = 1L;
	private Content content;

	public Floor() {
		this.content = null;
	}

	@Override
	public boolean setContent(Content content, Point actual, Cardinal cardinal) {
		if (this.content == null) {
			this.content = content;
			return true;
		} else if (this.content.move(actual, cardinal)) {
			this.content = content;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean setContent(Content content) {
		if (this.content == null) {
			this.content = content;
			return true;
		}
		return false;
	}

	@Override
	public Content getContent() {
		return content;
	}

	@Override
	public boolean removeContent() {
		this.content = null;
		return true;
	}

	@Override
	public boolean isAccesible() {

		return content == null;
	}

}
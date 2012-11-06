package backend;

import java.awt.Point;
import java.io.Serializable;

public class Floor extends Cell implements ContentOperations, Serializable {

	private static final long serialVersionUID = 1L;
	private Content content;

	/**
	 * Creates a new Floor
	 * 
	 */
	public Floor() {
		this.content = null;
	}

	/**
	 * Sets content from actual to cardinal
	 * 
	 * @param content
	 * @param actual 
	 * @param cardinal
	 * @return True if able to set content on the Cell located at the cardinal given, False if not
	 */
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

	/**
	 * Sets Content on given Cell
	 * 
	 * @param content
	 * @return True if able to set content, False if not
	 */
	public boolean setContent(Content content) {
		if (this.content == null) {
			this.content = content;
			return true;
		}
		return false;
	}

	/**
	 * Returns the current content in the given Cell
	 * 
	 */
	public Content getContent() {
		return content;
	}

	/**
	 * Removes content from a given Cell 
	 * 
	 */
	public boolean removeContent() {
		this.content = null;
		return true;
	}

	/**
	 * Returns Whether o not a cell is accessible
	 * 
	 */
	public boolean isAccesible() {
		return content == null;
	}
}
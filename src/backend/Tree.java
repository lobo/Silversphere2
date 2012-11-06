package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Tree extends Cell implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates new Tree
	 * 
	 */
	public Tree() {
	}

	/**
	 * Not able to set content on a Tree
	 * 
	 * @return False always
	 */
	public boolean setContent(Content content) {
		return false;
	}

	/**
	 * Tree is never accessible
	 * 
	 * @return False always
	 */
	public boolean isAccesible() {
		return false;
	}


	/**
	 * Not able to set content on a Tree
	 * 
	 * @return False Always
	 */
	public boolean setContent(Content content, Point boxActualPlace,
			Cardinal cardinal) throws PositionOutOfBoundsException {
		return false;
	}

	/**
	 * There will never be content in a Tree
	 * 
	 * @return Null Always
	 */
	public Content getContent() {
		return null;
	}
}
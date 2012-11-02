package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public class Tree extends Cell implements Serializable {

	private static final long serialVersionUID = 1L;

	public Tree() {
	}

	@Override
	public boolean setContent(Content content) {
		return false;
	}

	@Override
	public boolean isAccesible() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see backend.Cell#setContent(backend.Content, java.awt.Point,
	 * backend.Cardinal)
	 */
	@Override
	public boolean setContent(Content content, Point boxActualPlace,
			Cardinal cardinal) throws PositionOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}
}
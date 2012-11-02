package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public abstract class Cell implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract boolean setContent(Content content, Point boxActualPlace,
			Cardinal cardinal) throws PositionOutOfBoundsException;

	/* For parser use only */
	public abstract boolean setContent(Content content);

	public abstract boolean isAccesible();
	
	public abstract Content getContent();

}
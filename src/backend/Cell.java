package backend;

import java.awt.Point;
import java.io.Serializable;

import exceptions.PositionOutOfBoundsException;

public abstract class Cell implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Sets Content from boxActualPlace to its Cardinal
	 * 
	 * @param content
	 * @param boxActualPlace
	 * @param cardinal
	 * @return True if movement was successful, False if not
	 * @throws PositionOutOfBoundsException
	 */
	public abstract boolean setContent(Content content, Point boxActualPlace,Cardinal cardinal) throws PositionOutOfBoundsException;
	
	/**
	 * Sets Content on given place
	 * 
	 * @param content
	 * @return True if placement was successful, False if not
	 */
	public abstract boolean setContent(Content content);
	
	/**
	 * Returns whether the cell is accessible by a specified content
	 * 
	 * @return True if Cell is accessible, False if not
	 */
	public abstract boolean isAccesible();
	
	/**
	 * Returns the content of actual Cell
	 * 
	 * @return Content content
	 */
	public abstract Content getContent();

}
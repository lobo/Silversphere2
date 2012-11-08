package exceptions;

public class InvalidBoardSizeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Trying to access a restricted area
	 */

	public InvalidBoardSizeException() {
		super("Trying to access restricted area");
	}
}
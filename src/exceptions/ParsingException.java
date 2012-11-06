package exceptions;

public class ParsingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * There was an error during the parsing of the incoming file
	 */
	public ParsingException() {
		super("Corrupted file. Choose another one");
	}
}
package exceptions;

public class PositionOutOfBoundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PositionOutOfBoundsException() {
		super("Corrupted file. Choose another one");
	}
}
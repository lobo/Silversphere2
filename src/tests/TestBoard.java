package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import backend.*;
import exceptions.*;

public class TestBoard {
	@Before
	public void SetUp(){
	}

	@Test
	public void TestSetPositionCardinalNORTH() throws InvalidBoardSizeException {
		Cardinal c = Cardinal.NORTH;
		Board board = new Board(9,8);
		assertTrue(board.SetPositionCardinal(new Point(1, 1), c).equals(new Point(0, 1)));
	}

	@Test
	public void NotValidPositioninBoard() throws InvalidBoardSizeException {
		Point position = new Point(29, 39);
		Board board = new Board(5,5);

		assertFalse(board.validPosition(position));
	}


	@Test(expected = IndexOutOfBoundsException.class)
	public void IndexOutofBoundExceptionInBoard()
			throws InvalidBoardSizeException {
		Board board = new Board(5,5);

		board.getBoard()[2][-2].toString();

	}

	@Test
	public void AbleToSetBoxinEmptyFloor() throws InvalidBoardSizeException,
			PositionOutOfBoundsException {
		Point point = new Point(5, 5);
		Board board = new Board(10,10);
		board.putCell(new Floor(), point);
		Content c = new Box(point, board);
		assertTrue(board.putContent(c, point));

	}

	@Test
	public void InitializeBoardNullContent() throws InvalidBoardSizeException {
		Point point = new Point(2, 5);
		Board board = new Board(6,6);
		board.putCell(new Floor(), point);

		assertTrue(((ContentOperations) board.getBoard()[point.x][point.y])
				.getContent() == null);
	}
}

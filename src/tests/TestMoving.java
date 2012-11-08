package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import backend.*;
import exceptions.*;

public class TestMoving {
	@Before
	public void SetUp(){
	}
	
	@Test
	public void MovePlayerToSamePositionBefore()
			throws InvalidBoardSizeException, PositionOutOfBoundsException {

		Board board = new Board(15, 10);
		Player player = new Player(new Point(5, 5), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);

		board.move(Cardinal.NORTH);
		assertTrue(board.move(Cardinal.SOUTH));
	}

	@Test
	public void MoveIcetoWaterRemoveItandMovePlayerToo()
			throws InvalidBoardSizeException, PositionOutOfBoundsException {

		Board board = new Board(13, 9);
		Player player = new Player(new Point(5, 5), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);

		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.SOUTH);

		Ice ice = new Ice(nextPosition, board);
		board.putContent(ice, nextPosition);
		board.putCell(new Water(),
				board.SetPositionCardinal(nextPosition, Cardinal.SOUTH));

		board.move(Cardinal.SOUTH);

		assertFalse(player.getPosition().equals(new Point(5, 5)));
	}

	@Test
	public void NotAbletoMovePlayerSOUTHToTree()
			throws InvalidBoardSizeException, PositionOutOfBoundsException {

		Board board = new Board(11, 14);
		Player player = new Player(new Point(5, 5), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);

		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.SOUTH);
		board.putCell(new Tree(), nextPosition);

		assertFalse(board.move(Cardinal.SOUTH));
	}

	@Test
	public void MovePlayerToTileWithMovingBox()
			throws InvalidBoardSizeException, PositionOutOfBoundsException {

		Board board = new Board(10, 10);
		Player player = new Player(new Point(5, 3), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);
		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.EAST);
		Box myBox = new Box(nextPosition, board);

		board.putContent(myBox, nextPosition);

		assertTrue(board.move(Cardinal.EAST));
	}

}

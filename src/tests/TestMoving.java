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
		Point pos = new Point(5,5);
		Player player = new Player(pos, board);
		board.putCell(new Floor(), pos);
		board.putCell(new Floor(), board.SetPositionCardinal(player.getPosition(),Cardinal.NORTH));
		board.putContent(player, player.getPosition());
		board.setPlayer(player);

		board.move(Cardinal.NORTH);
		assertTrue(board.move(Cardinal.SOUTH));
	}

	@Test
	public void MoveBoxToWaterandMovePlayerToo()
			throws InvalidBoardSizeException, PositionOutOfBoundsException {

		Board board = new Board(13, 9);
		Point pos = new Point(5,5);
		Player player = new Player(pos, board);
		board.putCell(new Floor(), pos);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);

		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.SOUTH);

		Box box = new Box(nextPosition, board);
		board.putCell(new Floor(), nextPosition);
		board.putContent(box, nextPosition);
		
		Point nextPosition2 = board.SetPositionCardinal(nextPosition, Cardinal.SOUTH);
		
		board.putCell(new Water(),nextPosition2);

		board.move(Cardinal.SOUTH);

		assertFalse(player.getPosition().equals(new Point(5, 5)));
	}

	@Test
	public void NotAbletoMovePlayerSOUTHToTree()
			throws InvalidBoardSizeException, PositionOutOfBoundsException {

		Board board = new Board(11, 14);
		Point pos = new Point(5,5);
		Player player = new Player(pos, board);
		board.putCell(new Floor(), pos);
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
		Point pos = new Point(5,3);
		Player player = new Player(pos, board);
		
		board.putCell(new Floor(), pos);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);
		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.EAST);
		Box myBox = new Box(nextPosition, board);
		
		board.putCell(new Floor(), nextPosition);
		board.putContent(myBox, nextPosition);
		board.putCell(new Floor(), board.SetPositionCardinal(nextPosition,
				Cardinal.EAST));

		assertTrue(board.move(Cardinal.EAST));
	}

}

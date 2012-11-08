package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import backend.Board;
import backend.Box;
import backend.Cardinal;
import backend.Ice;
import backend.Player;
import backend.Tree;
import backend.Water;
import exceptions.InvalidBoardSizeException;
import exceptions.PositionOutOfBoundsException;

public class TestMoving {
	@Test
	public void MovePlayerNORTHtoEmptyFloor() throws InvalidBoardSizeException,
			PositionOutOfBoundsException {

		Board board = new Board(15, 10);
		Player player = new Player(new Point(5, 5), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);

		assertTrue(board.move(Cardinal.NORTH));

	}

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
	public void MoveToWaterandIceBeRemoved() throws InvalidBoardSizeException,
			PositionOutOfBoundsException {

		Board board = new Board(10, 10);
		Player player = new Player(new Point(5, 5), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);
		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.SOUTH);

		Ice ice = new Ice(nextPosition, board);
		board.putContent(ice, nextPosition);
		board.putCell(new Water(),
				board.SetPositionCardinal(nextPosition, Cardinal.SOUTH));

		assertTrue(board.move(Cardinal.SOUTH));
		// assertTrue(((ContentOperations)(board.getTile(nextPosition))).getContent()==null);
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

		Box box = new Box(nextPosition, board);
		board.putContent(box, nextPosition);
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
		// Si la posicion es 5,5 no me deja moverme al norte, tira error (pero
		// nadie avisa)

		Board board = new Board(10, 10);
		Player player = new Player(new Point(5, 3), board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);
		Point nextPosition = board.SetPositionCardinal(player.getPosition(),
				Cardinal.EAST);
		Box myBox = new Box(nextPosition, board);

		board.putContent(myBox, nextPosition);

		assertTrue(board.move(Cardinal.EAST));
		/*
		 * assertTrue(myBox.move(myBox.getPosition(), Cardinal.EAST)); // OK.
		 * assertTrue(board.getTile(nextPosition).setContent(board.getSmile(),
		 * nextPosition, new Point(board.SetPositionCardinal(nextPosition,
		 * Cardinal.EAST)), Cardinal.EAST)); // OK.
		 * assertTrue(board.validPosition(nextPosition)); // OK.
		 */

	}

}

package manager;

import java.awt.Point;
import java.io.*;

import backend.*;
import exceptions.ParsingException;

public class Parser {

	private int columns = 0;
	private int rows = 0;
	private Board board;
	boolean playerExists = false;
	boolean targetExists = false;
	boolean interruptorExists = false;
	private static final char PLAYER = '@';
	private static final char BOX = 'B';
	private static final char TARGET = 'G';
	private static final char TREE = 'T';
	private static final char WATER = '#';
	private static final char ICE = 'C';
	private static final char INTERRUPTOR = 'K';
	private static final char FLOOR = ' ';

	/**
	 * This method parses a file to check if all the data is correct.
	 * 
	 * @param file
	 *            An input file where to obtain the data from.
	 * @return A board created with the data from the file.
	 * @throws IOException
	 *             If the file couldn't be opened.
	 */

	public Board parse(File file) throws IOException {
		String line;
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(file));
			while ((line = (buffer.readLine())) != null) {
				line = deleteTabs(line);
				if (line.length() > 1) {
					if (columns == 0) {
						columns = line.length();
					}
					if (line.length() != columns) {
						throw new ParsingException();
					}
					rows++;
				}
			}
			board = new Board(rows, columns);
			if (buffer != null) {
				buffer.close();
			}

			buffer = new BufferedReader(new FileReader(file));
			rows = 0;
			while ((line = (buffer.readLine())) != null) {
				line = deleteTabs(line);
				checkElementsValues(line, rows);
				rows++;
			}
			return board;
		} finally {
			if (buffer != null) {
				buffer.close();
			}
		}
	}

	/**
	 * This method deletes every tab from a string.
	 * 
	 * @param line
	 *            A string representing a line of the file.
	 * @return A new string without tabs.
	 */
	private String deleteTabs(String line) {
		char aux;
		String resp = new String();
		for (int i = 0; i < line.length(); i++) {
			if ((aux = line.charAt(i)) != '\t')
				resp += aux;
		}
		return resp;
	}

	/**
	 * This method checks each element values to see if they are correct.
	 * 
	 * @param line
	 *            An array of strings representing each of the parameters of a
	 *            line separated by a comma.
	 */
	private void checkElementsValues(String line, int rowActual) {
		int index = 0;
		Content element = null;
		Cell cell = null;
		Point p;
		char symbol;

		if (line.length() != columns) {
			throw new ParsingException();
		}
		while (index < columns) {
			p = new Point(rowActual, index);
			symbol = line.charAt(index);
			
			checkSymbolExistance(symbol);
			validateExistance(symbol);
			
			switch (symbol) {
			case PLAYER: {
				board.putCell(new Floor(), p);
				element = new Player(p, board);
				board.putContent(element, p);
				board.setPlayer((Player) element);
				playerExists = true;
				break;
			}
			case BOX: {
				board.putCell(new Floor(), p);
				element = new Box(p, board);
				board.putContent(element, p);
				break;
			}
			case TARGET: {
				board.putCell(new Target(), p);
				targetExists = true;
				break;
			}
			case TREE: {
				board.putCell(new Tree(), p);
				break;
			}
			case WATER: {
				board.putCell(new Water(), p);
				break;
			}
			case ICE: {
				board.putCell(new Floor(), p);
				element = new Ice(p, board);
				board.putContent(element, p);
				break;
			}
			case INTERRUPTOR: {
				cell = new Interruptor();
				board.putCell(cell, p);
				board.setInterruptor((Interruptor)cell);
				interruptorExists = true;
				break;
			}
			case FLOOR: {
				board.putCell(new Floor(), p);
				break;
			}
			}
			index++;
		}

	}

	/**
	 * This method checks if the element is an existing type of element.
	 * 
	 * @param symbol
	 *            A char representing the type of element.
	 */

	public void checkSymbolExistance(char symbol) {
		if (symbol != 'G' && symbol != 'T' && symbol != '#' && symbol != 'B'
				&& symbol != 'C' && symbol != ' ' && symbol != '@'
				&& symbol != 'K') {
			throw new ParsingException();
		}
	}
	
	/**
	 * This method checks if the unique elements are repeated
	 * 
	 * @param symbol
	 *            A char representing the type of element.
	 */
	
	public void validateExistance(char symbol){
		if(((symbol == PLAYER) && (playerExists)) || ((symbol == TARGET) && (targetExists)) || ((symbol == INTERRUPTOR) && (interruptorExists))){
			throw new ParsingException();
		} 
	}

}
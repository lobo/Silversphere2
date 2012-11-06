package backend;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import frontend.InstanceBoardListener;

public class SaveandLoadGame {

	public SaveandLoadGame() {
	}

	/**
	 * Save game in new file
	 * 
	 * @param board
	 *            Board to save
	 * @param file
	 *            name of the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public void SaveGame(Board board, String file)
			throws FileNotFoundException, IOException {
		try {
			ObjectOutputStream newFile = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			newFile.writeObject(board);
			newFile.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unable To Save");
			e.printStackTrace();
		}
	}

	/**
	 * Create a game with saved information
	 * 
	 * @see SaveGame
	 * 
	 * @param file
	 *            name of the file
	 * @return Board in the file.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	public Board LoadGame(String file) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		try {
			ObjectInputStream newfile = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
			Board board = (Board) newfile.readObject();
			board.setInstanceBoardListener(new InstanceBoardListener()); 
			return board;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Unable to Load - Unacceptable File Type");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Unable to Load - Unacceptable File Type");
			e.printStackTrace();
		}
		return null;
	}

}

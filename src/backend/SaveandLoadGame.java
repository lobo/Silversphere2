package backend;

import java.io.*;

import javax.swing.JOptionPane;

public class SaveandLoadGame {

	/**
	 * Creates a new SaveAndLoadGame
	 * 
	 */
	public SaveandLoadGame() {
	}

	/**
	 * Save game in new file
	 * 
	 * @param board
	 * @param file
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
	 * @param file
	 * @return Board in the file.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	public Board LoadGame(String file) throws FileNotFoundException,IOException, ClassNotFoundException {
		try {
			ObjectInputStream newfile = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
			Board board = (Board) newfile.readObject();
			return board;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Unable to Load - Unacceptable File Type");
			throw new IOException();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Unable to Load - Unacceptable File Type");
			throw new IOException();
			}
	}

}

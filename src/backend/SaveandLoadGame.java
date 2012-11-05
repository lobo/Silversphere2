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

public class SaveandLoadGame {

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

	public Board LoadGame(String file) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		try {
			ObjectInputStream newfile = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
			Board game = (Board) newfile.readObject();
			/*
			 * ENTRE COMMENTS PORQUE NO COMPILA
			 * game.getBoard().setInstanceBoardListener( new
			 * InstanceBoardListener()); return game;
			 */
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

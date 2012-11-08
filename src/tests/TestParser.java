package tests;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import backend.*;
import exceptions.*;

public class TestParser {
	@Before
	public void SetUp(){
	}
	
	@Test
	public void deleteTabsCheck(){

		String line = "a	a	a	a	a				a";
		manager.Parser p = new manager.Parser();
		line = p.deleteTabs(line);

		assertTrue(line.equals("aaaaaa"));
	}
	
	@Test
	public void SymbolCheck(){

		char s = 'J';
		boolean aux=false;
		manager.Parser p = new manager.Parser();
		try{
			p.checkSymbolExistance(s);
		}catch(ParsingException e){
			aux = true;
		}
		
		assertTrue(aux);	
	}
	
	@Test
	public void ValidSymbolCheck(){
		
		char s = '@';
		boolean aux=false;
		
		Board board = new Board(5,5);
		Point pos = new Point(1,1);
		board.putCell(new Floor(), pos);
		Player player = new Player(pos, board);
		board.putContent(player, player.getPosition());
		board.setPlayer(player);
		manager.Parser p = new manager.Parser();
		p.setPlayerExists();
		
		try{
			p.validateExistance(s);
		}catch(ParsingException e){
			aux = true;
		}
		
		assertTrue(aux);	
	}

}

package com.aiboggle.api.game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//import gameData.GameScore;
//import Misc.Debugging;
//import Network.Connectivity;
import com.aiboggle.api.simulatedIntelligence.AI_Player;


public class Boggle {

	private ArrayList<Dice> dice;
	private ArrayList<String> board; 
	//private ArrayList<Player> players;
	private AI_Player ai_player;
	
	public Boggle() { 
		this.dice = new ArrayList<Dice>();
		this.board = new ArrayList<String>();
		//this.players = new ArrayList<Player>();
		this.ai_player = new AI_Player( new ArrayList<String>() );
		this.createDice();
	}
	
	public void playTurn() throws FileNotFoundException { 
		this.generateBoard();
		this.ai_player.getBoardAccess( this.board );
		//GameScore.getInstance().scoreGame(this);
	}
	
	
	public void generateBoard() { 
		this.board.clear();
		for( int x =0; x < this.dice.size(); x++ ) { 
		//for( int x = 0; x<4; x++ ) {
			this.board.add( this.dice.get(x).rollDice() );
		}
		//AllBoards.getInstance().addNewBoard(this.board);
	}
	
	public void setGameBoard( String board ) {
		this.board = new ArrayList<String>( Arrays.asList( board.split(",")) );
	}
	public ArrayList<String> getGameBoard() { 
		return this.board;
	}
	public String getGameBoardAsString() { 
		StringBuilder gameBoard = new StringBuilder();
		for( int x = 0 ; x < this.board.size(); x++) { 
			gameBoard.append( this.board.get(x) + " " );
			
		}
		return gameBoard.toString();
	}
	public AI_Player getAI_Player() { 
		return this.ai_player;
	}
	//public ArrayList<Player> getPlayers() { 
	//	return this.players;
	//}
	//public void addPlayers( ArrayList<Player> players ) { 
	//	this.players = players;
	//}
	
	public void printBoard() { 
		StringBuilder boardString = new StringBuilder();
		for( int x = 0; x < this.board.size(); x++ ) { 
			boardString.append( this.board.get(x) );
			if(x!= 0 && x % 4 == 0 ) { 
				boardString.append( "\n" );
			}
		}
		System.out.println( boardString.toString() );
	}
	
	public void printDiceLetters() { 
		for( int x = 0 ; x < this.dice.size(); x++ ) { 
			System.out.println(this.dice.get(x).toString());
		}
	}
	
	public void createDice() { 
		ArrayList<ArrayList<String>> allDice = new ArrayList<ArrayList<String>>();

		allDice.add(0,new ArrayList<String>());
		allDice.get(0).add("R"); 
		allDice.get(0).add("I"); 
		allDice.get(0).add("F"); 
		allDice.get(0).add("O"); 
		allDice.get(0).add("B"); 
		allDice.get(0).add("X"); 
		
		allDice.add(1,new ArrayList<>());
		allDice.get(1).add("I"); 
		allDice.get(1).add("F"); 
		allDice.get(1).add("E"); 
		allDice.get(1).add("H"); 
		allDice.get(1).add("E"); 
		allDice.get(1).add("Y"); 
		
		allDice.add(2,new ArrayList<>());
		allDice.get(2).add("D"); 
		allDice.get(2).add("E"); 
		allDice.get(2).add("N"); 
		allDice.get(2).add("O"); 
		allDice.get(2).add("W"); 
		allDice.get(2).add("S"); 
		
		allDice.add(3,new ArrayList<>());
		allDice.get(3).add("U"); 
		allDice.get(3).add("T"); 
		allDice.get(3).add("O"); 
		allDice.get(3).add("K"); 
		allDice.get(3).add("N"); 
		allDice.get(3).add("D"); 
		
		allDice.add(4,new ArrayList<>());
		allDice.get(4).add("H"); 
		allDice.get(4).add("M"); 
		allDice.get(4).add("S"); 
		allDice.get(4).add("R"); 
		allDice.get(4).add("A"); 
		allDice.get(4).add("O"); 

		allDice.add(5,new ArrayList<>());
		allDice.get(5).add("L"); 
		allDice.get(5).add("U"); 
		allDice.get(5).add("P"); 
		allDice.get(5).add("E"); 
		allDice.get(5).add("T"); 
		allDice.get(5).add("S"); 
				
		allDice.add(6,new ArrayList<>());
		allDice.get(6).add("A"); 
		allDice.get(6).add("C"); 
		allDice.get(6).add("I"); 
		allDice.get(6).add("T"); 
		allDice.get(6).add("O"); 
		allDice.get(6).add("A"); 
		
		allDice.add(7,new ArrayList<>());
		allDice.get(7).add("Y"); 
		allDice.get(7).add("L"); 
		allDice.get(7).add("G"); 
		allDice.get(7).add("K"); 
		allDice.get(7).add("U"); 
		allDice.get(7).add("E"); 

		allDice.add(8,new ArrayList<>());
		allDice.get(8).add("Qu"); 
		allDice.get(8).add("B"); 
		allDice.get(8).add("M"); 
		allDice.get(8).add("J"); 
		allDice.get(8).add("O"); 
		allDice.get(8).add("A"); 
		
		allDice.add(9,new ArrayList<>());
		allDice.get(9).add("E"); 
		allDice.get(9).add("H"); 
		allDice.get(9).add("I"); 
		allDice.get(9).add("S"); 
		allDice.get(9).add("P"); 
		allDice.get(9).add("N"); 
		
		allDice.add(10,new ArrayList<>());
		allDice.get(10).add("V"); 
		allDice.get(10).add("E"); 
		allDice.get(10).add("T"); 
		allDice.get(10).add("I"); 
		allDice.get(10).add("G"); 
		allDice.get(10).add("N"); 
		
		allDice.add(11,new ArrayList<>());
		allDice.get(11).add("B"); 
		allDice.get(11).add("A"); 
		allDice.get(11).add("L"); 
		allDice.get(11).add("I"); 
		allDice.get(11).add("Y"); 
		allDice.get(11).add("T"); 
		
		allDice.add(12,new ArrayList<>());
		allDice.get(12).add("E"); 
		allDice.get(12).add("Z"); 
		allDice.get(12).add("A"); 
		allDice.get(12).add("V"); 
		allDice.get(12).add("N"); 
		allDice.get(12).add("D"); 
		
		allDice.add(13,new ArrayList<>());
		allDice.get(13).add("R"); 
		allDice.get(13).add("A"); 
		allDice.get(13).add("L"); 
		allDice.get(13).add("E"); 
		allDice.get(13).add("S"); 
		allDice.get(13).add("C"); 
		
		allDice.add(14,new ArrayList<>());
		allDice.get(14).add("U"); 
		allDice.get(14).add("W"); 
		allDice.get(14).add("I"); 
		allDice.get(14).add("L"); 
		allDice.get(14).add("R"); 
		allDice.get(14).add("G"); 
		
		allDice.add(15,new ArrayList<>());
		allDice.get(15).add("P"); 
		allDice.get(15).add("A"); 
		allDice.get(15).add("C"); 
		allDice.get(15).add("E"); 
		allDice.get(15).add("M"); 
		allDice.get(15).add("D"); 
		
		for( int x = 0; x < allDice.size(); x++) { 
			this.dice.add( new Dice( allDice.get(x) ) );
		}
		
		
	}
	
}

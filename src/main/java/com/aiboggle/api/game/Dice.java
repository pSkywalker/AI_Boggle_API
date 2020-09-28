package com.aiboggle.api.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import Misc.Debugging;

public class Dice {

	private Random random;
	private Scanner scanner;
	
	private ArrayList< String > letters;
	
	public Dice() { 
		this.random = new Random(); 
		this.scanner = new Scanner( System.in );
		
		this.letters = new ArrayList<String>();
	}
	
	public Dice( ArrayList<String> letters ) { 
		this.random = new Random();
		this.letters = letters;
	}
	
	public void addLetter( String letter ) { 
		if( this.letters.size() > 5 ) { 
			this.editLetter();
		}
		this.letters.add( letter );
	}
	
	public void editLetter() { 
		System.out.println( "The dice can only contain 6 letters.\n Currently the letters on the dice are:" );
		for( int x = 0; x < this.letters.size(); x++ ) { 
			System.out.println( x+". " + this.letters.get(x) );
		}
		System.out.println( "Enter the number for the letter you want to change." );
		Integer letterSelection = scanner.nextInt();
		if( letterSelection > this.letters.size()-1 ) { 
			return;
		}
		System.out.println( "What letter do you want change?" );
		String newLetter = scanner.next();
		this.letters.set(letterSelection , String.valueOf(newLetter.charAt(0)));
	}
	
	public String rollDice() {
		Integer rollIndex  = random.nextInt( ( this.letters.size()-1 ) + 1 ) ;
		//Debugging.printDebug( rollIndex );
		return this.letters.get( rollIndex );
	}
	
	public String toString() { 
		StringBuilder allLetters = new StringBuilder();
		for( int x = 0; x < this.letters.size(); x++ ) { 
			allLetters.append( this.letters.get(x) + " " );
		}
		return allLetters.toString();
	}
	
}

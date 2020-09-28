package com.aiboggle.api.simulatedIntelligence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.google.common.collect.Collections2;

import com.aiboggle.api.game.Word;
import com.aiboggle.api.gameData.WordDatabase;



public class AI_Player{

	private String username;
	
	private ArrayList< ArrayList<String> > allboards; 
	private ArrayList<String> currentBoard;
	
	private ArrayList<Word> wordsForCurrentGame;
	
	public AI_Player( ArrayList<String> board ) {
		//System.out.println("AI is running on port: " + connectedToPort);
		username = "AI";
		this.allboards = new ArrayList<ArrayList<String>>();
		this.currentBoard = board;	
		
		this.wordsForCurrentGame = new ArrayList<Word>();
	}
	
	public AI_Player() { 
		this.username =" AI";
		this.allboards = new ArrayList< ArrayList<String> >();
		this.currentBoard  = new ArrayList<String>();
	}

	
	public void getBoardAccess( ArrayList<String> board ) { 
		//if( this.currentBoard.isEmpty() ) { 
		//	this.allboards.add(this.currentBoard);
		//}
		this.currentBoard = board;

		//this.play();
		//System.out.println( "Ai is about to start training" );
		//this.train();
	}
	public ArrayList<String> getCurrentBoard(){ 
		return this.allboards.get(this.allboards.size()-1);
	}
	
	public ArrayList<Word> getWordsFoundForLatestGame(){ 
		return wordsForCurrentGame;
	}
	
	
	public void play() { 
		if( WordDatabase.getInstance().getSizeOfWordDatabase() < 1 ) { 
			//Connectivity.getInstance().printNoWordsError();
			return;
		}
		Collection<List<String>> allCombinations = Collections2.permutations(this.currentBoard);
		Stream<List<String>> comboStream = allCombinations.stream();
		
		comboStream.forEach( new Consumer<Object>() {

			@Override
			public void accept(Object t) {
				// TODO Auto-generated method stub
			
				try {
					//System.out.println( t.toString() );
					String wordAsString = t.toString().replace("[", "").replace("]", "").replace(",","").replace(" ", "");
					Integer multiple = 3;
					while( true ) {
						Integer currentVal = 0 ;
						//System.out.println( wordAsString );
						//System.out.println( multiple );
						while(true) {
							Word word = new Word(wordAsString.substring(currentVal, currentVal+multiple),false);
							//System.out.println("Current word:" + String.valueOf( currentWordBeingChecked ) );
							WordDatabase.getInstance().searchLearnedWords(word);
							
							if( word.isValid() ) { 
								boolean wordFoundAlready = false;
								for( int x = 0; x < wordsForCurrentGame.size();x++ ) { 
									if( word.getWord().toLowerCase().charAt(0) > wordsForCurrentGame.get(x).getWord().toLowerCase().charAt(0) ) { 
										break;
									}
									if( word.getWord().toLowerCase().equals(wordsForCurrentGame.get(x).getWord().toLowerCase()) ) { 
										wordFoundAlready = true;
									}
								}
								if( !wordFoundAlready ) {
									wordsForCurrentGame.add(word);
								}
							}
							
							
							//networkCommunication(
							//		"Current word:" + String.valueOf( currentWordBeingChecked ) + " / " + allCombinations.size()
							//		);
							//System.out.println( wordAsString.substring( currentVal, currentVal+multiple) );
							
							currentVal++;
							if( currentVal > 15 || currentVal + multiple > 15 ) { 
								break;
							}
						}
						multiple++;
						if( multiple > 8 ) {
							break;
						}
					}
				}catch( Exception ex ) { 
					
				}
				
			} 
			
		});
	}

	public void train() { 
		System.out.println( "AI started training" );
		
		// 788204889
		
		Collection<List<String>> allCombinations = Collections2.permutations(this.currentBoard);
		//Object[] allCombos = allCombinations.toArray();
		
		Stream<List<String>> comboStream = allCombinations.stream();
		//Object comboString = comboStream.iterator().next().toString();
				
		
		comboStream.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				// TODO Auto-generated method stub
				
				try {
					//System.out.println( t.toString() );
					String wordAsString = t.toString().replace("[", "").replace("]", "").replace(",","").replace(" ", "");
					Integer multiple = 3;
					while( true ) {
						Integer currentVal = 0;
						//System.out.println( wordAsString );
						//System.out.println( multiple );
						while(true) { 
							//System.out.println("Current word:" + String.valueOf( currentWordBeingChecked ) );
							//System.out.println( wordAsString.substring(currentVal, Integer.valueOf(currentVal+multiple)) );
							WordDatabase.getInstance().searchForWord(
									new Word(wordAsString.substring(Integer.valueOf(currentVal), Integer.valueOf(currentVal+multiple) ), false));
							//networkCommunication(
							//		"Current word:" + String.valueOf( currentWordBeingChecked ) + " / " + allCombinations.size()
							//		);
							//System.out.println( wordAsString.substring( currentVal, currentVal+multiple) );
							
							currentVal++;
							//System.out.println( currentVal + " " + currentVal+multiple );
							if( currentVal > 15 || currentVal + multiple > 15 ) { 
								break;
							}
						}
						multiple++;
						if( multiple > 8 ) {
							break;
						}
					}
				}catch( Exception e ) { 
					e.printStackTrace();
				}	
			} 
			
		});
		
		WordDatabase.getInstance().printAllFoundWords();
		
	}
	
	public void updateAI_metaData() throws FileNotFoundException {
		//for( int x = 0; x < this.allPossibleCombinations.size(); x++ ) { 
		//	WordDatabase.getInstance().searchForWord( this.allPossibleCombinations.get(x) );
		//}
		this.allboards.add(this.currentBoard);
		this.currentBoard.clear();
	}
	
}



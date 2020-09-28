package com.aiboggle.api.gameData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.aiboggle.api.game.ExternalWordSource;
import com.aiboggle.api.game.Word;

//import Network.Connectivity;

public class WordDatabase implements Serializable{

	public String filePath_forSerialization = "src/main/java/wordDataBase.ser";
	
	public static WordDatabase instance = null;
	private ArrayList<Word> words; 
	private PrintWriter socketOutput;

	public WordDatabase() { 
		this.words = new ArrayList<Word>();
	}
	
	public void setSocketOutput(PrintWriter socketOutput) { 
		this.socketOutput = socketOutput;
		System.out.println( "added socket output" );
		this.socketOutput.println( "Test from word Database class" );
	}
	
	public static WordDatabase getInstance() { 
		if( instance == null ) { 
			instance = new WordDatabase();
		}
		return instance;
	}
	
	public void serialize() throws IOException { 
		FileOutputStream fileOutput = new FileOutputStream(this.filePath_forSerialization);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutput );
		objectOutputStream.writeObject(this);
		objectOutputStream.close();
		fileOutput.close();
	}
	public void deserialize() {	
		try { 
			FileInputStream fileIn = new FileInputStream(this.filePath_forSerialization);
			ObjectInputStream objectStream = new ObjectInputStream( fileIn );
			instance = (WordDatabase) objectStream.readObject();
		}
		catch(Exception exception) { 
			
		}
	}
	
	public void searchLearnedWords( Word word ) { 
		//this.socketOutput.println( "Search learned words function" );
		for( int x = 0; x < this.words.size(); x++ ) { 
			if( this.words.get(x).getWord().charAt(0) < word.getWord().charAt(0) ) { 
				break;
			}
			if( this.words.get(x).getWord().toLowerCase().equals(word.getWord().toLowerCase()) ){ 
				word.setValid(true);
				//System.out.println( word.getWord() );
			}
		}
	}
	
	public void searchForWord( Word word ) throws FileNotFoundException {
		//System.out.println( word.getWord() );
		//this.socketOutput.println( "searchForWord function" );

		for( int x = 0; x < this.words.size(); x++ ) { 
			if( this.words.get(x).getWord().charAt(0) < word.getWord().charAt(0) ) { 
				break;
			}
			if( this.words.get(x).getWord().toLowerCase().equals(word.getWord().toLowerCase()) ){ 
				word.setValid(true);
				//System.out.println( word.getWord() );
			}
		}
		//System.out.println( word.getWord() );
		if( !word.isValid() ) { 
			ExternalWordSource.getInstance().findWord(word);
			//System.out.println( word.getWord()+ " " + word.isValid() );
			if( word.isValid() ) {
				boolean wordAlreadyExists = false;
				for( int x = 0; x < this.words.size(); x++ ) { 
					if( this.words.get(x).getWord().toLowerCase().charAt(0) < word.getWord().toLowerCase().charAt(0) ) { 
						//break;
					}
					if( this.words.get(x).getWord().toLowerCase().equals( word.getWord().toLowerCase() ) ) { 
						wordAlreadyExists = true;
					}
				}
				if( !wordAlreadyExists ) { 
					this.words.add(word);
					System.out.println( word.getWord() );
					
					this.socketOutput.println( word.getWord() );
					//Connectivity.getInstance().printToClient( word.getWord()  );
				}
			}
		}
		
	}
	
	public void addNewWord( Word word ) { 
		Boolean wordAlreadyExists = false;
		for( int x = 0 ; x < this.words.size(); x++ ) { 
			if( word.getWord().toLowerCase().charAt(0) > this.words.get(x).getWord().toLowerCase().charAt(0) ) { 
				break;
			}
			if( word.getWord().toLowerCase().equals(this.words.get(x).getWord().toLowerCase()) ) { 
				wordAlreadyExists = true;
			}
		}
		if( !wordAlreadyExists ) { 
			this.words.add(word);
		}
	}
	public ArrayList<Word> getKnownWords(){ 
		return this.words;
	}
	public void emptyDataBase() { 
		this.words.clear();
	}
	
	public Integer getSizeOfWordDatabase() { 
		return this.words.size();
	}
	
	public void printAllFoundWords() { 
		for( int x = 0; x < this.words.size(); x++ ) { 
			System.out.println( this.words.get(x) );
		}
	}
	
		
}


package com.aiboggle.api.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import Misc.Debugging;

public class ExternalWordSource {

	public static ExternalWordSource instance;

	private String fileName = "src/main/java/wordList.txt";
	
	private File file;
	private Scanner fileReader;
	
	public ExternalWordSource() throws FileNotFoundException { 
		this.file = new File( fileName );
		//this.fileReader = new Scanner( this.file );
	}
	public ExternalWordSource( String fileName ) throws FileNotFoundException { 
		this.fileName = fileName;
		//this.fileReader = new Scanner( this.file );
	}
	
	public static ExternalWordSource getInstance() throws FileNotFoundException { 
		if( instance == null ) { 
			instance = new ExternalWordSource();
		}
		return instance;
	}
	
	public void findWord( Word word ) throws FileNotFoundException { 
		// replace with more efficient algo
		// set fileReader delimeter to start
		this.fileReader = new Scanner( this.file );
		while( fileReader.hasNextLine() ) { 
			String externalWord = fileReader.nextLine();
			//if(  word.getWord().toLowerCase().charAt(0) < externalWord.toLowerCase().charAt(0) ) { 
				
			//}
			//System.out.println( word.getWord().toLowerCase() + " : " + externalWord.toLowerCase() );
			//System.out.println( 
			//		word.getWord().toLowerCase().equals(externalWord.toLowerCase())
			//		+ " for word comparison: " + 
			//		word.getWord().toLowerCase() + " : " + externalWord.toLowerCase()
			//		);
			if( word.getWord().toLowerCase().equals(externalWord.toLowerCase())  ) { 
				//System.out.println( word.getWord() );
				word.setValid(true);
			}
		}
	}
	
	public void printEntireFile() { 
		while ( fileReader.hasNextLine() ) {
			System.out.println( fileReader.nextLine() );
		}
	}
	
	
}


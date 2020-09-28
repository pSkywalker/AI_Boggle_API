package com.aiboggle.api.game;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class Word implements Serializable{

	private String word;
	private Integer points;
	private Boolean valid;
	
	public Word( String word, Boolean setValid ) { 
		this.word = word;
		this.points = this.word.length();
		
		this.valid = false;
		
		if( setValid ) { 
			try {
				ExternalWordSource.getInstance().findWord(this);
			} catch (FileNotFoundException e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public String getWord() { 
		return this.word;
	}
	public Integer getPoints() { 
		return this.points;
	}
	public String toString() { 
		return this.word + " for " + this.points;
	}
	public void setValid( boolean valid ) { 
		this.valid = true;
	}
	public Boolean isValid() { 
		return this.valid;
	}
	
	
	
}

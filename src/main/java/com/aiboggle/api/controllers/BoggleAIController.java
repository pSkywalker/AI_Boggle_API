package com.aiboggle.api.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiboggle.api.game.Boggle;
import com.aiboggle.api.game.Word;
import com.aiboggle.api.gameData.WordDatabase;
import com.aiboggle.api.simulatedIntelligence.AI_Player;

@RestController
public class BoggleAIController {

	private Boggle boggle;
	private AI_Player ai;
	
	public BoggleAIController(){ 
		this.boggle = new Boggle();
		this.ai = new AI_Player();
		WordDatabase.getInstance().deserialize();
	}
	
	@GetMapping("/play")
	public ArrayList<Word> startAI_play( HttpServletResponse response ) throws IOException { 
		PrintWriter printWriter = response.getWriter();
		WordDatabase.getInstance().setSocketOutput( printWriter );
		
		this.ai.play();
		return this.ai.getWordsFoundForLatestGame();
	}
	
	@GetMapping("/train")
	public void startAI_train( HttpServletResponse response ) throws IOException, InterruptedException { 
		PrintWriter printWriter = response.getWriter();
		//for( int x = 0; x < 1000000; x++ ) { 
		//	printWriter.println( x );
		//}
		WordDatabase.getInstance().setSocketOutput( printWriter );
		printWriter.println( "Test from / mapping" );
		ai.train();
	}
	
	
	
	@GetMapping( "serializeWordDatabase" )
	public ArrayList<Word> serializeWordDatabase(){ 
		try {
			WordDatabase.getInstance().serialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return WordDatabase.getInstance().getKnownWords();
	}
	
	@GetMapping( "/addKnownWord" )
	public ArrayList<Word> addKnownWord(
			@RequestParam(value="word", defaultValue="software") String word
			) {
		WordDatabase.getInstance().addNewWord(new Word( word, true ));
		return WordDatabase.getInstance().getKnownWords();
	}
		
	@GetMapping("/getCurrentBoard")
	public ArrayList<String> getCurrentBoard(){ 
		return this.boggle.getGameBoard();
	}
	
	@GetMapping("/setBoard")
	public ArrayList<String> setBoard(
			@RequestParam(value="board", defaultValue="[]") String board
			) { 
		this.boggle.setGameBoard( board );
		this.ai.getBoardAccess( boggle.getGameBoard() );
		return this.boggle.getGameBoard();
	}
	
	@GetMapping( "/generateBoard" )
	public ArrayList<String> getBoard(){ 
		this.boggle.generateBoard();
		this.ai.getBoardAccess( this.boggle.getGameBoard() );
		return this.boggle.getGameBoard();
	}
	
	@GetMapping( "/listAllKnownWords" )
	public ArrayList<Word> getAllKnownWords(){ 
		return WordDatabase.getInstance().getKnownWords();
	}
	
	
}

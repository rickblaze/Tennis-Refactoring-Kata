package com.clean.code;

import com.clean.code.game.point.GameScorer;

public class TennisGame1 implements TennisGame {
    
    // Delegated the game scoring logic to GameScorer. SRP principle.
    private GameScorer gameScorer;

    public TennisGame1(String player1Name, String player2Name) {
        gameScorer = new GameScorer(player1Name, player2Name);
    }

	@Override
	public void wonPoint(String playerName) {
		gameScorer.addPointFor(playerName);		
	}
	
	//Code Smell - Bloating & If-else, Switch case statement
	@Override
	public String getScore() {
		return gameScorer.getScore();
	}    
}

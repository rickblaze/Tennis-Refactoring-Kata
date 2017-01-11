package com.clean.code.game.point;

import java.util.HashMap;
import java.util.Map;

import com.clean.code.game.score.AdvantageScoreFinder;
import com.clean.code.game.score.NormalScoreFinder;
import com.clean.code.game.score.TiedScoreFinder;

public class GameScorer {
	
	private static final int ZERO_POINT = 0;
	private Map<String, Integer> playerPoints;
	private String player1;
	private String player2;
	
	private TiedScoreFinder tiedScoreFinder;
	private AdvantageScoreFinder advantageScoreFinder;
	private NormalScoreFinder normalScoreFinder;
	
	public GameScorer(String player1, String player2){
		this.player1 = player1;
		this.player2 = player2;
		initializeScorerWithPlayers(this.player1, this.player2);
		tiedScoreFinder = new TiedScoreFinder();
		advantageScoreFinder = new AdvantageScoreFinder();
		normalScoreFinder = new NormalScoreFinder();
	}

	private void initializeScorerWithPlayers(String player1, String player2) {
		playerPoints = new HashMap<>();
		playerPoints.put(player1, ZERO_POINT);
		playerPoints.put(player2, ZERO_POINT);
	}
	
	public void addPointTo(String player) {
		playerPoints.put(player, addOnePointFor(player));
    }

	public int addOnePointFor(String player) {
		return playerPoints.getOrDefault(player, ZERO_POINT) + 1;
	}

    public String getScore() {
        int player1Score = playerPoints.get(player1);
        int player2Score = playerPoints.get(player2);
        
        // Created method to check for Tied Score
        if (areScoresTied(player1Score, player2Score))
        {
        	// Code Smell - Switch Case statements.
        	return tiedScoreFinder.getScore(player1Score, player2Score);
        }
        // Created method to check for Advantage or Win scenario.
        else if (isScoreAnAdvantage(player1Score, player2Score))
        {
        	//Code - Smell - Multiple if-else statements
            return advantageScoreFinder.getScore(player1Score, player2Score);
        }
        else
        {
        	//Code - Smell - Multiple if-else & switch statements
            return normalScoreFinder.getScore(player1Score, player2Score);
        }
    }

    private boolean isScoreAnAdvantage(int player1Score, int player2Score) {
		return hasPlayerWonFourPoints(player1Score) || hasPlayerWonFourPoints(player2Score);
	}

	private boolean hasPlayerWonFourPoints(int playerScore) {
		return playerScore >= 4;
	}

	private boolean areScoresTied(int player1Score, int player2Score) {
		return player1Score == player2Score;
	}
}

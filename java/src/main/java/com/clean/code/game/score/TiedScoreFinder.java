package com.clean.code.game.score;

import java.util.HashMap;
import java.util.Map;

public class TiedScoreFinder implements ScoreFinder {
	
private Map<Integer, String> scores;
	
	public TiedScoreFinder(){
		populateScores();
	}
	
	private void populateScores(){
		scores = new HashMap<>();
		scores.put(0, "Love-All");
		scores.put(1, "Fifteen-All");
		scores.put(2, "Thirty-All");
	}

	public String getScore(int player1Score, int player2Score) {
		return scores.getOrDefault(player1Score, "Deuce");
	}
}

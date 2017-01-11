package com.clean.code.game.score;

import java.util.HashMap;
import java.util.Map;

public class NormalScoreFinder implements ScoreFinder {
	
private static final String HYPHEN_SEPARATOR = "-";
private Map<Integer, String> scores;
	
	public NormalScoreFinder(){
		populateScores();
	}

	private void populateScores() {
		scores = new HashMap<>();
		scores.put(0, "Love");
		scores.put(1, "Fifteen");
		scores.put(2, "Thirty");
		scores.put(3, "Forty");
	}

	public String getScore(int player1Score, int player2Score) {
		return new StringBuilder()
				.append(scores.get(player1Score))
				.append(HYPHEN_SEPARATOR)
				.append(scores.get(player2Score))
				.toString();
	}

}

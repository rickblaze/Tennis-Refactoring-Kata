package com.clean.code.game.score;

import static java.lang.Math.abs;

public class AdvantageScoreFinder implements ScoreFinder {
	
	public String getScore(int player1Score, int player2Score){
		int scoreDifference = player1Score - player2Score;		
		if(abs(scoreDifference) >= 2){
			return getWinner(scoreDifference);
		}else{
			return playerWithAdvantage(scoreDifference);
		}		
	}

	private String getWinner(int scoreDifference) {
		return isPlayer1Leading(scoreDifference) 
				? "Win for player1" 
				: "Win for player2";
	}

	private String playerWithAdvantage(int scoreDifference) {
		return isPlayer1Leading(scoreDifference) 
				? "Advantage player1" 
				: "Advantage player2";
	}
	
	private boolean isPlayer1Leading(int scoreDifference) {
		return scoreDifference > 0;
	}
}

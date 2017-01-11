package com.clean.code.game.point;

import java.util.HashMap;
import java.util.Map;

import com.clean.code.game.score.TiedScoreFinder;

public class GameScorer {
	
	private Map<String, Integer> playerPoints;
	private String player1;
	private String player2;
	
	private TiedScoreFinder tiedScoreFinder;
	
	public GameScorer(String player1, String player2){
		this.player1 = player1;
		this.player2 = player2;
		initializeScorerWithPlayers(this.player1, this.player2);
		tiedScoreFinder = new TiedScoreFinder();
	}

	private void initializeScorerWithPlayers(String player1, String player2) {
		playerPoints = new HashMap<>();
		playerPoints.put(player1, 0);
		playerPoints.put(player2, 0);
	}
	
	public void addPointTo(String player) {
		playerPoints.put(player, playerPoints.getOrDefault(player, 0) + 1);
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        
        int player1Score = playerPoints.get(player1);
        int player2Score = playerPoints.get(player2);
        
        // Created method to check for Tied Score
        if (areScoresTied(player1Score, player2Score))
        {
        	// Code Smell - Switch Case statements.
        	return tiedScoreFinder.getScore(player1Score, player2Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int minusResult = player1Score-player2Score;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
                else { score+="-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

	private boolean areScoresTied(int player1Score, int player2Score) {
		return player1Score == player2Score;
	}
}

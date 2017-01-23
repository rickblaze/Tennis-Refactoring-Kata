package com.clean.code.game.point;

import static com.clean.code.game.score.ScoreEnum.Forty;
import static com.clean.code.game.score.ScoreEnum.values;
import static java.lang.Math.abs;
import static java.util.Arrays.asList;

import java.util.Optional;

import com.clean.code.game.score.PlayerScore;
import com.clean.code.game.score.ScoreEnum;

public class GameScorer {
	
	private static final String HYPHEN_DELIMITER = "-";
	private PlayerScore firstPlayerScore;
	private PlayerScore secondPlayerScore;
	
	public GameScorer(String firstPlayer, String secondPlayer){
		firstPlayerScore = new PlayerScore(firstPlayer);
		secondPlayerScore = new PlayerScore(secondPlayer);
	}
	
	public void addPointFor(String player) {
		if(player.equalsIgnoreCase(firstPlayerScore.getPlayer())){
			firstPlayerScore.addPoint();
		}else{
			secondPlayerScore.addPoint();
		}
    }

    public String getScore() {

    // Third Step - Code Smell - Anti pattern - Replaced with method.  
        // Created method to check for Tied Score
       if (areScoresTied())
        {
        	// First Step: Code Smell - Switch Case statements.
        	// Second Step - Retrieving ScoreFinder from Factory    	    
        	return getScoreForTiedScenario();
        }
        // Created method to check for Advantage or Win scenario.
        else if (isScoreAnAdvantage())
        {
        	//Code - Smell - Multiple if-else statements
        	// Second Step - Retrieving ScoreFinder from Factory
       	return getScoreForAdvantage();
        }
        else
        {
        	//Code - Smell - Multiple if-else & switch statements
        	//Second Step - Retrieving ScoreFinder from Factory
        	return getNormalScore();
        }
    }

	private boolean areScoresTied() {
		return firstPlayerScore.equals(secondPlayerScore);
	}
	
	protected String getScoreForTiedScenario() {
		Optional<ScoreEnum> scoreEnumForPoint = asList(values()).stream()
		   .filter(scoreEnum -> scoreEnum.getScore() == firstPlayerScore.getScore())
		   .findAny();
		return scoreEnumForPoint.isPresent() 
			   ? scoreEnumForPoint.get().getTiedScore() 
			   : getScoreForDeuce();
	}

	private String getScoreForDeuce() {
		return Forty.getTiedScore();
	}
	
	
	private boolean isScoreAnAdvantage() {
		return hasPlayerWonFourPoints(firstPlayerScore.getScore()) 
				|| hasPlayerWonFourPoints(secondPlayerScore.getScore());
	}
	
	private boolean hasPlayerWonFourPoints(int playerScore) {
		return playerScore >= 4;
	}
	
	protected String getScoreForAdvantage() {
    	int scoreDifference = firstPlayerScore.getScore() 
    						  - secondPlayerScore.getScore();
    	if(abs(scoreDifference) >= 2){
			return getWinner(scoreDifference);
		}else{
			return playerWithAdvantage(scoreDifference);
		}		
	}
	
	private boolean isPlayer1Leading(int scoreDifference) {
		return scoreDifference > 0;
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
	
	
	protected String getNormalScore() {
		return new StringBuilder()
					.append(getTextFor(firstPlayerScore.getScore()))
					.append(HYPHEN_DELIMITER)
					.append(getTextFor(secondPlayerScore.getScore()))
					.toString();
	}
	
	private String getTextFor(int playerScore){
		return asList(values())
				.stream()
				.filter(scoreEnum -> scoreEnum.getScore() == playerScore)
				.findAny()
				.get()
				.name();
	}
}

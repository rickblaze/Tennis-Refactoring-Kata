package com.clean.code.game.score;

import static java.util.Arrays.asList;

import java.util.Optional;
public enum ScoreEnum {
	
	Love(0, "Love-All"),
	Fifteen(1, "Fifteen-All"),
	Thirty(2, "Thirty-All"),
	Forty(3, "Deuce");

	private int score;
	private String scoreText;
	
	private ScoreEnum(int score, String scoreText){
		this.score = score;
		this.scoreText = scoreText;
	}
	
	public static String getTextForTie(int point){
		ScoreEnum[] scoreEnumValues = values(); 
		Optional<ScoreEnum> scoreEnumForPoint = asList(scoreEnumValues).stream()
							   .filter(scoreEnum -> scoreEnum.score == point)
							   .findAny();
		return scoreEnumForPoint.isPresent() ? scoreEnumForPoint.get().scoreText 
											 : Forty.scoreText;
	}
	
	public static String getTextFor(int point){
		ScoreEnum[] scoreEnumValues = values(); 
		return asList(scoreEnumValues).stream()
							   .filter(scoreEnum -> scoreEnum.score == point)
							   .findAny()
							   .get().name();
	}

	public int getScore() {
		return score;
	}

	public String getTiedScore() {
		return scoreText;
	}
}

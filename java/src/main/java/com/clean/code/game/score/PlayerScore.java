package com.clean.code.game.score;

public class PlayerScore {
	
	private final int ZERO_POINT = 0;
	
	private String name;
	private int score;
	
	public PlayerScore(String name){
		this.name = name;
		this.score = ZERO_POINT;
	}
	
	public void addPoint(){
		score = score + 1;
	}
	
	public int getScore(){		
		return score;
	}
	
	public String getPlayer(){
		return name;
	}
	
	@Override
	public boolean equals(Object objectToCompare) {
		if(objectToCompare instanceof PlayerScore){
			PlayerScore playerScore = (PlayerScore) objectToCompare;
			return this.score == playerScore.score;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public int hashCode(){
		return score * 22/7 ;
	}
}

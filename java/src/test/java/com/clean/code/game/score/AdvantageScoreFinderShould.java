package com.clean.code.game.score;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdvantageScoreFinderShould {
	
	@Test
	public void return_advantage_player1_when_player1_has_1_point_more_than_player2(){
		assertEquals("Advantage player1", new AdvantageScoreFinder().getScore(5, 4));
	}
	
	@Test
	public void return_advantage_player2_when_player2_has_1_point_more_than_player1(){
		assertEquals("Advantage player2", new AdvantageScoreFinder().getScore(4, 5));
	}
	
	@Test
	public void return_player1_wins_when_player1_has_2_points_more_than_player2(){
		assertEquals("Win for player1", new AdvantageScoreFinder().getScore(10, 8));
	}
	
	@Test
	public void return_player2_wins_when_player2_has_3_points_more_than_player1(){
		assertEquals("Win for player2", new AdvantageScoreFinder().getScore(4, 7));
	}
}

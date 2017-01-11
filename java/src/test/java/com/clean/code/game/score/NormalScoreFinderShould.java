package com.clean.code.game.score;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NormalScoreFinderShould {
	
	private NormalScoreFinder normalScoreFinder;
	
	@Before
	public void setUp(){
		normalScoreFinder = new NormalScoreFinder();
	}

	@Test
	public void return_love_fifteen_when_player1_has_0_and_player2_has_1_point(){
		assertEquals("Love-Fifteen", normalScoreFinder.getScore(0, 1));
	}
	
	@Test
	public void return_thirty_forty_when_player1_has_2_and_player2_has_3_points(){
		assertEquals("Thirty-Forty", normalScoreFinder.getScore(2, 3));
	}
}

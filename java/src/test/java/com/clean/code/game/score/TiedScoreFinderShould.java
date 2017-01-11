package com.clean.code.game.score;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TiedScoreFinderShould {
	
	private TiedScoreFinder tiedScoreFinder;
	
	@Before
	public void setUp() {
		tiedScoreFinder = new TiedScoreFinder();
	}
	
	@Test
	public void return_love_all_when_both_players_have_zero_points() {	
		assertEquals("Love-All", tiedScoreFinder.getScore(0, 0));
	}	
	
	@Test
	public void return_love_all_when_both_players_have_1_points() {	
		assertEquals("Fifteen-All", tiedScoreFinder.getScore(1, 1));
	}	

	@Test
	public void return_deuce_when_both_players_have_more_than_3_points() {	
		assertEquals("Deuce", tiedScoreFinder.getScore(4, 4));
	}
}

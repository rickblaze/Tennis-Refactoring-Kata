package com.clean.code.game.score;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TiedScoreFinderShould {
	
	@Test
	public void return_love_all_when_both_players_have_zero_points() {	
		TiedScoreFinder tiedScoreFinder = new TiedScoreFinder();
		assertEquals("Love-All", tiedScoreFinder.getScore(0, 0));
	}
	
	@Test
	public void return_love_all_when_both_players_have_1_points() {	
		TiedScoreFinder tiedScoreFinder = new TiedScoreFinder();
		assertEquals("Fifteen-All", tiedScoreFinder.getScore(1, 1));
	}
	

	@Test
	public void return_deuce_when_both_players_have_more_than_3_points() {	
		TiedScoreFinder tiedScoreFinder = new TiedScoreFinder();
		assertEquals("Deuce", tiedScoreFinder.getScore(4, 4));
	}
}

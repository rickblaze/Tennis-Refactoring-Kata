package com.clean.code.game.point;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameScorerShould {

	private static final String PLAYER_B = "B";
	private static final String PLAYER_A = "A";

	@Test
	public void return_love_all_when_player_points_are_zero(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.build();;
		assertEquals("Love-All", gameScorer.getScore());
	}
	
	@Test
	public void return_love_fifteen_when_playerA_has_0_and_playerB_has_1_point(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.addPoints(PLAYER_B)
								.build();
		assertEquals("Love-Fifteen", gameScorer.getScore());
	}
	
	@Test
	public void return_fifteen_love_when_playerA_has_0_and_playerB_has_1_point(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.addPoints(PLAYER_A)
								.build();
		assertEquals("Fifteen-Love", gameScorer.getScore());
	}
	
	@Test
	public void return_advantage_player1_when_playerA_has_5_and_playerB_has_4_point(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.addPoints(PLAYER_A, PLAYER_A, PLAYER_A, PLAYER_A, PLAYER_A)
								.addPoints(PLAYER_B, PLAYER_B, PLAYER_B, PLAYER_B)
								.build();
		assertEquals("Advantage player1", gameScorer.getScore());
	}
	
	@Test
	public void return_advantage_player2_when_playerB_has_5_and_playerA_has_4_point(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.addPoints(PLAYER_B, PLAYER_B, PLAYER_B, PLAYER_B, PLAYER_B)
								.addPoints(PLAYER_A, PLAYER_A, PLAYER_A, PLAYER_A)
								.build();
		assertEquals("Advantage player2", gameScorer.getScore());
	}
	
	@Test
	public void return_player2_wins_when_playerB_has_4_and_playerA_has_0_point(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.addPoints(PLAYER_B, PLAYER_B, PLAYER_B, PLAYER_B)
								.build();
		assertEquals("Win for player2", gameScorer.getScore());
	}
	
	@Test
	public void return_deuce_when_playerB_has_4_and_playerA_has_4_point(){
		GameScorer gameScorer = GameScorerBuilder
								.createGameScorer()
								.addPlayers(PLAYER_A, PLAYER_B)
								.addPoints(PLAYER_B, PLAYER_A, PLAYER_B, PLAYER_A)
								.addPoints(PLAYER_A, PLAYER_B, PLAYER_A, PLAYER_B)
								.build();
		assertEquals("Deuce", gameScorer.getScore());
	}
	
	public static class GameScorerBuilder {
		
		private GameScorer gameScorer;
		
		public static GameScorerBuilder createGameScorer(){
			return new GameScorerBuilder();
		}
		
		public GameScorerBuilder addPlayers(String player1, String player2){
			gameScorer = new GameScorer(player1, player2);
			return this;
		}
		
		public GameScorerBuilder addPoints(String... players){
			for(String player : players){
				gameScorer.addPointTo(player);
			}
			return this;
		}
		
		public GameScorer build(){
			return gameScorer;
		}
	}
}

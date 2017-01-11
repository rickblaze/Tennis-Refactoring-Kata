package com.clean.code.game.score.factory;

import static com.clean.code.game.score.ScoreFinderEnum.ADVANTAGE;
import static com.clean.code.game.score.ScoreFinderEnum.NORMAL;
import static com.clean.code.game.score.ScoreFinderEnum.TIE;

import java.util.HashMap;
import java.util.Map;

import com.clean.code.game.score.AdvantageScoreFinder;
import com.clean.code.game.score.NormalScoreFinder;
import com.clean.code.game.score.ScoreFinder;
import com.clean.code.game.score.ScoreFinderEnum;
import com.clean.code.game.score.TiedScoreFinder;

public class ScoreFinderFactory {
	
	private Map<ScoreFinderEnum, ScoreFinder> scoreLookup;
	
	private static final ScoreFinderFactory instance = new ScoreFinderFactory();

	private ScoreFinderFactory(){
		initializeScoreLookup();
	}

	private void initializeScoreLookup() {
		scoreLookup = new HashMap<>();
		scoreLookup.put(TIE, new TiedScoreFinder());
		scoreLookup.put(ADVANTAGE, new AdvantageScoreFinder());
		scoreLookup.put(NORMAL, new NormalScoreFinder());
	}
	
	public static ScoreFinderFactory getInstance(){
		return instance;
	}
	
	public ScoreFinder getScore(ScoreFinderEnum scoringScenario){
		return scoreLookup.get(scoringScenario);
	}
}

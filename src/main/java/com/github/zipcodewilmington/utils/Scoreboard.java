package com.github.zipcodewilmington.utils;

public class Scoreboard {
    private GameScoreBoard blackjackScores = new GameScoreBoard("Blackjack");
    private GameScoreBoard beetleScores = new GameScoreBoard("Beetle");
    private GameScoreBoard numberGuessScores = new GameScoreBoard("Number Guess");
    private GameScoreBoard kenoScores = new GameScoreBoard("Keno");
    private GameScoreBoard plinkoScores = new GameScoreBoard("Plinko");

    public GameScoreBoard getBlackJackScores() {
        return blackjackScores;
    }

    public GameScoreBoard getBeetleScores() {
        return beetleScores;
    }

    public GameScoreBoard getNumberGuessScores() {
        return numberGuessScores;
    }

    public GameScoreBoard getKenoScores() {
        return kenoScores;
    }

    public GameScoreBoard getPlinkoScores() {
        return plinkoScores;
    }
}

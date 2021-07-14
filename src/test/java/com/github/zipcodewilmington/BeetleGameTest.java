package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import org.junit.Test;

public class BeetleGameTest {
    @Test
    public void testGameOver(){
        Player player1 = new Player("Jeff", 10);
        Player player2 = new Player("Aria", 10);
        BeetleGame game = new BeetleGame(player1, player2);
        game.add(player1);
        Boolean isGameOver = game.getIsRunning();
    }
}

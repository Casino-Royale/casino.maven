package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackGameTest {


    public void startGameTest () {
        BlackJack bj = new BlackJack();
        BlackJackGame blackJackGame = new BlackJackGame();


        Integer choice = 2;
    }

    @Test
    public void calculateWinningsTest () {
        BlackJackGame blackJack = new BlackJackGame();
        Integer expected = 12;

        Integer multiplier = 3;
        Integer betAmount = 4;
        Integer actual = blackJack.calculateWinnings(multiplier, betAmount);

        Assert.assertEquals(expected,actual);
    }

//    @Test
//    public void subtractFromBalance () {
//        BlackJackGame blackJack = new BlackJackGame();
//        Player player = new Player("Steve", 100);
//        Integer expected = 60;
//
//        Integer bet = 40;
//        blackJack.subtractBetFromBalance(bet);
//        Integer actual = player.getBalance();
//
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void subtractTest() {
        BlackJackGame bj = new BlackJackGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        bj.add(player);
        player.getArcadeAccount().alterAccountBalance(200 * -1);
        Integer expected = 300;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void splitPlayerHitsBlackJackTest () {
        BlackJackGame bjg = new BlackJackGame();
        BlackJack bj = new BlackJack();

    }

    @Test
    public void runTest () {
        BlackJackGame bj = new BlackJackGame();
        bj.setRunning(true);
        bj.run();

        Integer actual = bj.getUserBet();
        Integer expected = null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printWelcomeTest () {
        BlackJackGame bj = new BlackJackGame();
        bj.setRunning(true);
        bj.run();

        System.out.println("============================================================" + "\n" +
                "=====                                                  =====" + "\n" +
                "=====                     WELCOME                      =====" + "\n" +
                "=====                       TO                         =====" + "\n" +
                "=====                    B L A C K                     =====" + "\n" +
                "=====                     J A C K                      =====" + "\n" +
                "=====                                                  =====" + "\n" +
                "============================================================");
    }

    @Test
    public void getRunningTest () {
        BlackJackGame bj = new BlackJackGame();
        boolean expected = false;
        boolean actual = bj.getRunning();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removePlayerTest () {
        BlackJackGame bj = new BlackJackGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        bj.add(player);
        bj.remove(player);
        Boolean expected = false;
        Boolean actual = bj.getPlayer() != null;

        Assert.assertEquals(expected, actual);
    }
}

package com.github.zipcodewilmington.casino.games.plinko;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class REPlinko implements GameInterface {
    private PlayerInterface playerInt;
    private Boolean isRunning = false;
    List<Integer> winningValues;
    Integer userBet;
    Integer actualWinnings = 0;
    IOConsole input = new IOConsole();

    public void run() {
        printWelcome();
        while(!isRunning) {
            playerInt.getArcadeAccount().alterAccountBalance(actualWinnings);
            input.println("Your current account balance is " + playerInt.getArcadeAccount().getAccountBalance());
            Integer userInput = input.getIntegerInput("Wanna play?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n");
            switch (userInput) {
                case 1:
                    userBet = input.getIntegerInput("How much would you like to bet?");
                    userBetCondition();
                    playerInt.getArcadeAccount().alterAccountBalance(userBet * (-1));
                    startGame();
                    break;
                case 2:
                    isRunning = true;
            }
        }
    }

    void startGame() {
        createBoard();
        shuffleBoard();
        calculateWinnings(checkWin(), userBet);
    }

    Integer checkWin () {
        return winningValues.get(0);
    }

    void createBoard () {
        winningValues = new ArrayList<>();
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(0);
        winningValues.add(1);
        winningValues.add(1);
        winningValues.add(2);
        winningValues.add(3);
        winningValues.add(5);
    }

    void shuffleBoard () {
        Collections.shuffle(winningValues);
    }

    private void userBetCondition() {
        while (userBet > playerInt.getArcadeAccount().getAccountBalance()) {
            input.println("Oh no! You're trying to place a bet with more money than you have...");
            userBet = (input.getIntegerInput("\u001B[32mHow much would you like to bet?" + "\n"));
        }
    }

    private void printWelcome() {
        input.println("Welcome!");
    }

    public void add(PlayerInterface player) {
        this.playerInt = player;
    }

    public void remove(PlayerInterface player) {
        this.playerInt = null;
    }

    public Integer calculateWinnings(Integer multiplier, Integer userBet) {
        actualWinnings = multiplier * userBet;
        return actualWinnings;
    }

    public void subtractBetFromBalance(Integer betAmount) {

    }

    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }
}
package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashSet;

public class KenoGameRE implements GameInterface {
    private IOConsole console = new IOConsole(AnsiColor.BLUE);
    private PlayerInterface currentPlayer;
    private Integer userBet;
    private Integer currentUserChoice;
    private HashSet<Integer> tenChoices;
    private HashSet<Integer> twentyOneRandom;
    private HashSet<Integer> matches;

    //---------------------------------------------------------------------

    public KenoGameRE(){
    }

    @Override
    public void run() {
        //Display welcome
        console = new IOConsole(AnsiColor.YELLOW);
        console.println(printWelcome());

        //Display instruction
        console = new IOConsole(AnsiColor.BLUE);
        console.println(displayInstruction());

        //Print user current balance
        console = new IOConsole(AnsiColor.GREEN);
        console.println("Your Current Balance: " + getPlayerBalance());

        //Ask user for bet amount
        console = new IOConsole(AnsiColor.PURPLE);
        userBet = console.getIntegerInput("How much do you want to bet?");

        //Subtract bet amount from user's balance
        subtractBetFromBalance(userBet);

        //Ask user to pick 10 numbers between 1-80 and add to array
        getUserChoices();

        //Display user's picks
        console = new IOConsole(AnsiColor.PURPLE);
        console.println("Your chose: " + tenChoices);

        //Generate 21 random numbers and add to array
        setTwentyOneRandom(twentyOneRandomNum());

        //Display the 21 random numbers
        console.println("Game chose:" + twentyOneRandom);

        //Find matches b/w user choice and random 21
        setMatches(findMatches());

        //Print matched array
        console = new IOConsole(AnsiColor.YELLOW);
        console.println("Matches: " + matches);

        //Calculate winnings


        //Print winnings
        //Add winnings to player's account balance
        //Print user current balance
        //Ask user to play again

    }


    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.currentPlayer = null;
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return null;
    }

    @Override
    public void subtractBetFromBalance(Integer betAmount) {
        currentPlayer.getArcadeAccount().alterAccountBalance(betAmount * (-1));
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }

    //-------------------------- Getters and Setters -----------------------

    public PlayerInterface getCurrentPlayer() {
        return currentPlayer;
    }

    public void setUserBet(Integer userBet) {
        this.userBet = userBet;
    }

    public void setTwentyOneRandom(HashSet<Integer> twentyOneRandom) {
        this.twentyOneRandom = twentyOneRandom;
    }

    public HashSet<Integer> getTwentyOneRandom() {
        return twentyOneRandom;
    }

    public HashSet<Integer> getMatches() {
        return matches;
    }

    public void setMatches(HashSet<Integer> matches) {
        this.matches = matches;
    }

    public HashSet<Integer> getTenChoices() {
        return tenChoices;
    }

    public void setTenChoices(HashSet<Integer> tenChoices) {
        this.tenChoices = tenChoices;
    }

    //-------------------------- My own methods ----------------------------

    public String printWelcome() {
        return "***********************************\n" +
                "***                             ***\n" +
                "******    WELCOME TO KENO    ******\n" +
                "***                             ***\n" +
                "***********************************";

    }

    public String displayInstruction(){
        return "Pick 10 numbers between 1 and 80!\n" +
                "The more numbers matched the more you win!";
    }

    public Integer getPlayerBalance(){
        return currentPlayer.getArcadeAccount().getAccountBalance();
    }

    public void getUserChoices(){
        console = new IOConsole(AnsiColor.CYAN);
        HashSet choices = new HashSet();
        Integer count = 0;
        while(choices.size() < 10){
            currentUserChoice = console.getIntegerInput("Choose your #" + (count+1) +" number");
            if(choices.contains(currentUserChoice)){
                console.println("You already chose that number! Try again!");
            } else {
                choiceCondition();
                choices.add(currentUserChoice);
                count++;
            }
        }
        this.tenChoices = choices;
    }

    public void choiceCondition(){
        while(currentUserChoice < 1 || currentUserChoice > 80){
            currentUserChoice = console.getIntegerInput("Please choose number between 1 - 80");
        }
    }

    public HashSet twentyOneRandomNum(){
        HashSet<Integer> twentyOne = new HashSet();
        while(twentyOne.size() < 21){
            Integer input = (int) ((Math.random() * (81 - 1)) + 1);
            twentyOne.add(input);
        }
        return twentyOne;
    }

    public HashSet findMatches(){
        HashSet<Integer> matched = new HashSet<>();
        for(Integer element: tenChoices){
            if(twentyOneRandom.contains(element)){
                matched.add((element));
            }
        }
        return matched;
    }

}

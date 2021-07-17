package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.plinko.REPlinko;

public class DemoMain {
    public static void main(String[] args) {
        CasinoAccount account = new CasinoAccount("Paul", "Rudd");
        account.alterAccountBalance(100);
        Player player = new Player(null, account);

        REPlinko game = new REPlinko();
        game.add(player);
        game.run();
    }
}

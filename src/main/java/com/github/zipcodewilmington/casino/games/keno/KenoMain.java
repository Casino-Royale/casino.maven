package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;

public class KenoMain {

    public static void main(String[] args) {
        KenoGameRE keno = new KenoGameRE();
        CasinoAccount account = new CasinoAccount("name", "password");
        account.alterAccountBalance(100);
        Player player1 = new Player(null, account);
        keno.add(player1);

        keno.getUserChoices();
    }
}

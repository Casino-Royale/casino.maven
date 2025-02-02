package com.github.zipcodewilmington.casino.games.plinko;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class PlinkoPlayer implements PlayerInterface {
    private PlayerInterface player;

    public PlinkoPlayer(PlayerInterface player){this.player=player;}
    @Override
    public CasinoAccount getArcadeAccount() {
        return player.getArcadeAccount();
    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {
        this.player.setArcadeAccount(casinoAccount);
    }
}

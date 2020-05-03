package com.leetcode.ooDesign.Roulette;

import com.leetcode.ooDesign.Roulette.bets.Bet;
import com.leetcode.ooDesign.Roulette.bets.ColorBet;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final EventBus eventBus;
    private final Wheel wheel;
    private final List<Bet> bets;

    Game() {
        eventBus = new EventBus();
        wheel = new Wheel(eventBus);
        bets = new ArrayList<>();
    }

    void betColor(User user, boolean isRed, double amount) {
        Bet bet = new ColorBet(user, isRed, amount);
        eventBus.register(bet);
        bets.add(bet);
    }

    void play() {
        wheel.rotate();
        for (Bet bet : bets) {
            eventBus.unregister(bet);
        }
    }
}

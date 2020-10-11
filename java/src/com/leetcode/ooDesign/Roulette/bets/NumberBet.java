package com.leetcode.ooDesign.Roulette.bets;

import com.google.common.eventbus.Subscribe;
import com.leetcode.ooDesign.Roulette.User;
import com.leetcode.ooDesign.Roulette.events.NumberEvent;

public class NumberBet implements Bet {
    private final int number;
    private final User user;
    private final double amount;

    public NumberBet(User user, int number, double amount) {
        this.number = number;
        this.user = user;
        this.amount = amount;
    }

    @Subscribe
    public void onRotate(NumberEvent e) {
        if (number == e.getNumber()) {
            user.win(amount);
        } else {
            user.lose(amount);
        }
    }
}

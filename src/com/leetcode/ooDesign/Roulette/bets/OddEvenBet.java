package com.leetcode.ooDesign.Roulette.bets;

import com.leetcode.ooDesign.Roulette.User;
import com.leetcode.ooDesign.Roulette.events.OddEvenEvent;

public class OddEvenBet implements Bet {
    private final boolean isOdd;
    private final User user;
    private final double amount;

    public OddEvenBet(User user, boolean isOdd, double amount) {
        this.isOdd = isOdd;
        this.user = user;
        this.amount = amount;
    }

    @Subscribe
    public void onRotate(OddEvenEvent e) {
        if (isOdd == e.isOdd()) {
            user.win(amount);
        } else {
            user.lose(amount);
        }
    }
}

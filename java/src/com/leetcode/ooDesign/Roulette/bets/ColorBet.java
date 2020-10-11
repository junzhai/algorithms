package com.leetcode.ooDesign.Roulette.bets;

import com.google.common.eventbus.Subscribe;
import com.leetcode.ooDesign.Roulette.User;
import com.leetcode.ooDesign.Roulette.events.ColorEvent;

public class ColorBet implements Bet {
    private final boolean isRed;
    private final User user;
    private final double amount;

    public ColorBet(User user, boolean isRed, double amount) {
        this.isRed = isRed;
        this.user = user;
        this.amount = amount;
    }

    @Subscribe
    public void onRotate(ColorEvent e) {
        if (isRed == e.isRed()) {
            user.win(amount);
        } else {
            user.lose(amount);
        }
    }
}

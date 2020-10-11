package com.leetcode.ooDesign.Roulette.events;

public class OddEvenEvent {
    private boolean isOdd;

    public OddEvenEvent(boolean isOdd) {
        this.isOdd = isOdd;
    }

    public boolean isOdd() {
        return isOdd;
    }
}

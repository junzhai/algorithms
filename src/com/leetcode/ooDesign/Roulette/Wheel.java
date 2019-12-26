package com.leetcode.ooDesign.Roulette;

import com.google.common.eventbus.EventBus;
import com.leetcode.ooDesign.Roulette.events.ColorEvent;
import com.leetcode.ooDesign.Roulette.events.NumberEvent;
import com.leetcode.ooDesign.Roulette.events.OddEvenEvent;

import java.util.Random;

public class Wheel {
    private final EventBus eventBus;
    private final Random random;

    Wheel(EventBus eventBus) {
        random = new Random();
        this.eventBus = eventBus;
    }

    void rotate() {
        eventBus.post(new ColorEvent(false));
        eventBus.post(new OddEvenEvent(false));
        eventBus.post(new NumberEvent(3));
    }
}

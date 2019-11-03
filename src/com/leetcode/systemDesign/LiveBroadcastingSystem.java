package com.leetcode.systemDesign;

public class LiveBroadcastingSystem {
    String[] requirement = new String[]{
            "Design a live broadcasting system like Twitch with the following functionalities:",
            "1) Live video stream",
            "2) Display total online users in the room (prompted me to talk about multiple different implementation &" +
                    " tradeoff)",
            "3) Send gifts to room owner with a message broadcasted to all users in the room ( assume multiple " +
                    "gifts & msg can appear on the same screen at once, how to make sure they are in order)" +
                    "Room chat function",
            "4) Playback video function should display gifts, screen messages, & chat to be shown again. (after " +
                    "broadcast is offline)",
            "5) Also asked about tradeoff on ajax polling, long polling, & web socket for each of the functionality " +
                    "and ask me which to use for each."
    };

    String discussion =
            "https://leetcode.com/discuss/interview-question/system-design/366807/FAANG-or-Onsite-or-Design-Twitch";
}

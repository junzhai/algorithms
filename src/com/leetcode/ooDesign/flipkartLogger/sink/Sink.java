package com.leetcode.ooDesign.flipkartLogger.sink;

public interface Sink {
    public void log(String namespace, String message);
}

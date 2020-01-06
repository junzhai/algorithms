package com.leetcode.ooDesign.flipkartLogger.sink;

public class FileSink implements Sink {
    public static class Builder {
        private String location;

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Sink build() {
            return new FileSink();
        }
    }

    private FileSink() {

    }

    public void log(String namespace, String message) {
    }
}

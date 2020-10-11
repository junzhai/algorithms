package com.leetcode.ooDesign.flipkartLogger;

import com.leetcode.ooDesign.flipkartLogger.sink.FileSink.Builder;
import com.leetcode.ooDesign.flipkartLogger.sink.Sink;

import java.util.Map;

public class Logger {

    private static Logger logger = new Logger();

    public static Logger getInstance() {
        return logger;
    }

    private Level logLevel;
    private Sink dummySink;
    private Map<Level, Sink> log;

    private Logger() {
        init();
    }

    private void init() {
        Builder builder = new Builder();
        builder.location("").build();
    }

    public void log(Level level, String namespace, String message) {
        if (logLevel.value() > level.value()) {
            dummySink.log(namespace, message);
        } else {
            Sink sink = log.get(level);
            synchronized (sink) {
                sink.log(namespace, message);
            }
        }
    }

    public void debug(String namespace, String message) {
        log(Level.DEBUG, namespace, message);
    }

    public void info(String namespace, String message) {
        log(Level.INFO, namespace, message);
    }

    public void warn(String namespace, String message) {
        log(Level.WARN, namespace, message);
    }

    public void error(String namespace, String message) {
        log(Level.ERROR, namespace, message);
    }

    public void fatal(String namespace, String message) {
        log(Level.FATAL, namespace, message);
    }
}

package com.facebook.BlockIO;

public interface UnderliningIO {
    // Forward reading 4K
    int read(int[] buf);
}

package com.real.facebook_2020;

import java.util.Arrays;

public class BlockIO {
    private final UnderliningIO underliningIO;
    private int[] remaining;

    public BlockIO(UnderliningIO underliningIO) {
        this.underliningIO = underliningIO;
        remaining = new int[0];
    }

    public int read(int[] buf, int len) {
        int left = remaining.length, blocks = (len - left) / 4096, ret = 0;
        System.arraycopy(remaining, 0, buf, 0, left);
        ret += left;

        int[] tmp = new int[4096];
        for (int i = 0; i < blocks; i++) {
            int c = underliningIO.read(tmp);
            System.arraycopy(tmp, 0, buf, ret, c);
            ret += c;
            if (c < 4096) {
                remaining = new int[0];
                return ret;
            }
        }

        if (len == ret) {
            remaining = new int[0];
            return ret;
        }

        left = len - ret;
        int c = underliningIO.read(tmp);
        if (c <= left) {
            System.arraycopy(tmp, 0, buf, ret, c);
            ret += c;
            remaining = new int[0];
        } else {
            System.arraycopy(tmp, 0, buf, ret, left);
            ret += left;
            remaining = Arrays.copyOfRange(tmp, left, c - left);
        }
        return ret;
    }
}

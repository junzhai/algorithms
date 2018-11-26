package com.leetcode;

import org.junit.Assert;

import java.util.Arrays;

public class Sandbox {
    public int numPermsDISequence(String S) {
        boolean[] selected = new boolean[S.length() + 1];
        int ret = 0;
        for (int i = 0; i < selected.length; i++) {
            selected[i] = true;
            ret += helper(S, 1, i, selected);
            selected[i] = false;
        }
        return ret;
    }

    private int helper(String S, int index, int v, boolean[] selected) {
        if (index >= selected.length) {
            return 1;
        }

        int ret = 0;
        char ch = S.charAt(index - 1);
        if (ch == 'D') {
            for (int i = 0; i < v; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    ret += helper(S, index + 1, i, selected);
                    selected[i] = false;
                }
            }
        } else {
            for (int i = v + 1; i < selected.length; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    ret += helper(S, index + 1, i, selected);
                    selected[i] = false;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Sandbox s = new Sandbox();
        int ret;

        ret = s.numPermsDISequence("DIID");
        Assert.assertEquals(11, ret);

        ret = s.numPermsDISequence("DIIID");
        Assert.assertEquals(19, ret);

        ret = s.numPermsDISequence("IDDDIIDIIIIIIIIDI");
        Assert.assertEquals(5, ret);

        ret = s.numPermsDISequence("IDDDIIDIIIIIIIIDIDID");
        Assert.assertEquals(5, ret);

        ret = s.numPermsDISequence("DID");
        Assert.assertEquals(5, ret);

        ret = s.numPermsDISequence("DDIID");
        Assert.assertEquals(5, ret);
    }
}
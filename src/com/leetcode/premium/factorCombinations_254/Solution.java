package com.leetcode.premium.factorCombinations_254;

import com.Pattern;

import java.util.ArrayList;
import java.util.List;

@Pattern(desc = "顺序检测除数因子")
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        getFactorsInner(n, 2, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void getFactorsInner(int n, int factor, List<Integer> fs, List<List<Integer>> c) {
        while (factor <= n) {
            if (n % factor == 0) {
                int nn = n / factor;
                if (nn >= factor) {
                    fs.add(factor);
                    getFactorsInner(nn, factor, fs, c);
                    fs.remove(fs.size() - 1);
                } else {
                    if (fs.size() > 0) {
                        fs.add(n);
                        c.add(new ArrayList<>(fs));
                        fs.remove(fs.size() - 1);
                    }
                    break;
                }
            }
            factor += 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.getFactors(10);
        ret = s.getFactors(6);
        ret = s.getFactors(36);
        ret = s.getFactors(8);
    }
}
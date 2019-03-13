package com.leetcode.algorithms.pyramidTransitionMatrix_756;

import com.pattern.DP;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

@DP
abstract public class Solution {
    abstract public boolean pyramidTransition(String bottom, List<String> allowed);

    public static void main(String[] args) {
        Solution[] solutions = new Solution[]{
//                new BackTracking(),
//                new BackTrackingUsingBit(),
//                new DPUsingString(),
//                new DPUsingIndex(),
//                new DPUsingCollection(),
                new DP2()
        };

        for (Solution s : solutions) {
            boolean ret;

            ret = s.pyramidTransition("BDBBAA", Arrays.asList(
                    "ACB", "ACA", "AAA", "ACD", "BCD", "BAA", "BCB", "BCC", "BAD", "BAB", "BAC", "CAB", "CCD", "CAA",
                    "CCA", "CCC", "CAD", "DAD", "DAA", "DAC", "DCD", "DCC", "DCA", "DDD", "BDD", "ABB", "ABC", "ABD",
                    "BDB", "BBD", "BBC", "BBA", "ADD", "ADC", "ADA", "DDC", "DDB", "DDA", "CDA", "CDD", "CBA", "CDB",
                    "CBD", "DBA", "DBC", "DBD", "BDA"
            ));
            Assert.assertEquals(true, ret);

            ret = s.pyramidTransition("EFEADGBF", Arrays.asList(
                    "BGF", "BGG", "AGF", "AGE", "CCE", "EGA", "CCF", "CCA", "EGD", "DCE", "DCA", "FGD", "FGF", "FGB",
                    "GAC", "DBC", "DBB", "DBG", "FFG", "FFF", "FFA", "FDA", "FDC", "FDB", "FDD", "FDG", "FDF", "BEB",
                    "AEA", "EGC", "GCB", "AED", "AEF", "EEF", "EEA", "DEE", "EEC", "EEB", "CEA", "EGG", "GEF", "GED",
                    "DGC", "GCA", "BDD", "CCG", "BDF", "GCG", "BDB", "AFE", "AFF", "AFA", "AFB", "DGA", "DDC", "EFA",
                    "EFB", "DDG", "EFE", "EFF", "EFG", "CBB", "CBC", "CBF", "DGD", "CBD", "ACB", "ACA", "ACE", "BCD",
                    "BCF", "BCA", "BCB", "BCC", "DDB", "DGB", "ECF", "ECE", "ECD", "DGF", "DGG", "ECA", "DGE", "CGE",
                    "FCE", "GGC", "FEF", "FEE", "FEB", "FEC", "BBE", "BBB", "BBA", "ADD", "ADE", "ADB", "ADC", "DFE",
                    "DFF", "DFC", "CBG", "CDD", "EDC", "CDF", "CDG", "CDA", "CDB", "CDC", "FBC", "GDA", "GDB", "AEB",
                    "GDD", "GDF", "AAA", "AAC", "AAB", "BAF", "BAD", "BAE", "BAB", "BAA", "CAF", "CAD", "DAD", "DAE",
                    "DAC", "EAD", "EAF", "GAE", "DEG", "FAF", "FAD", "FAE", "ABC", "ABE", "ECG", "EBE", "EBA", "EBC",
                    "CFF", "CFE", "CFA", "GFA", "GFG", "GFE"
            ));
            Assert.assertEquals(false, ret);

            ret = s.pyramidTransition("AABA", Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC"));
            Assert.assertEquals(false, ret);

            ret = s.pyramidTransition("CBF", Arrays.asList("CBD", "BFE", "DEA", "FFF"));
            Assert.assertEquals(true, ret);
        }
    }
}

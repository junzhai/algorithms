package com.real.sonatus_2021;

public class CompareVersions {
    public int compare(String v1, String v2) {
        String pre1 = "";
        int idx = v1.indexOf("-");
        if (idx >= 0) {
            pre1 = v1.substring(idx + 1);
            v1 = v1.substring(0, idx);
        }

        String pre2 = "";
        idx = v2.indexOf("-");
        if (idx >= 0) {
            pre2 = v2.substring(idx + 1);
            v2 = v2.substring(0, idx);
        }

        String[] arr1 = v1.split("\\."), arr2 = v2.split("\\.");
        idx = 0;
        while (idx < arr1.length && idx < arr2.length) {
            int vv1 = Integer.parseInt(arr1[idx]), vv2 = Integer.parseInt(arr2[idx]);
            if (vv1 < vv2) {
                return -1;
            }
            if (vv1 > vv2) {
                return 1;
            }
            idx += 1;
        }
        if (idx < arr1.length) {
            return 1;
        }

        if (idx < arr2.length) {
            return -1;
        }

        if (pre1.length() == 0 && pre2.length() == 0) {
            return 0;
        }

        if (pre1.length() == 0) {
            return 1;
        }
        if (pre2.length() == 0) {
            return -1;
        }
        return pre1.compareTo(pre2);
    }

    public static void main(String[] arg) {
        CompareVersions s = new CompareVersions();
        System.out.println(s.compare("1.2.3", "1.2.3")); // 0
        System.out.println(s.compare("1.2.3", "1.2.4")); // -1
        System.out.println(s.compare("1.2.3", "1.2.2")); // 1
        System.out.println(s.compare("2.3.4", "3.3.4")); // -1
        System.out.println(s.compare("1.2.3-alpha", "1.2.3-beta")); // -1
        System.out.println(s.compare("1.2.3", "1.2.3.4")); // -1
        System.out.println(s.compare("1.2.3-alpha", "1.2.3")); // -1    }
    }
}

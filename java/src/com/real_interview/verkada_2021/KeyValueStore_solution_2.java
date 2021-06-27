package com.real_interview.verkada_2021;

import java.util.*;

public class KeyValueStore_solution_2 {
    private int s_id = 0;
    private Map<String, String> cur;
    private Map<String, List<Integer>> versions;
    private Map<String, List<String>> values;

    public static void main(String[] args) {
        KeyValueStore_solution_2 kv = new KeyValueStore_solution_2();
        kv.set("k1", "v1");
        kv.snapshot();
        kv.snapshot();
        kv.snapshot();
        kv.set("k1", "v2");
        kv.snapshot();
        kv.set("k1", "v3");
        kv.snapshot();

        System.out.println("1 -> " + kv.getFromSnapshot("k1", 1));
        System.out.println("2 -> " + kv.getFromSnapshot("k1", 2));
        System.out.println("3 -> " + kv.getFromSnapshot("k1", 3));
        System.out.println("4 -> " + kv.getFromSnapshot("k1", 4));
        System.out.println("5 -> " + kv.getFromSnapshot("k1", 5));
        System.out.println("6 -> " + kv.getFromSnapshot("k1", 6));
        System.out.println(kv.get("k1"));

    }

    public KeyValueStore_solution_2() {
        cur = new HashMap<>();
        versions = new HashMap<>();
        values = new HashMap<>();
    }

    public String get(String key) {
        return cur.get(key);
    }

    public void set(String key, String value) {
        cur.put(key, value);
    }

    public int snapshot() {
        s_id += 1;
        for (String k : cur.keySet()) {
            String v = cur.get(k);
            if (!versions.containsKey(k)) {
                List<Integer> vers = new ArrayList<>();
                vers.add(s_id);
                versions.put(k, vers);
                List<String> vals = new ArrayList<>();
                vals.add(v);
                values.put(k, vals);
            } else {
                List<Integer> vers = versions.get(k);
                List<String> vals = values.get(k);
                if (!v.equals(vals.get(vals.size() - 1))) {
                    vals.add(v);
                    vers.add(s_id);
                }
            }
        }
        return s_id;
    }

    // O(lg(# of snapshots))
    public String getFromSnapshot(String key, int s_id) {
        if (!versions.containsKey(key)) {
            return null;
        }

        List<Integer> vers = versions.get(key);
        int p = Collections.binarySearch(vers, s_id);
        if (p >= 0) {
            return values.get(key).get(p);
        }

        p = -p - 1;
        if (s_id > this.s_id) {
            return null;
        }
        return values.get(key).get(p - 1);
    }
}

package com.real.verkada_2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyValueStore_solution_1 {
    private int s_id = 0;
    private Map<String, String> cur;
    private Map<String, Map<String, Set<Integer>>> snapshots;

    public static void main(String[] args) {
        KeyValueStore_solution_1 kv = new KeyValueStore_solution_1();
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

    public KeyValueStore_solution_1() {
        cur = new HashMap<>();
        snapshots = new HashMap<>();
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
            if (!snapshots.containsKey(k)) {
                snapshots.put(k, new HashMap<>());
            }
            Map<String, Set<Integer>> versions = snapshots.get(k);
            if (!versions.containsKey(v)) {
                Set<Integer> s = new HashSet<>();
                s.add(s_id);
                versions.put(v, s);
            } else {
                versions.get(v).add(s_id);
            }
        }
        return s_id;
    }

    // O(# of snapshots)
    public String getFromSnapshot(String key, int s_id) {
        if (!snapshots.containsKey(key)) {
            return null;
        }

        Map<String, Set<Integer>> versions = snapshots.get(key);
        for (String v : versions.keySet()) {
            if (versions.get(v).contains(s_id)) {
                return v;
            }
        }

        return null;
    }
}

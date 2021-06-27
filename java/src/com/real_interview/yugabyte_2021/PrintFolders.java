package com.real_interview.yugabyte_2021;

import java.util.HashMap;
import java.util.Map;

public class PrintFolders {
    public static void main(String[] args) {
        PrintFolders s = new PrintFolders();
        s.solution(new String[]{"a/b/c/d", "a/b/e/d", "test/ss", "test/ss/er", "test/ss/dds"});
    }

    private static class Trie {
        String path;
        Map<String, Trie> children = new HashMap<>();

        Trie(String path) {
            this.path = path;
        }
    }

    public void solution(String[] folders) {
        Trie root = new Trie("");
        for (String folder : folders) {
            String[] arr = folder.split("/");
            Trie p = root;
            for (String sub : arr) {
                if (!p.children.containsKey(sub)) {
                    p.children.put(sub, new Trie(sub));
                }
                p = p.children.get(sub);
            }
        }

        dfsPrint(root, -1);
    }

    private void dfsPrint(Trie p, int h) {
        if (!p.path.isEmpty()) {
            for (int i = 0; i < h; i++) {
                System.out.print("\t");
            }
            System.out.println(p.path);
        }

        for (Trie child : p.children.values()) {
            dfsPrint(child, h + 1);
        }
    }
}

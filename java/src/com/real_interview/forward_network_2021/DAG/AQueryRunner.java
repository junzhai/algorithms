package com.real_interview.forward_network_2021.DAG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AQueryRunner implements QueryRunner {
    private final List<Node> seed;

    public AQueryRunner(List<Node> seed) {
        this.seed = seed;
    }

    public List<Long> selectPath() {
        List<Long> ret = new ArrayList<>();
        Node p = seed.get(0);
        while (p != null) {
            ret.add(p.id);
            p = p.children.isEmpty() ? null : p.children.get(0);
        }
        return ret;
    }

    public List<Long> selectPath(Tag tag) {
        List<Long> ret = new ArrayList<>();
        Set<Long> invalid = new HashSet<>();
        for (Node n : seed) {
            if (invalid.contains(n.id)) {
                continue;
            }

            if (helper(n, ret, tag, false, invalid)) {
                return ret;
            }
        }
        return null;
    }

    private boolean helper(Node n, List<Long> path, Tag tag, boolean found, Set<Long> invalid) {
        path.add(n.id);
        found |= n.tags.contains(tag);

        if (found) {
            if (!n.children.isEmpty()) {
                return helper(n.children.get(0), path, tag, true, invalid);
            }
            return true;
        }

        for (Node child : n.children) {
            if (invalid.contains(child.id)) {
                continue;
            }

            if (helper(child, path, tag, false, invalid)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        invalid.add(n.id);
        return false;
    }
}

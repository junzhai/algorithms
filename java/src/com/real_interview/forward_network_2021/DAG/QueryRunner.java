package com.real_interview.forward_network_2021.DAG;

import java.util.List;

public interface QueryRunner {
    // Returns some path through the dag, if one exists
    List<Long> selectPath();

    // Returns a path through the dag that contains at least one node with the given tag or
    // an empty list if no such path exists.
    List<Long> selectPath(Tag tag);
}


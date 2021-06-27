package com.real_interview.forward_network_2021.DAG;

import java.util.List;

public abstract class Dag {
    protected List<Node> seedNodes;

    public abstract QueryRunner genQueryRunner();
}


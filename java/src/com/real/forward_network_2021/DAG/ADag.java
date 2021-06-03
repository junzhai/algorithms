package com.real.forward_network_2021.DAG;

import java.util.List;

public class ADag extends Dag {
    public ADag(List<Node> seed) {
        seedNodes = seed;
    }

    public QueryRunner genQueryRunner() {
        return new AQueryRunner(seedNodes);
    }
}


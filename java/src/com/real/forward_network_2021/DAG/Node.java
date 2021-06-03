package com.real.forward_network_2021.DAG;

import java.util.List;
import java.util.Set;

public class Node {
    long id; // Unique for each node in our DAG
    List<Node> children;
    Set<Tag> tags;


}
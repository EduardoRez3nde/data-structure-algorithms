package com.datastructure.graph;

public enum Edges {

    EDGES_EXIST(true),
    EDGES_NONE(false);

    final boolean value;

    Edges(boolean i) {
        value = i;
    }
}

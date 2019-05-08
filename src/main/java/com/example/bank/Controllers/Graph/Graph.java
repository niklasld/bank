package com.example.bank.Controllers.Graph;

import java.util.HashMap;
import java.util.Map;

public class Graph<T> {

    Map<T, Map<T, Integer>> adjencencyList = new HashMap<>();
    public void addEdge(Edge<T> edge) {
        addEdge(edge.v1, edge.v2, edge.weight);
    }

    private void addEdge(T v1, T v2, int weight) {
        if(!adjencencyList.containsKey(v1)) {
            adjencencyList.put(v1, new HashMap<>());
        }
        adjencencyList.get(v1).put(v2, weight);

        //nedenfor bliver grafen undirected
        if(!adjencencyList.containsKey(v2)) {
            adjencencyList.put(v2, new HashMap<>());
        }
        adjencencyList.get(v2).put(v1,weight);
    }
}

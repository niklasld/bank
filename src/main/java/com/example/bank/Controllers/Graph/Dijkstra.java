package com.example.bank.Controllers.Graph;

import java.util.*;

public class Dijkstra<T> {

    private PriorityQueue<Vertex> queue = new PriorityQueue<>();
    private Map<Vertex, Vertex> backTrack = new HashMap<>();

    public void runDijkstra(Vertex v1, Vertex v2, Graph<Vertex> graph) {
        Set<Vertex> markSet = new HashSet<>();
        queue.add(v1);
        v1.setLengthFromStart(0);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            markSet.add(current); // start er markeret nu

            for(Vertex neighbor : graph.adjencencyList.get(current).keySet()) {
                int initialWeight = graph.adjencencyList.get(current).get(neighbor);

                if(current.getLengthFromStart() + initialWeight < neighbor.getLengthFromStart()){
                    neighbor.setLengthFromStart(current.getLengthFromStart() + initialWeight);
                    backTrack.put(neighbor, current);
                }

                if(!markSet.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        //Udskriv korteste vej
        Vertex v = v2; //destination
        String path = v.name + " ";

        while(v != v1) {
            path += backTrack.get(v).name+ "\n";
            v = backTrack.get(v);

        }
        System.out.println(path);


    }
}

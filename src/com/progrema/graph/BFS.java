package com.progrema.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<T> {

    /**
     * pseudocode:
     * <p>
     * set root to visited
     * add root to queue
     * <p>
     * while queue is not empty
     * get vertex from queue
     * get all neighbours from queue
     * visit all non-visited vertex (show val for debugging purpose)
     * add the neighbours of this vertex to queue
     */

    private Queue<Vertex<T>> queue;
    private Vertex<T> root;

    public BFS(Vertex<T> vertex) {
        root = vertex;
        System.out.println("val = " + vertex.getVal());
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (Vertex<T> ver : queue.remove().getList()) {
                if (!ver.isVisited()) {
                    System.out.println("val = " + ver.getVal());
                    ver.setVisited(true);
                    queue.add(ver);
                }
            }
        }
    }

    public static void test() {

        System.out.println("BFS");

        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);
        Vertex<Integer> vertex6 = new Vertex<>(6);
        Vertex<Integer> vertex7 = new Vertex<>(7);

        vertex1.addNeighbour(vertex2);
        vertex1.addNeighbour(vertex3);

        vertex2.addNeighbour(vertex4);
        vertex2.addNeighbour(vertex5);
        vertex2.addNeighbour(vertex3); // this is to make sure that BFS only visit the non-visited vertex

        vertex3.addNeighbour(vertex6);
        vertex3.addNeighbour(vertex7);

        BFS bfs = new BFS(vertex1);
    }

}

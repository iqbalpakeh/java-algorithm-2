package com.progrema.digraph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<T> {

    private Queue<Vertex<T>> queue;
    private Vertex<T> root;

    public BFS(Vertex<T> vertex) {
        root = vertex;
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.remove();
            for (Vertex<T> ver : currentVertex.getList()) {
                if (!ver.isVisited()) {
                    ver.setVisited(true);
                    ver.setFrom(currentVertex);
                    queue.add(ver);
                }
            }
        }
    }

    public static void test() {

        Vertex<Integer> vertex0 = new Vertex<>(0);
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);
        Vertex<Integer> vertex6 = new Vertex<>(6);
        Vertex<Integer> vertex7 = new Vertex<>(7);
        Vertex<Integer> vertex8 = new Vertex<>(8);
        Vertex<Integer> vertex9 = new Vertex<>(9);
        Vertex<Integer> vertex10 = new Vertex<>(10);
        Vertex<Integer> vertex11 = new Vertex<>(11);
        Vertex<Integer> vertex12 = new Vertex<>(12);

        vertex0.addEdge(vertex1);
        vertex0.addEdge(vertex5);
        vertex2.addEdge(vertex0);
        vertex2.addEdge(vertex3);
        vertex3.addEdge(vertex2);
        vertex3.addEdge(vertex5);
        vertex4.addEdge(vertex2);
        vertex4.addEdge(vertex3);
        vertex5.addEdge(vertex4);
        vertex6.addEdge(vertex0);
        vertex6.addEdge(vertex4);
        vertex6.addEdge(vertex8);
        vertex7.addEdge(vertex6);
        vertex7.addEdge(vertex9);
        vertex8.addEdge(vertex6);
        vertex9.addEdge(vertex10);
        vertex9.addEdge(vertex11);
        vertex10.addEdge(vertex12);
        vertex11.addEdge(vertex4);
        vertex11.addEdge(vertex12);
        vertex12.addEdge(vertex9);

        BFS bfs = new BFS(vertex7);
        bfs.trace(vertex4);
        bfs.trace(vertex5);

    }

    public void trace(Vertex<T> vertex) {
        Vertex<T> current = vertex;
        System.out.println("trace of " + vertex.getVal());
        while (current.getVal() != root.getVal()) {
            System.out.println("- " + current.getVal());
            current = current.getFrom();
        }
        System.out.println("- " + current.getVal());
    }

}

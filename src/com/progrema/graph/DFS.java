package com.progrema.graph;

public class DFS<T> {

    public DFS(Vertex<T> root) {
        dfs(root);
    }

    private void dfs(Vertex<T> vertex) {
        if (!vertex.isVisited()) {
            System.out.println("visit " + vertex.getVal());
            vertex.setVisited(true);
        }
        for(Vertex<T> neighbour: vertex.getList()) {
            if (!neighbour.isVisited()) {
                dfs(neighbour);
            }
        }
    }

    public static void test() {

        System.out.println("DFS");

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

        DFS dfs = new DFS(vertex1);
    }

}

package com.progrema.digraph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private boolean isVisited;
    private T val;
    private List<Vertex<T>> list;
    private Vertex from;

    public Vertex(T val) {
        this.isVisited = false;
        this.list = new ArrayList<>();
        this.val = val;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public List<Vertex<T>> getList() {
        return list;
    }

    public void addEdge(Vertex<T> vertex) {
        list.add(vertex);
    }

    public Vertex<T> getFrom() {
        return this.from;
    }

    public void setFrom(Vertex<T> vertex) {
        this.from = vertex;
    }
}
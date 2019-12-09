package com.progrema.tree;

import java.util.LinkedList;

public class BST<K extends Comparable<K>, V> {

    private Node root;

    public static void test() {

        BST bst = new BST();
        bst.put(5, "Five");
        bst.put(7, "Seven");
        bst.put(6, "Six");
        bst.put(8, "Eight");
        bst.put(3, "Three");
        bst.put(2, "Two");
        bst.put(4, "Four");

        check(bst.size(), 7);
        check(String.valueOf(bst.getMax()), "Eight");
        check(String.valueOf(bst.getMin()), "Two");

        for (Object val : bst.iterator()) {
            System.out.println(val);
        }

        bst.deleteMin();
        check(bst.size(), 6);

        check(String.valueOf(bst.getMax()), "Eight");
        check(String.valueOf(bst.getMin()), "Three");

        for (Object val : bst.iterator()) {
            System.out.println(val);
        }

        bst.deleteMax();
        check(bst.size(), 5);

        check(String.valueOf(bst.getMax()), "Seven");
        check(String.valueOf(bst.getMin()), "Three");

        System.out.println("========");

        for (Object val : bst.iterator()) {
            System.out.println(val);
        }

        bst.delete(6);

        System.out.println("========");

        for (Object val : bst.iterator()) {
            System.out.println(val);
        }
    }

    public static void check(int actual, int expected) {
        if (actual == expected) {
            System.out.println("OK, actual = expected = " + actual);
        } else {
            System.out.println("ERROR, actual = " + actual + ", expected = " + expected);
        }
    }

    public static void check(String actual, String expected) {
        if (expected != null) {
            if (actual.equals(expected)) {
                System.out.println("OK, actual = expected = " + actual);
            } else {
                System.out.println("ERROR, actual = " + actual + ", expected = " + expected);
            }
        } else {
            if (actual != null) {
                System.out.println("ERROR, actual = " + actual + ", expected = null");
            } else {
                System.out.println("OK, actual = expected = null");
            }
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int comp = key.compareTo(node.key);
        if (comp > 0) {
            // go right
            node.right = put(node.right, key, val);
        } else if (comp < 0) {
            // go left
            node.left = put(node.left, key, val);
        } else {
            // update
            node.val = val;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int comp = key.compareTo(node.key);
        if (comp > 0) {
            // go right
            return get(node.right, key);
        } else if (comp < 0) {
            // go left
            return get(node.left, key);
        } else {
            // search hit
            return node.val;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int rank(K key) {
        return rank(root, key);
    }

    private int rank(Node node, K key) {
        if (node == null) {
            return 0;
        }
        int comp = key.compareTo(node.key);
        if (comp > 0) {
            // go right
            return 1 + size(node.left) + rank(node.right, key);
        } else if (comp < 0) {
            // go left
            return rank(node.left, key);
        } else {
            // search hit
            return size(node.left);
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public V getMax() {
        return getMax(root);
    }

    private V getMax(Node node) {
        if (node.right == null) {
            return node.val;
        }
        return getMax(node.right);
    }

    public V getMin() {
        return getMin(root);
    }

    private V getMin(Node node) {
        if (node.left == null) {
            return node.val;
        }
        return getMin(node.left);
    }

    public Iterable<V> iterator() {
        LinkedList<V> queue = new LinkedList<>();
        iterator(root, queue);
        return queue;
    }

    private void iterator(Node node, LinkedList<V> queue) {
        if (node == null) {
            return;
        }
        iterator(node.left, queue);
        queue.add(node.val);
        iterator(node.right, queue);
    }

    private class Node {
        K key;
        V val;
        Node left;
        Node right;
        int size;

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

}
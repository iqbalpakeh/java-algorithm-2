package com.progrema.tree;

public class BST<K extends Comparable<K>, V> {

    // ------------------------------------------------------------
    // Implementation Section
    // ------------------------------------------------------------

    private Node root;

    public static void test() {

        {
            BST bst = new BST();
            bst.put(2, "Two");
            bst.put(3, "Three");
            bst.put(1, "One");

            check(String.valueOf(bst.get(2)), "Two");
            check(String.valueOf(bst.get(3)), "Three");
            check(String.valueOf(bst.get(1)), "One");
            check(String.valueOf(bst.get(4)), "null");

            check(bst.size(), 3);

            check(bst.rank(3), 2);
            check(bst.rank(4), 3);
        }

        {
            BST bst = new BST();
            bst.put(5, "Five");
            bst.put(7, "Seven");
            bst.put(6, "Six");
            bst.put(8, "Eight");
            bst.put(3, "Three");
            bst.put(2, "Two");
            bst.put(4, "Four");

            System.out.println("END");

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

    // ------------------------------------------------------------
    // Test Section
    // ------------------------------------------------------------

    public void delete(K key) {

    }

    public Iterable<K> iterator() {
        return null;
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
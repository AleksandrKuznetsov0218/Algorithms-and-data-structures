package lesson6;

import java.util.NoSuchElementException;

public class BST {

    Node root;

    private class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;
        private int size;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }

    }


    public boolean isEmpty() {
        return root == null;
    }


    public int get(int key) {
        return get(root, key);
    }

    private int get(Node node, int key) {
        if (key == node.key) {
            return node.value;
        } else {
            if (key < node.key) {
                return get(node.left, key);
            } else {
                return get(node.right, key);
            }
        }
    }

    public void put(int key, int value) {
        root = put(root, key, value);
    }

    private Node put(Node node, int key, int value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key == node.key) {
            node.value = value;
        } else if (key < node.key) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public String toString() {
        return "BST(" + toString(root) + ")";
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.value + " " + toString(node.right);
    }

    public int min() {
        return min(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public int max() {
        return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int depth() {
        return depth(root);
    }


    private int depth(Node node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(depth(node.left), depth(node.right)) + 1;
        }
    }

    public boolean balanceTree() {
        return balanceTree(root);
    }

    private boolean balanceTree(Node node) {
        if (Math.abs(size(node.left) - size(node.right)) <= 1) {
            return true;
        } else {
            return false;
        }
    }

}
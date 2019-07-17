package lesson8;

import java.util.LinkedList;

public class ChainingHashST<Key, Value> {
    private int capacity = 97;
    private int size = 0;

    private LinkedList<Node>[] st;

    public ChainingHashST(int capacity) {
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        private Key key;
        private Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return this.key.equals(((Node) obj).key);
        }

        @Override
        public int hashCode() {
            return this.key.hashCode();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(Key key, Value value) {
//        if (key == null) {
//            throw new IllegalArgumentException("null key");
//        }

        ifKeyIsNull(key);

        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
//        if (key == null) {
//            throw new IllegalArgumentException("null key");
//        }

        ifKeyIsNull(key);

        int i = hash(key);
        for (Node node : st[i]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
//        if (key == null) {
//            throw new IllegalArgumentException("null key");
//        }

        ifKeyIsNull(key);

        int i = hash(key);
        st[i].remove(new Node(key, null));
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                s += node.key + " ";
            }
            s += "\n";
        }

        return "hainingHashST{\n" +
                s +
                "}";

    }

    public void ifKeyIsNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("null key");
        }
    }
}




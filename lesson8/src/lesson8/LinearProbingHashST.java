package lesson8;

public class LinearProbingHashST<Key, Value> {
    private int capacity;
    private int size = 0;

    private Key DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int capacity, Key DELETED) {
        this.capacity = capacity;
        this.DELETED = DELETED;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
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
//        int x = 1;
        // Двойное хеширование        int step = 5 - (key.hashCode() & 0xfffffff)%5;
        while (keys[i] != null || !keys[i].equals(DELETED)) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
//            x++;
            // Квадратичное пробирование            step = step + x * x;
            i = (i + 1) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;

    }

    public Value get(Key key) {
//        if (key == null) {
//            throw new IllegalArgumentException("null key");
//        }

        ifKeyIsNull(key);

        int i = hash(key);
// Двойное хеширование        int step = 5 - (key.hashCode() & 0xfffffff)%5;
        int step = 1;
//        int x = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return values[i];
            }
//            x++;
// Квадратичное пробирование            step = step + x * x;
            i = (i + 1) % capacity;

        }
        return null;
    }

    public void delete(Key key) {
//        if (key == null) {
//            throw new IllegalArgumentException("null key");
//        }

        ifKeyIsNull(key);

        // Двойное хеширование        int step = 5 - (key.hashCode() & 0xfffffff)%5;
        int i = hash(key);
//        int x = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                keys[i] = DELETED;
                size--;
                return;
            }
//            x++;
            // Квадратичное пробирование            step = step + x * x;
            i = (i + 1) % capacity;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < capacity; i++) {
            s += keys[i] + " ";
        }
        return "hainingHashST{\n" +
                "keys = " + s +
                "}";
    }

    public void ifKeyIsNull(Key key){
        if (key == null) {
            throw new IllegalArgumentException("null key");
        }
    }
}
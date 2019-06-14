package lesson3;

public class Deque {

    private int[] deque;
    private int size = 0;
    private final int DEFAULT_MAXSIZE = 10;
    private int begin = 0;
    private int end = 0;
    private final double LOAD_FACTOR = 0.75;

    public Deque(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Bad size " + size);
        } else {
            deque = new int[size];
        }
    }


    public Deque() {
        deque = new int[DEFAULT_MAXSIZE];
    }

    //Проверка на пустоту
    public boolean isEmpty() {
        return (size == 0);
    }

    public int peekRight() {
        if (size <= 0) {
            throw new StackOverflowError("size <= 0");
        }
        return deque[begin];
    }

    public int peekLeft() {
        if (size <= 0) {
            throw new StackOverflowError("size <= 0");
        }
        return deque[lastIndex(end)];
    }

    //Добавление элемента справа
    public void addRight(int i) {
        size++;
        expandDeque();
        deque[end] = i;
        end = nextIndex(end);
    }

    //Добавление элемента слева
    public void addLeft(int i) {
        size++;
        expandDeque();
        begin = lastIndex(begin);
        deque[begin] = i;
    }

    public int removeRight() {
        int temp = peekRight();
        size--;
        deque[begin] = 0;
        begin = nextIndex(begin);
        return temp;
    }

    public int removeLeft() {
        int temp = peekLeft();
        size--;
        end = lastIndex(end);
        deque[end] = 0;
        return temp;
    }

    private int nextIndex(int index) {
        return (index + 1) % deque.length;
    }

    private int lastIndex(int index) {
        return (deque.length + index - 1) % deque.length;
    }

    private void expandDeque() {
        if ((double) size / deque.length > LOAD_FACTOR) {
            int[] tempArr = new int[deque.length * 2];
            if (begin <= end) {
                System.arraycopy(deque, 0, tempArr, 0, deque.length);
            } else {
                System.arraycopy(deque, 0, tempArr, 0, end);
                int newBegin = tempArr.length - deque.length + begin;
                System.arraycopy(deque, begin, tempArr, newBegin, deque.length - begin);
                begin = newBegin;
            }
            deque = tempArr;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < deque.length; i++) {
            s += deque[i] + " ";
        }
        return s;
    }
}
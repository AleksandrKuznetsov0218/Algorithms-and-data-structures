package lesson3;

public class Queue {

    private int[] queue;
    private int size = 0;
    private final int DEFAULT_MAXSIZE = 10;
    private int begin = 0;
    private int end = 0;


    public Queue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Bad size " + size);
        } else {
            queue = new int[size];
        }
    }

    public Queue() {
        queue = new int[DEFAULT_MAXSIZE];
    }


    //Проверка на пустоту
    public boolean isEmpty() {
        return (size == 0);
    }

    //Проверка на переполненность
    public boolean isFull() {
        return (size == queue.length);
    }

    //Получение начального элемента
    public int peek() {
        if (isEmpty()) {
            throw new StackOverflowError("Очередь пуста");
        } else {
            return queue[begin];
        }
    }

    //Добавление элемента
    public void insert(int i) {
        if (isFull()) {
            throw new StackOverflowError("Очередь переполнена");
        } else {
            size++;
            queue[end] = i;
            end = nextIndex(end);
        }
    }

    //Удаление элемента
    public int remove() {
        int temp = peek();
        size--;
        queue[begin] = 0;
        begin = nextIndex(begin);
        return temp;
    }

    private int nextIndex(int index) {
        return (index + 1) % queue.length;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < queue.length; i++) {
            s += queue[i] + " ";
        }
        return s;
    }

}

package lesson3;

public class PriorityQueue {

    private int[] priorityQueue;
    private int size = 0;
    private final int DEFAULT_MAXSIZE = 10;


    public PriorityQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Bad size " + size);
        } else {
            priorityQueue = new int[size];
        }
    }

    public PriorityQueue() {
        priorityQueue = new int[DEFAULT_MAXSIZE];
    }


    //Проверка на пустоту
    public boolean isEmpty() {
        return (size == 0);
    }

    //Проверка на переполненность
    public boolean isFull() {
        return (size == priorityQueue.length);
    }

    //Размер
    public int size() {
        return size;
    }

    //Добавление элемента
    public void insert(int z) {
        if (isFull()) {
            System.out.println("Очередь полна");
            //           throw new StackOverflowError("Очередь полна");
        } else {
            priorityQueue[size] = z;
            size++;
            int i = size - 1;
            while (i > 0 && priorityQueue[i] < priorityQueue[i - 1]) {
                swap(i, i - 1);
                i--;
            }
        }
    }

    //Удаление элемента
    public int remove() {
        int temp = peek();
        priorityQueue[size] = 0;
        size--;
        return temp;
    }

    //Получение  элемента
    public int peek() {
        if (isEmpty()) {
            throw new StackOverflowError("Очередь пуста");
        } else {
            return priorityQueue[size - 1];
        }
    }

    private void swap(int index1, int index2) {
        int temp = priorityQueue[index1];
        priorityQueue[index1] = priorityQueue[index2];
        priorityQueue[index2] = temp;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < priorityQueue.length; i++) {
            s += priorityQueue[i] + " ";
        }
        return s;
    }
}

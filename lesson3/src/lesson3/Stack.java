package lesson3;

public class Stack {

    private String[] stack;
    private int size = 0;
    private final int DEFAULT_MAXSIZE = 10;


    public Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Bad size " + size);
        } else {
            stack = new String[size];
        }
    }

    public Stack() {
        stack = new String[DEFAULT_MAXSIZE];
    }


    //Проверка на пустоту
    public boolean isEmpty() {
        return (size == 0);
    }

    //Проверка на переполненность
    public boolean isFull() {
        return (size == stack.length);
    }

    //Размер стека
    public int size() {
        return size;
    }

    //Добавление элемента
    public void push(String i) {
        if (isFull()) {
            System.out.println("Стек полон");
            //           throw new StackOverflowError("Стек полон");
        } else {
            stack[size] = i;
            size++;
        }
    }

    //Удаление элемента
    public String pop() {
        String temp = peek();
        stack[size] = null;
        size--;
        return temp;
    }

    //Получение верхнего элемента
    public String peek() {
        if (isEmpty()) {
            return ("Стек пуст");
//            throw new StackOverflowError("Стек пуст");
        } else {
            return stack[size - 1];
        }
    }


    //Увеличение размера стека
    public void incrementStack(int i) {
        String[] tempArray = new String[size + i];
        System.arraycopy(stack, 0, tempArray, 0, stack.length);
        stack = tempArray;
    }

    //Уменьшение размера стека
    public void decrementStack(int i) {
        if (stack.length - i < 1) {
            System.out.println("Размер стека не может быть меньше единицы.");
        } else {
            String[] tempArray = new String[size + i];
            System.arraycopy(stack, 0, tempArray, 0, stack.length - i);
            stack = tempArray;
        }

    }

}

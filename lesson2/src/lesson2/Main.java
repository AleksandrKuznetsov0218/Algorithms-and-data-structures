package lesson2;

import java.util.ArrayList;

public class Main {

    private static final int SMOLL_NUMBER_OF_ARRAY_ITEMS = 10;
    private static final int BIG_NUMBER_OF_ARRAY_ITEMS = 100000;
    private static long startTime = 0;
    private static long spentTime = 0;

    public static void main(String[] args) {

        MyArr arr = new MyArr(SMOLL_NUMBER_OF_ARRAY_ITEMS);

        arr.insert(5);
        arr.insert(1);
        arr.insert(2);
        arr.insert(5);
        arr.insert(4);
        arr.insert(5);
        arr.insert(6);
        arr.insert(5);
        arr.insert(8);
        arr.insert(9);

        System.out.println("Выводим исходный массив");
        System.out.println(arr.toString());

        int search = 8;

        if (arr.find(search)) {
            arr.delete(search);
            System.err.println("Элемент " + search + " удален");
            System.out.println("Выводим новый массив");
            System.out.println(arr.toString());
        } else {
            System.out.println("Не удалось найти элемент " + search);
        }

        //    1. Создать массив большого размера (миллион элементов).
        MyArr arrBig = new MyArr(BIG_NUMBER_OF_ARRAY_ITEMS);
        //    3. Заполнить массив случайными числами.
        for (int i = 0; i < BIG_NUMBER_OF_ARRAY_ITEMS; i++) {
            arrBig.insert((int) (Math.random() * BIG_NUMBER_OF_ARRAY_ITEMS));
        }
        //    Проверка пузырьковой сортировки на малом массиве
//        arr.sortBubble();
//        System.out.println(arr.toString());

        //    Проверка сортировки методом выбора на малом массиве
//        arr.sortSelect();
//        System.out.println(arr.toString());

        //    Проверка сортировки методом вставки на малом массиве
//        arr.sortInsert();
//        System.out.println(arr.toString());

//        Затраты времени для пузырьковой сортировки на больщом массиве
//        startTime = System.currentTimeMillis();
//        arrBig.sortBubble();
//        spentTime = System.currentTimeMillis() - startTime;
//        System.out.println("На сортировку затрачено: " + spentTime+" мс.");

        //        Затраты времени для сортировки методом выбора на больщом массиве
//        startTime = System.currentTimeMillis();
//        arrBig.sortSelect();
//        spentTime = System.currentTimeMillis() - startTime;
//        System.out.println("На сортировку затрачено: " + spentTime+" мс.");

        //        Затраты времени для сортировки методом вставки на больщом массиве
//        startTime = System.currentTimeMillis();
//        arrBig.sortInsert();
//        spentTime = System.currentTimeMillis() - startTime;
//        System.out.println("На сортировку затрачено: " + spentTime+" мс.");

    }
}

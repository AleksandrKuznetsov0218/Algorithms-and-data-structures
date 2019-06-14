package lesson5;

import static lesson5.TheTaskOfTheBackpack.costs;
import static lesson5.TheTaskOfTheBackpack.weights;

public class Main {

    public static void main(String[] args) {
        // Возведение числа 2 в степень
//        System.out.println(Exponentiation.degreeOfNumber2(2));
//        System.out.println(Exponentiation.degreeOfNumber2(10));
//        System.out.println(Exponentiation.degreeOfNumber2(30));
//
//      Задача о рюкзаке 0-1

        //Стоимость каждого предмета
        costs[0] = 1;
        costs[1] = 6;
        costs[2] = 4;
        costs[3] = 7;
        costs[4] = 6;
        //Вес каждого предмета
        weights[0] = 3;
        weights[1] = 4;
        weights[2] = 5;
        weights[3] = 8;
        weights[4] = 9;

        TheTaskOfTheBackpack.knapsack1();
    }
}

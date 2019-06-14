package lesson5;

public class TheTaskOfTheBackpack {

    public TheTaskOfTheBackpack() {
    }

    static int quantity = 13;    //Вместимость рюкзака
    static int n = 5;            //Количесто разных предметов
    static public int costs[] = new int[n];
    static public int weights[] = new int[n];
    public static int A[][] = new int[quantity + 1][n + 1];


    public static void knapsack1() {
//        int n = weights.length;
        for (int j = 1; j <= weights.length; j++) {
            for (int w = 1; w <= quantity; w++) {
                if (weights[j - 1] <= w) {
                    A[w][j] = Math.max(A[w][j - 1], A[w - weights[j - 1]][j - 1] + costs[j - 1]);
                } else {
                    A[w][j] = A[w][j - 1];
                }
            }
        }
        System.out.println("Максимальная стоимость рюкзака "+A[quantity][n]);
    }
}
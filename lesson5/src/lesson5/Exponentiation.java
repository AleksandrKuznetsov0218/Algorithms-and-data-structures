package lesson5;

public class Exponentiation {

    public Exponentiation() {
    }

    public static int degreeOfNumber2(int y) {
        if (y < 2) {
            return 1;
        } else {
            return (int)Math.pow(2, y - 1)*2;
        }
    }
}

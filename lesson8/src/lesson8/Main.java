package lesson8;

public class Main {

    public static void main(String[] args) {
        ChainingHashST<Integer, String> chhs = new ChainingHashST<>(7);
//        chhs.put(1, "Один");
//        chhs.put(2, "Два");
//        chhs.put(3, "Три");
//        chhs.put(4, "Четыре");
//        chhs.put(5, "Пять");

        for (int i = 0; i < 90; i++) {
            chhs.put(i, "Число "+i);
        }

//        for (int i = 0; i < 90; i++) {
//            chhs.put((int) (Math.random() * 1000), "Число " + i);
//        }
        System.out.println(chhs);

        chhs.delete(45);
        chhs.delete(52);
        chhs.delete(80);

        System.out.println(chhs);

//        LinearProbingHashST<Integer, String> lpst = new LinearProbingHashST<>(97);

//        for (int i = 0; i < 90; i++) {
//            lpst.put(i, "Число " + i);
//        }

//        for (int i = 0; i < 90; i++) {
//            lpst.put((int) (Math.random() * 1000), "Число " + i);
//        }
//        System.out.println(lpst);


    }
}

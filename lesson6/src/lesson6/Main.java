package lesson6;

public class Main {

    public static void main(String[] args) {
        int balance = 0;
        int disBalance = 0;
        for (int i = 0; i < 20; i++) {
            BST bst = new BST();
            while ((bst.depth() <= 6)) {
                int k = (int) (Math.random() * 200) - 100;
                bst.put(k, k);
            }
//            System.out.println(bst.size());

            if (bst.balanceTree()) {
                balance++;
            } else {
                disBalance++;
            }
        }
        System.out.println("Сбалансированных: " + balance);
        System.out.println("Несбалансированных: " + disBalance);
    }
}
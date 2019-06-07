package lesson2;

public class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    //Переопределение метода toString

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += this.arr[i] + " ";
        }
        return s;
    }


    //    Удвление элемента массива
    public void delete(int value) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    //    Вставка элемента
    public void insert(int value) {
        this.arr[this.size] = value;
        this.size++;
    }

    //    Поиск элемента методом перебора
    public boolean find(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    //    Пузырьковая сортировка
    public void sortBubble() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (this.arr[in] > this.arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    //    Сортировка методом выбора
    public void sortSelect() {
        int out, in, mark;
        for (out = 0; out < this.size; out++) {
            mark = out;
            for (in = out + 1; in < this.size; in++) {
                if (this.arr[in] < this.arr[mark]) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    //    Сортировка методом вставки
    public void sortInsert() {
        int in, out;
        for (out = 1; out < this.size; out++) {
            int temp = this.arr[out];
            in = out;
            while (in > 0 && this.arr[in - 1] >= temp) {
                this.arr[in] = this.arr[in - 1];
                --in;
            }
            this.arr[in] = temp;
        }
    }
}

import java.util.*;

public class Main {
    static long count = 0;
    static int check = 0;

    public void run () {
        Scanner scanner = new Scanner("7\n" +
                "7 6 5 4 3 2 1");
        int n = scanner.nextInt(); // число элементов входного массива
        if (n == 1) {
            System.out.println(0);
        } else {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            sortedArray(a);
        }
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int x1 = a1.length;
        int x2 = a2.length;
        int[] a3 = new int[x1 + x2];
        int x3 = a3.length;
        //outer:
        int i = 0, j = 0;
        for (int k = 0; k < x3; k++) {
            if (i > x1 - 1) { //если закончился первый массив, заполняем элементами второго массива
                for (; j < x2; j++, k++) {
                    a3[k] = a2[j];
                }
            } else if (j > x2 - 1) { //если закончился второй массив, заполняем элементами первого массива и попутно умножаем счетчик на
                //количество элементов второго массива и плюсуем к уже накопленному
                count += (x1 - (i + 1)) * x2;
                for (; i < x1; i++, k++) {
                    a3[k] = a1[i];
                }
            } else if (a1[i] <= a2[j]) {
                a3[k] = a1[i];
                if (i != check && j > 0 && a1[i] > a2[j - 1]) count += j; //если элемент меньше второго, но при этом он больше, предыдущие второго массива
                //и условие что этот элемент еще ни с чем не сравнивался
                i++;
            } else {
                a3[k] = a2[j];
                j++;
                count++;
                check = i;//временный буфер для сравнения
            }
        }
        return a3;
 }


    public static void sortedArray(int[] ab) {
        Deque<int[]> q = new ArrayDeque<>();
        //long n = (long) Math.ceil(Math.sqrt(ab.length));
        int m = 2147483647;
        for (int i = 0; i < ab.length; i++) {
            q.addLast(new int[]{ab[i]});
        }
        while(Integer.bitCount(q.size())!=1) {
            q.addLast(new int[]{m});
        }
        while (q.size() > 1) {
            q.addLast(mergeArrays(q.pollFirst(), q.pollFirst()));
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}

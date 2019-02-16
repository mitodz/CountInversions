import java.util.*;

public class Main {
    static long count = 0;
    static int check = 0;

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        //outer:
        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {
            if (i > a1.length - 1) { //если закончился первый массив, заполняем элементами второго массива
                for (; j < a2.length; j++, k++) {
                    a3[k] = a2[j];
                }
            } else if (j > a2.length - 1) { //если закончился второй массив, заполняем элементами первого массива и попутно умножаем счетчик на
                //количество элементов второго массива и плюсуем к уже накопленному
                count = count + (a1.length - (i + 1)) * a2.length;
                for (; i < a1.length; i++, k++) {
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


    public static void sortedArray(int[] ab, int index) {
        Deque<int[]> q = new ArrayDeque<>();
        //long n = (long) Math.ceil(Math.sqrt(ab.length));
        int m = 1000000000;
        for (int i = index; i < ab.length; i++) {
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
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // число элементов входного массива
        if (n == 1) {
            System.out.println(0);
        } else {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            sortedArray(a, 0);

        }
        //System.out.println(Arrays.toString(mergeArrays(new int[] {2,3,9},new int[] {2,2,9})));
        //System.out.println(count);
    }
}

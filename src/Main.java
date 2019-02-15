import java.util.*;

public class Main {
    static int count = 0;
    static int check = 0;

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        //outer:
        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {
            if (i > a1.length - 1) {
                for (; j < a2.length; j++, k++) {
                    int b = a2[j];
                    a3[k] = b;
                }
            } else if (j > a2.length - 1) {
                count = count + (a1.length - (i + 1)) * count;
                for (; i < a1.length; i++, k++) {
                    int a = a1[i];
                    a3[k] = a;
                }
            } else if (a1[i] <= a2[j]) {
                int a = a1[i];
                a3[k] = a;
                if (i != check && j > 0 && a1[i] > a2[j - 1]) count += j + 1;
                i++;
            } else {
                int b = a2[j];
                a3[k] = b;
                j++;
                count++;
                check = i;
            }
        }
        return a3;
 }


    public static int[] sortedArray(int[] ab, int index) {
        Deque<int[]> q = new ArrayDeque<>();
        long n = (long) Math.ceil(Math.sqrt(ab.length));
        int m = 1000000000;
        for (int i = index; i < ab.length; i++) {
            q.addLast(new int[]{ab[i]});
        }
        for (int i = 0; i < Math.pow(2, n) - ab.length; i++) {
            q.addLast(new int[]{m});
        }
        while (q.size() > 1) {
            q.addLast(mergeArrays(q.pollFirst(), q.pollFirst()));
        }
        return q.poll();
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

            int[] result = sortedArray(a, 0);
            System.out.println(count);
        }
        //System.out.println(Arrays.toString(mergeArrays(new int[] {5,6,7},new int[] {1,2,3,4})));
        //System.out.println(count);
    }
}

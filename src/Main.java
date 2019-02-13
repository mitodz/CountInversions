import java.util.*;

public class Main {
    static int count = 0;

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        //outer:
        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {
            if (i > a1.length - 1) {
                int b = a2[j];
                a3[k] = b;
                if (a1[a1.length-1] > a2[j] && k != a3.length - 1) count++;
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                if (a1[i] > a2[a2.length-1] && k != a3.length - 1) count++;
                i++;
            } else if (a1[i] <= a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else {
                int b = a2[j];
                a3[k] = b;
                j++;
                count++;
            }
        }
        return a3;
    }

    public static int[] sortedArray(int[] ab, int index) {
        Deque<int[]> q = new ArrayDeque<>();
        int n = ab.length % 2 == 0 ? 4 : 3;
        int m = 1000000000;
        for (int i = index; i < ab.length; i++) {
            q.addLast(new int[]{ab[i]});
        }
        for (int i = 0; i < n; i++) {
            q.addLast(new int[] {m});
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
            int[] result = sortedArray(a,0);
            System.out.println(count);
//            System.out.println(count);
        }
    }
}

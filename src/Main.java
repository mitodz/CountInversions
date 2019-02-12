import java.util.*;

public class Main {

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        //outer:
        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {

            if (i > a1.length - 1) {
                int a = a2[j];
                a3[k] = a;
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else if (a1[i] < a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }

        return a3;
    }


    public static void showInvariations (int[] a) {
        // РЕАЛИЗОВАТЬ ПОРЦИОННУЮ СОРТИРОВКУ И ПОДСЧЁТ COUNT
        int count = 0; //количество инверсий
        Deque<Integer> q = new ArrayDeque<>();
        int[] aSorted = sortedQueueFromArray(a);
        for (int i : aSorted) {
            q.addLast(i);
        }
        System.out.println(count);
    }

    public static int[] sortedQueueFromArray (int[] ab) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < ab.length; i++) {
            q.addLast(new int[]{ab[i]});
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
            showInvariations(a);
//            System.out.println(count);
        }
    }
}

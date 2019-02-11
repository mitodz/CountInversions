import java.util.*;

public class Main {

//    public static int[] mergeArrays(int[] a, int[] b) {
//        int[] result = new int[a.length + b.length];
//    }

    public static void showInvariations (int[] a) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            q.addLast(new int[]{a[i]});
        }
        q.forEach(x-> {
            System.out.println(Arrays.toString(x));
        });
    }
        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt(); // число элементов входного массива

            if (n == 1) {
                System.out.println(0);
            } else {
                int count = 0; //количество инверсий
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                showInvariations(a);
//            System.out.println(count);
            }
        }
}

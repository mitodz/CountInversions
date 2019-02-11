import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\W");
        int n = scanner.nextInt(); // число элементов входного массива
        if (n == 1) {
            System.out.println(0);
        } else {
            int count = 0; //количество инверсий
            List<Integer> list = new ArrayList<>();
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            for (int i = 0, k = 1; i < n - 1 && k < n; ) {
                if (list.get(i) >= list.get(k)) {
                    count++;
                    k++;
                    continue;
                }
                i++;
                k++;
            }
            System.out.println(count);
        }
    }
}

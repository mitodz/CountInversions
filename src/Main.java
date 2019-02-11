import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in).useDelimiter("\\W");
	int n = scanner.nextInt(); // число элементов входного массива
        int[] a = new int[n];
        for (int i : a) {
            a[i]=scanner.nextInt();
        }

    }
}

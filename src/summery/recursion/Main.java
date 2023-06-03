package summery.recursion;

public class Main {

    public static void main(String[] args) {
        int[] a = {30, 9, 1, 4, 5, 6, 100, 9};
        printArray(a);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public static void printAllStrings(int n) {
        printAllStrings(n, "");
    }

    private static void printAllStrings(int n, String toPrint) {
        if (n == 0) {
            System.out.println(toPrint);
            return;
        }
        System.out.println(toPrint);
        printAllStrings(n - 1, toPrint + "0");
        printAllStrings(n - 1, toPrint + "1");
    }

    public static void printArray(int[] a) {
        printArray(a, 0);
    }

    private static void printArray(int[] a, int i) {
        if (i == a.length - 1) {
            System.out.print(a[i]);
            return;
        }

        System.out.print(a[i] + ", ");
        printArray(a, i + 1);
    }

}

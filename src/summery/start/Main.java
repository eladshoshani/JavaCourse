package summery.start;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = 0;

        System.out.println("Enter numbers, finish with -1:");
        int num = scanner.nextInt();
        while (num != -1) {
            s += num;
            num = scanner.nextInt();
        }

        System.out.println("The sum of all the numbers is: " + s);
    }
}

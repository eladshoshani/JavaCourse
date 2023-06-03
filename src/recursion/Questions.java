package recursion;

import complexity.Utils;

public class Questions {
    public static void main(String[] args) {
        System.out.println("amount: " + selectedPrimes2(819819000, 2));
        System.out.println("amount: " + selectedPrimes2(819819000, 3));
        System.out.println("amount: " + selectedPrimes2(819819000, 4));
    }

    /* 2023a, 57, q1, for testing purposes:
        System.out.println("amount: " + selectedPrimes(300, 2));
    */
    public static int selectedPrimes(int num, int x) {
        return selectedPrimes(num, x, 2);
    }

    private static int selectedPrimes(int num, int x, int currentPrime) {
        if (currentPrime > num)
            return 0;

        int currentPrimeToX = (int) Math.pow(currentPrime, x);
        int currentPrimeToXPlus1 = currentPrime * currentPrimeToX;
        if (num % currentPrimeToX == 0 && num % currentPrimeToXPlus1 != 0) { // found!
            System.out.println(currentPrime);
            return 1 + selectedPrimes(num, x, nextPrime(currentPrime));
        }
        // not found
        return selectedPrimes(num, x, nextPrime(currentPrime));
    }

    /* BONUS (second version): 2023a, 57, q1, for testing purposes:
        System.out.println("amount: " + selectedPrimes2(819819000, 2));
        System.out.println("amount: " + selectedPrimes2(819819000, 3));
        System.out.println("amount: " + selectedPrimes2(819819000, 4));
    */
    public static int selectedPrimes2(int num, int x) {
        return selectedPrimes2(num, x, 2, 0);
    }
    private static int selectedPrimes2(int num, int x, int currentPrime, int counter) {
        if (num == 1) {
            if (counter == x) {
                System.out.println(currentPrime);
                return 1;
            }
            return 0;
        }
        if (num % currentPrime == 0) { // can divide more
            return selectedPrimes2(num / currentPrime, x, currentPrime, counter + 1);
        }
        // cannot divide anymore
        if (counter == x) { // found!
            System.out.println(currentPrime);
            // increment the amount by 1
            return 1 + selectedPrimes2(num, x, nextPrime(currentPrime), 0);
        }
        // not found!
        return selectedPrimes2(num, x, nextPrime(currentPrime), 0);
    }

    // given methods for 2023a, 57, q1
    private static int nextPrime(int number) {
        int current = number + 1;
        while (true) {
            if (isPrime(current))
                return current;
            current++;
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }


    /* 2022b, 96, q1, for testing purposes:
        System.out.println("count = " + calc(3, 36, 4));
        System.out.println("count = " + calc(3, 36, 0));
        System.out.println("count = " + calc(36, 36, 0));
     */
    public static int calc(int num, int result, int maxOp) {
        return calc(num, result, maxOp, num, "");
    }

    private static int calc(int num, int result, int maxOp, int currentResult, String toPrint) {
        if (currentResult == result) { // good - we reached the result
            System.out.println(num + toPrint);
            return 1;
        }
        if (maxOp == 0) { // bad - we have no more operations left, and we didn't get the result
            return 0;
        }
        // check every operation: +, -, *, /
        int count = 0;
        count += calc(num, result, maxOp - 1, currentResult + num, toPrint + " + " + num);
        count += calc(num, result, maxOp - 1, currentResult - num, toPrint + " - " + num);
        count += calc(num, result, maxOp - 1, currentResult * num, toPrint + " * " + num);
        count += calc(num, result, maxOp - 1, currentResult / num, toPrint + " / " + num);
        return count;
    }


    /* 2023a, 65, q1, for testing purposes:
        System.out.println(countPairs(3));
     */
    public static int countPairs(int n) {
        return countPairs(n, n, "");
    }

    private static int countPairs(int left, int right, String toPrint) {
        // we stop when we are not able to put more brackets - when the right ones are all used.
        if (right == 0) {
            System.out.println(toPrint);
            return 1; // we found another valid expression
        }
        int count = 0;
        // put a left bracket
        if (left > 0)
            count += countPairs(left - 1, right, toPrint + "(");
        // put a right bracket
        if (left < right)
            count += countPairs(left, right - 1, toPrint + ")");
        return count;
    }


    /* 2022a, 67, q1(a+b), for testing purposes:
        int[][] mat = {
                {1, 2, 3, 2, 0, 1, 2},
                {0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {5, 0, 0, 1, 0, 0, 0},
                {7, 0, 0, 0, 1, 0, 0},
                {8, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(isIdentity(mat, 1, 4));
        System.out.println(isIdentity(mat, 1, 5));
        System.out.println(maxMatrix(mat));
     */
    public static boolean isIdentity(int[][] mat, int x, int size) {
        return isIdentity(mat, x, size, x, x);
    }

    private static boolean isIdentity(int[][] mat, int x, int size, int i, int j) {
        if ((i == j && mat[i][j] != 1) || (i != j && mat[i][j] != 0))
            return false;
        if (j < x + size - 1) // advance the column index
            return isIdentity(mat, x, size, i, j + 1);
        if (i < x + size - 1) // advance the row index
            return isIdentity(mat, x, size, i + 1, x);
        return true;
    }

    private static boolean isIdentityLoop(int[][] mat, int x, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = x; j < x + size; j++) {
                if ((i == j && mat[i][j] != 1) || (i != j && mat[i][j] != 0))
                    return false;
            }
        }
        return true;
    }

    //  2022a, 67, q1b
    public static int maxMatrix(int[][] mat) {
        return maxMatrix(mat, 0, mat.length);
    }

    private static int maxMatrix(int[][] mat, int x, int size) {
        if (size < 1) // there is no identity central matrix
            return -1;
        if (isIdentity(mat, x, size)) {
            return size;
        }
        return maxMatrix(mat, x + 1, size - 2); // continue with the next central matrix
    }

    private static int maxMatrixLoop(int[][] mat) {
        for (int size = mat.length, x = 0; size >= 1; size -= 2, x++) {
            if (isIdentityLoop(mat, x, size)) {
                return size;
            }
        }
        return -1;
    }


    /* 2023a, 92, q1 (special), for testing purposes:
        int[][] mat = {
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0}
        };
        System.out.println("number if 3friends = " + friends3(mat));
     */
    public static int friends3(int[][] mat) {
        return friends3(mat, 0, 1, 2, 0);
    }

    private static int friends3(int[][] mat, int i, int j, int k, int count) {
        int n = mat.length;
        // if we found 3 friends then we increment the counter and print them
        if (checkFriends3(mat, i, j, k)) {
            count++;
            System.out.println(i + " " + j + " " + k);
        }
        // update k, then j, then i
        if (k < n - 1)
            return friends3(mat, i, j, k + 1, count);
        if (j < n - 2)
            return friends3(mat, i, j + 1, j + 2, count);
        if (i < n - 3)
            return friends3(mat, i + 1, i + 2, i + 3, count);
        return count;
    }

    private static boolean checkFriends3(int[][] mat, int i, int j, int k) {
        // check that everybody knows each other
        return (mat[i][j] == 1) && (mat[i][k] == 1) && (mat[j][k] == 1);
    }

    private static int friends3Loop(int[][] mat) {
        int n = mat.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (checkFriends3(mat, i, j, k)) {
                        count++;
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        return count;
    }


    /* 2018b, 83, q1, for testing purposes:
        int[][] mat = {
                {2, 0, 1, 2, 3},
                {2, 3, 5, 5, 4},
                {8, -1, 6, 8, 7},
                {3, 4, 7, 2, 4},
                {2, 4, 3, 1, 2}
        };
        System.out.println(prince(mat, 0, 0));
     */
    public static int prince(int[][] drm, int i, int j) {
        return prince(drm, i, j, drm[i][j]);
    }

    private static int prince(int[][] drm, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= drm.length || j >= drm[0].length || drm[i][j] == -100) { // bad - we went out of bounds
            return -1;
        }
        if (drm[i][j] == -1) { // good - we reached the destination
            return 1;
        }
        if (!(prev - 2 <= drm[i][j] && drm[i][j] <= prev + 1)) { // bad - the prince made an illegal move
            return -1;
        }

        // change temporary the value of drm[i][j] - to prevent cycles in the path
        int temp = drm[i][j];
        drm[i][j] = -100;
        // check the 4 options and choose the lowest
        int option1 = prince(drm, i - 1, j, temp); // up
        int option2 = prince(drm, i + 1, j, temp); // down
        int option3 = prince(drm, i, j - 1, temp); // left
        int option4 = prince(drm, i, j + 1, temp); // right
        drm[i][j] = temp;

        return priceMin(option1, option2, option3, option4);
    }

    // return the min element that is not -1
    private static int priceMin(int a, int b, int c, int d) {
        if (a == -1 && b == -1 && c == -1 && d == -1)
            return -2;
        int best = Math.max(Math.max(a, b), Math.max(c, d));
        if (a >= 0)
            best = Math.min(best, a);
        if (b >= 0)
            best = Math.min(best, b);
        if (c >= 0)
            best = Math.min(best, c);
        if (d >= 0)
            best = Math.min(best, d);
        return best;
    }


    /* 2022b, 86, q1, for testing purposes:
        int[][] mat = {
                {12, 22, 23, 54, 11},
                {43, 35, 21, 20, 30},
                {34, 23, 43, 22, 30},
                {25, 31, 2, 20, 34},
                {10, 22, 10, 11, 10},
                {40, 13, 3, 1, 23}
        };
        System.out.println(maxPath(mat));
     */
    public static int maxPath(int[][] mat) {
        return maxPath(mat, 0, 0, 0);
    }

    private static int maxPath(int[][] mat, int i, int j, int pathValue) {
        if (i == mat.length - 1 && j == mat[0].length - 1) { // good - we reached the destination
            pathValue += mat[i][j];
            return pathValue;
        }
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) { // bad - we went out of bounds
            return Integer.MIN_VALUE;
        }

        // if the number is 38 then move1 = 3 and move2 = 8
        int move1 = mat[i][j] / 10;
        int move2 = mat[i][j] - 10 * move1;
        // check the 2 options and choose the highest
        int option1 = maxPath(mat, i + move1, j + move2, pathValue + mat[i][j]);
        int option2 = maxPath(mat, i + move2, j + move1, pathValue + mat[i][j]);
        return Math.max(option1, option2);
    }

    public static int maxPathWithPrint(int[][] mat) {
        return maxPathWithPrint(mat, 0, 0, 0, "");
    }

    private static int maxPathWithPrint(int[][] mat, int i, int j, int pathValue, String toPrint) {
        if (i == mat.length - 1 && j == mat[0].length - 1) { // good - we reached the destination
            pathValue += mat[i][j];
            System.out.println(toPrint + " -> (" + i + "," + j + ")");
            return pathValue;
        }
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) { // bad - we went out of bounds
            return Integer.MIN_VALUE;
        }

        // if the number is 38 then move1 = 3 and move2 = 8
        int move1 = mat[i][j] / 10;
        int move2 = mat[i][j] - 10 * move1;
        // check the 2 options and choose the highest
        String cur = " -> (" + i + "," + j + ")";
        int option1 = maxPathWithPrint(mat, i + move1, j + move2, pathValue + mat[i][j], toPrint + cur);
        int option2 = maxPathWithPrint(mat, i + move2, j + move1, pathValue + mat[i][j], toPrint + cur);
        return Math.max(option1, option2);
    }


    /* 2022b, 91, q1, for testing purposes:
            int[] stations = {2, 4, 8, 3, 10, 1, 12, 3, 2};
            System.out.println(cheapRt(stations, 3, 2, 4));
//          System.out.println(cheapRt(stations, 3, 6, 4));
     */
    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        return cheapRt(stations, step1, step2, limit, 0, 0, "");
    }

    private static int cheapRt(int[] stations, int step1, int step2, int limit, int i, int money, String toPrint) {
        if (i == stations.length - 1) { // good - we reached the destination station
            money += stations[i];
            System.out.println(toPrint + i + "\t= " + money);
            return money;
        }
        if (i >= stations.length) { // bad - we went past the destination station
            return Integer.MAX_VALUE;
        }

        int option1 = cheapRt(stations, step1, step2, limit, i + step1, money + stations[i], toPrint + i + "\t"); // take step1
        int option2 = Integer.MAX_VALUE;
        if (limit > 0) // take step2
            option2 = cheapRt(stations, step1, step2, limit - 1, i + step2, money + stations[i], toPrint + i + "\t");

        return Math.min(option1, option2);
    }


}

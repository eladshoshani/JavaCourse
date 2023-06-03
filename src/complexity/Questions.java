package complexity;


public class Questions {
    public static void main(String[] args) {
        int[] a = {35, 17, 13, 252, 4, 128, 7, 3, 81};
        Utils.printArray(a);
        sortmod(a, 10);
        Utils.printArray(a);
    }

    public static void sortmod(int[] a, int k) {
        int current = 0; // the sub array a[0..current] will always be k-modulo sorted
        for (int i = 0; i < k; i++) {
            for (int j = current; j < a.length; j++) {
                // put the block of all the i modulo elements in the beginning
                if (a[j] % k == i) {
                    Utils.swap(a, current, j); // swap a[current] and a[j]
                    current++;
                }
            }
        }
    }


    /* 2023a, 62, q2. For testing purposes:
        int[] a = {2, 3, 8, 27};
        System.out.println(superInc(a, 30)); // true because {3, 27}
        System.out.println(superInc(a, 7)); // false ({2,2,3} does not count)
     */
    public static boolean superInc(int[] a, int k) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] <= k) { // take the current a[i] for the subset
                k -= a[i];
            }
        }
        return k == 0; // if k == 0 then we created a subset as needed
    }

    // the following method does the same thing as above, but also prints the subset
    private static boolean superIncWithPrint(int[] a, int k) {
        String s = "{";
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] <= k) { // take the current a[i] for the subset
                k -= a[i];
                s += a[i] + ", ";
            }
        }
        if (k == 0) {
            System.out.println(s.substring(0, s.length() - 2) + "}");
            return true;
        }
        return false;
    }


    /* 2021a, 85, q2. For testing purposes:
        int[] a = {2, 3, 8, 14, 15, 35};
        System.out.println(findAverage(a, 8));
        System.out.println(findAverage(a, 2.5));
        System.out.println(findAverage(a, 10));
        System.out.println(findAverage(a, 8.5));
     */
    public static boolean findAverage(int[] a, double x) {
        int left = 0, right = a.length - 1;

        // Calculate the sum of all elements in the array
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        int size = a.length;
        // search for the subarray which his sum is equal to x
        while (size >= 1) {
            double average = ((double) sum) / size;
            if (average == x) {
                System.out.println(left + " --- " + right);
                return true;
            }
            if (average > x) {
                sum -= a[right];
                right--;
            } else {
                sum -= a[left];
                left++;
            }
            size--;
        }
        return false;
    }

    /* 2021b, 62, q2. For testing purposes:
        int[][] mat = {{1, 3, 7, 9}, {6, 4, 15, 11}, {36, 50, 21, 22}, {60, 55, 30, 26}};
        System.out.println(searchCircularMatrix(mat, 22));
        System.out.println(searchCircularMatrix(mat, 23));
     */
    public static boolean searchCircularMatrix(int[][] mat, int num) {
        int row = 0, col = 0; // left upper corner
        int n = mat.length; // length of square
        while (n > 1) {
            // we do not check square number 1 because we do not need to move the corner
            // check square number 2
            if (mat[row][col + n / 2] <= num && num <= mat[row + n / 2 - 1][col + n / 2]) {
                col = col + n / 2;
            }
            // check square number 3
            else if (mat[row + n / 2][col + n / 2] <= num && num <= mat[row + (n - 1)][col + n / 2]) {
                row = row + n / 2;
                col = col + n / 2;
            }
            // check square number 4
            else if (mat[row + n / 2][col] <= num && num <= mat[row + (n - 1)][col]) {
                row = row + n / 2;
            }
            n /= 2; // the edge of the matrix
        }
        // the square is of size 1 now
        if (mat[row][col] == num) {
            System.out.println("row = " + row + "\ncol = " + col);
            return true;
        }
        // the element is not in the matrix
        return false;
    }


    /* 2023a, 72, q2. For testing purposes:
        int[] a1 = {15, 20, 10, 5};
        int[] a2 = {10, 20, 15, 2, 23, 90, 67};
        int[] a3 = {10, 20, 15, 2, 90, 90, 67};
        int[] a4 = {1, 2, 3, 4, 5};

        System.out.println(findPeak(a1));
        System.out.println(findPeak(a2));
        System.out.println(findPeak(a3));
        System.out.println(findPeak(a4));
     */
    public static int findPeak(int[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // check if mid is a peak
            if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == a.length - 1 || a[mid] >= a[mid + 1]))
                return mid;
            // continue searching target in half of the array
            if (mid > 0 && a[mid] < a[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1; // not possible
    }


}

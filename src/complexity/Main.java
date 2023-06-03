package complexity;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int[] a = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int[] a = {30, 8, 5, 6, 1, 7, 9, 13};
        Utils.printArray(a);
        Sorting.insertionSort(a);
        Utils.printArray(a);

//        System.out.println(binarySearch(a, 16));
    }

    public static boolean fff(int[] a, int z) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == z)
                        return true;
                }
            }
        }
        return false;
    }


    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            // continue searching target in half of the array
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }


    // Function to find a pair in the given
    // array whose sum is equal to z
    public static boolean findPair(int[] a, int z) {
        int n = a.length;
        // Iterate through all the pairs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the sum of the pair
                // (a[i], a[j]) is equal to z
                if (i != j && a[i] + a[j] == z)
                    return true;
            }
        }
        return false;
    }

    /**
     * Given a sorted array of integers nums and a target value z,
     * finds a pair of numbers in the array that add up to z and returns their indices.
     * If no such pair exists, returns null.
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int[] findPairSorted(int[] nums, int z) {
        // Initialize two pointers, left and right
        int left = 0;
        int right = nums.length - 1;
        // Loop through the array while the left pointer is less than the right pointer
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If the sum equals the target value z, we found a pair of numbers that add up to z
            if (sum == z)
                return new int[]{left, right};
            // now according to the sum, we advance one of the pointers:
            if (sum < z)
                left++;
            else
                right--;

        }
        // If we finish the loop without finding a pair then there is no pair, return null
        return null;
    }


}

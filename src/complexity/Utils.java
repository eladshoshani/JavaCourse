package complexity;

import java.util.Arrays;

public class Utils {

    public static void main(String[] args) {
        String[] a = {"viwbsvs", "svbsc", "wvvw32"};
        int[][] mat = {{1, 3, 7, 9}, {6, 4, 15, 11}, {36, 50, 21, 22}, {60, 55, 30, 26}};
        printArray(a);
        printMatrix(mat);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(boolean[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(boolean[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printMatrix(float[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static <T> void printMatrix(T[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

    }

}

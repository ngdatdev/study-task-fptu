package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Algorithm {

    private int[] arrays;
    private final boolean isSort;

    public int[] getArrays() {
        return (arrays == null) ? null : arrays.clone();
    }

    public Algorithm(int sizeArrays) {
        this.isSort = false;
        generateRandomArrays(sizeArrays);
    }

    public int[] bubbleSort() {
        int[] newArrays = getArrays().clone();
        for (int i = 0; i < newArrays.length - 1; i++) {
            for (int j = 0; j < newArrays.length - 1 - i; j++) {
                if (newArrays[j] > newArrays[j + 1]) {
                    swap(newArrays, j, j + 1);
                }
            }
        }
        return newArrays;
    }

    public int[] quickSort() {
        int[] newArrays = getArrays().clone();
        quickSort(newArrays, 0, newArrays.length - 1);
        return newArrays;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; //-1
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);

        return i + 1;
    }

    public final int[] generateRandomArrays(int sizeArrays) {
        Random r = new Random();
        arrays = new int[sizeArrays];
        for (int i = 0; i < sizeArrays; i++) {
            arrays[i] = r.nextInt(50);
        }
        return arrays.clone();
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int linearSearch(int key) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int key) {
        int[] arr = bubbleSort();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Algorithm a = new Algorithm(10);
        System.out.println(Arrays.toString(a.getArrays()));
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.println(a.binarySearch(key));
    }

}

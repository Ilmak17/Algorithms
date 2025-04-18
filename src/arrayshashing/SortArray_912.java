package arrayshashing;

/*
 * LeetCode Problem 912: Sort an Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers nums, sort the array in ascending order and return it.
 */

import java.util.Random;

public class SortArray_912 {
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }

    public int partition(int[] arr, int low, int high) {
        int randomIndex = low + new Random().nextInt(high - low + 1);
        int temp = arr[low];
        arr[low] = arr[randomIndex];
        arr[randomIndex] = temp;

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }
        }

        int temp3 = arr[low];
        arr[low] = arr[j];
        arr[j] = temp3;
        return j;
    }

    public void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pIndex - 1);
            quickSortHelper(arr, pIndex + 1, high);
        }
    }

    public int[] quickSort(int[] nums) {
        int n = nums.length;

        quickSortHelper(nums, 0, n - 1);

        return nums;
    }
}

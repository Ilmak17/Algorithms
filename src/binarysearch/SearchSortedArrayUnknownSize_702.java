package binarysearch;

/*
 * LeetCode Problem 702: Search in a Sorted Array of Unknown Size
 * Difficulty: Medium
 *
 * Problem Statement:
 * This is an interactive problem.
 * You have a sorted array of unique elements and an unknown size. You do not have
 * an access to the array but you can use the ArrayReader interface to access it.
 * You can call ArrayReader.get(i) that:
 * returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
 * returns 231 - 1 if the i is out of the boundary of the array.
 * You are also given an integer target.
 * Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
 * You must write an algorithm with O(log n) runtime complexity.
 */

interface ArrayReader {
    int get(int index);
}

public class SearchSortedArrayUnknownSize_702 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

package arrayshashing;

/*
 * LeetCode Problem 1352: Product of the Last K Numbers
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.
 * Implement the ProductOfNumbers class:
 * ProductOfNumbers() Initializes the object with an empty stream.
 * void add(int num) Appends the integer num to the stream.
 * int getProduct(int k) Returns the product of the last k numbers in the current list.
 * You can assume that always the current list has at least k numbers.
 * The test cases are generated so that, at any time,
 *  the product of any contiguous sequence of numbers will fit into
 *  a single 32-bit integer without overflowing.
 */

import java.util.ArrayList;
import java.util.List;

public class ProductLastKNumbers_1352 {
    private final List<Integer> prefixProduct;
    private int lastZeroIndex;

    public ProductLastKNumbers_1352() {
        this.prefixProduct = new ArrayList<>();
        this.prefixProduct.add(1);
        this.lastZeroIndex = -1;
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct.clear();
            prefixProduct.add(1);
            lastZeroIndex = prefixProduct.size() - 1;
        } else {
            int lastProduct = prefixProduct.get(prefixProduct.size() - 1);
            prefixProduct.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProduct.size();
        if (k >= size - lastZeroIndex) {
            return 0;
        }
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }
}

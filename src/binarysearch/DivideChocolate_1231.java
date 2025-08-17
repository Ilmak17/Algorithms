package binarysearch;

/*
 * LeetCode Problem 1231: Divide Chocolate
 * Difficulty: Hard
 *
 * Problem Statement:
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 * You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces
 *  using k cuts, each piece consists of some consecutive chunks.
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 */

public class DivideChocolate_1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        int sum = 0;
        for (int s : sweetness) sum += s;

        int people = k + 1;
        int low = 1;
        int high = sum / people;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeAtLeast(sweetness, mid, people)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean canMakeAtLeast(int[] arr, int target, int needPieces) {
        int count = 0;
        long cur = 0;
        for (int el : arr) {
            cur += el;
            if (cur >= target) {
                count++;
                cur = 0;
                if (count >= needPieces) return true;
            }
        }
        return false;
    }

}

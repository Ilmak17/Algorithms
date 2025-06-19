import tree.TreeNode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(test.maximumSwap(5999));

    }

    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();

        int cur = num;
        while (cur != 0) {
            list.add(cur % 10);
            cur /= 10;
        }
        int[] max = new int[2];
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) >= max[0]) {
                max[0] = list.get(i);
                max[1] = i;
            }
        }

        int tmp = list.get(list.size() - 1);
        list.set(list.size() - 1, max[0]);
        list.set(max[1], tmp);

        int res = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            res = res * 10 + list.get(i);
        }

        return res;
    }


}

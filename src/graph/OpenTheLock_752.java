package graph;

/*
 * LeetCode Problem 752: Open the Lock
 * Difficulty: Medium
 *
 * Problem Statement:
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around:
 * for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 *  the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000"))
            return -1;

        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair("0000", 0));
        visited.add("0000");

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            String curLock = cur.word;
            int steps = cur.steps;

            if (curLock.equals(target))
                return steps;

            for (int i = 0; i < 4; i++) {
                char[] chs = curLock.toCharArray();

                chs[i] = (char) ((chs[i] - '0' + 1) % 10 + '0');
                String up = new String(chs);
                if (!set.contains(up) && visited.add(up)) {
                    queue.add(new Pair(up, steps + 1));
                }

                chs = curLock.toCharArray();
                chs[i] = (char) ((chs[i] - '0' + 9) % 10 + '0');
                String down = new String(chs);
                if (!set.contains(down) && visited.add(down)) {
                    queue.add(new Pair(down, steps + 1));
                }
            }
        }

        return -1;
    }
}

package greedy;

/*
 * LeetCode Problem 649: Dota2 Senate
 * Difficulty: Medium
 *
 * Problem Statement:
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in
 * the Dota2 game. The voting for this change is a round-based procedure. In each round,
 *  each senator can exercise one of the two rights:
 * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party,
 *  he can announce the victory and decide on the change in the game.
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent
 * the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.
 * The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting. All the senators who have lost their rights will be skipped
 * during the procedure.
 * Suppose every senator is smart enough and will play the best strategy for his own party.
 *  Predict which party will finally announce the victory and change the Dota2 game. The output should be
 * "Radiant" or "Dire".
 */

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate_649 {
    private static final String RADIANT = "Radiant";
    private static final String DIRE = "Dire";

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiant = radiantQueue.poll();
            int dire = direQueue.poll();

            if (radiant < dire) {
                radiantQueue.add(radiant + n);
            } else {
                direQueue.add(dire + n);
            }
        }

        return radiantQueue.isEmpty() ? DIRE : RADIANT;
    }
}

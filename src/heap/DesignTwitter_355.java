package heap;

/*
 * LeetCode Problem 355: Design Twitter
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 *  and is able to see the 10 most recent tweets in the user's news feed.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter_355 {

    private static int timestamp = 0;
    private final Map<Integer, List<Tweet>> tweets;
    private final Map<Integer, Set<Integer>> followers;

    public DesignTwitter_355() {
        this.tweets = new HashMap<>();
        this.followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    maxHeap.addAll(tweets.get(followeeId));
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll().tweetId);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    private static class Tweet {
        int tweetId;
        int timestamp;

        public Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}

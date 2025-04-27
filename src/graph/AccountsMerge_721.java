package graph;

/*
 * LeetCode Problem 721: Accounts Merge
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0]
 * is a name, and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person
 * if there is some common email to both accounts. Note that even if two accounts have the same name,
 *  they may belong to different people as people could have the same name.
 *  A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format:
 * the first element of each account is the name, and the rest of the elements are emails in sorted order.
 * The accounts themselves can be returned in any order.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> emailsToNode = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailsToNode.containsKey(email)) {
                    emailsToNode.put(email, i);
                } else {
                    uf.union(i, emailsToNode.get(email));
                }
            }
        }

        Map<Integer, List<String>> mergedEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailsToNode.entrySet()) {
            String email = entry.getKey();
            int node = entry.getValue();
            int parentNode = uf.find(node);

            mergedEmails.computeIfAbsent(parentNode, k -> new ArrayList<>())
                    .add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : mergedEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0));
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
    }
}

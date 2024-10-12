package trie;

/*
 * LeetCode Problem 208: Implement Trie (Prefix Tree)
 * Difficulty: Medium
 *
 * Problem Statement:
 * Implement a trie with insert, search, and startsWith methods.
 *
 * - insert(word): Inserts the string word into the trie.
 * - search(word): Returns true if the string word is in the trie.
 * - startsWith(prefix): Returns true if there is any string in the trie that starts with the given prefix.
 */

public class ImplementTrie_208 {
    private final TrieNode root;

    public ImplementTrie_208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;

        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }

        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                return false;
            }
            cur = cur.children[ch - 'a'];
        }

        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                return false;
            }
            cur = cur.children[ch - 'a'];
        }

        return true;
    }
}

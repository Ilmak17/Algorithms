package trie;

/*
 * LeetCode Problem 211: Design Add and Search Words Data Structure
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design a data structure that supports adding new words and
 * searching for words where a dot ('.') can represent any letter.
 */

public class AddAndSearchWord_211 {
    private final TrieNode root;

    public AddAndSearchWord_211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isEnd;

        char ch = word.charAt(index);

        if (ch == '.') {
            for (TrieNode children : node.children) {
                if (children != null && searchInNode(word, index + 1, children)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            return searchInNode(word, index + 1, node.children[ch - 'a']);
        }
    }
}

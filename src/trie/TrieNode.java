package trie;

public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;

    public TrieNode() {}
}
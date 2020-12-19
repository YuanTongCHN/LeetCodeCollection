package indi.yuantongchn.LC208;

//208. 实现 Trie (前缀树)

import java.util.HashMap;

class Trie {
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();;
        boolean isEnd = false;
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.map.containsKey(c)){
                cur = cur.map.get(c);
            }else{
                cur.map.put(c, new TrieNode());
                cur = cur.map.get(c);
            }
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if(!cur.map.containsKey(c)) {
                return false;
            }else{
                cur = cur.map.get(c);
            }
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if(!cur.map.containsKey(c)) {
                return false;
            }else{
                cur = cur.map.get(c);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

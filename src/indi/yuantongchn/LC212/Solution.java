package indi.yuantongchn.LC212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new ArrayList<>();
        int row = board.length;
        if (row == 0) {
            return res;
        }
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matchWord(board, trie.root, i, j, row, col, res);
            }
        }
        return res;
    }

    private void matchWord(char[][] board, Trie.TrieNode trieNode, int i, int j, int row, int col, List<String> res) {
        if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '$') {
            return ;
        }
        char temp = board[i][j];
        if (!trieNode.nextNodes.containsKey(temp)) {
            return;
        }
        trieNode = trieNode.nextNodes.get(temp);
        if (trieNode.word != null) {
            res.add(trieNode.word);
            trieNode.word = null; //防止重复加入
        }
        board[i][j] = '$';
        matchWord(board, trieNode, i - 1, j, row, col, res);
        matchWord(board, trieNode, i + 1, j, row, col, res);
        matchWord(board, trieNode, i, j + 1, row, col, res);
        matchWord(board, trieNode, i, j - 1, row, col, res);
        board[i][j] = temp;
    }
}

class Trie {
    class TrieNode {
        HashMap<Character, TrieNode> nextNodes = new HashMap<>();
        String word = null;
    }
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public void insert(String str){
        TrieNode cur = root;
        for (char c : str.toCharArray()) {
            if(!cur.nextNodes.containsKey(c)){
                cur.nextNodes.put(c, new TrieNode());
            }
            cur = cur.nextNodes.get(c);
        }
        cur.word = str;
    }
}
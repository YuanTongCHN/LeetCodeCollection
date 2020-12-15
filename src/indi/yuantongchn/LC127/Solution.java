package indi.yuantongchn.LC127;

//127. 单词接龙

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(beginWord);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String curStr = queue.poll();
                boolean isMatch = changeOneWord(curStr, endWord, wordSet, visited, queue);
                if (isMatch) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean changeOneWord(String curStr, String endWord, Set<String> wordSet, Set<String> visited, LinkedList<String> queue) {
        char[] charList = curStr.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            char originChar = charList[i];
            for (char k = 'a'; k <= 'z'; k++) {
                charList[i] = k;
                String tempStr = new String(charList);
                if (wordSet.contains(tempStr)) {
                    if (tempStr.equals(endWord)) {
                        return true;
                    } else if (!visited.contains(tempStr)) {
                        visited.add(tempStr);
                        queue.addLast(tempStr);
                    }
                }
            }
            charList[i] = originChar;
        }
        return false;
    }
}

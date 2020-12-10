package indi.yuantongchn.LC8;

//8. 字符串转整数

class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        char[] wordList = s.toCharArray();
        int index = 0;
        while (index < len && wordList[index] == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        if (wordList[index] == '+') {
            index++;
        } else if (wordList[index] == '-') {
            sign = -1;
            index++;
        } else if (wordList[index] > '9' || wordList[index] < '0') {
            return 0;
        }
        int res = 0;
        while (index < len && wordList[index] <= '9' && wordList[index] >= '0') {
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && wordList[index] - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && wordList[index] - '0' > -(Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + (wordList[index] - '0') * sign;
            index++;
        }
        return res;
    }
}

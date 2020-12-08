package indi.yuantongchn.LC13;

//13. 罗马数字转整数

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] charList = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        int preNum = map.get(charList[0]);
        for (int i = 1; i < charList.length; i++) {
            int curNum = map.get(charList[i]);
            if (curNum > preNum) {
                res -= preNum; //如果前一个数字小于后一个 前一个数字设为负值
            } else {
                res += preNum;
            }
            preNum = curNum;
        }
        res += preNum;
        return res;
    }
}

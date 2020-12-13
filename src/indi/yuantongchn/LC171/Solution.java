package indi.yuantongchn.LC171;

import java.util.HashMap;

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }

    /*//哈希表，不好
    public int titleToNumber2(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> keyValuePairs = new HashMap<>();
        keyValuePairs.put('A', 1);
        keyValuePairs.put('B', 2);
        keyValuePairs.put('C', 3);
        keyValuePairs.put('D', 4);
        keyValuePairs.put('E', 5);
        keyValuePairs.put('F', 6);
        keyValuePairs.put('G', 7);
        keyValuePairs.put('H', 8);
        keyValuePairs.put('I', 9);
        keyValuePairs.put('J', 10);
        keyValuePairs.put('K', 11);
        keyValuePairs.put('L', 12);
        keyValuePairs.put('M', 13);
        keyValuePairs.put('N', 14);
        keyValuePairs.put('O', 15);
        keyValuePairs.put('P', 16);
        keyValuePairs.put('Q', 17);
        keyValuePairs.put('R', 18);
        keyValuePairs.put('S', 19);
        keyValuePairs.put('T', 20);
        keyValuePairs.put('U', 21);
        keyValuePairs.put('V', 22);
        keyValuePairs.put('W', 23);
        keyValuePairs.put('X', 24);
        keyValuePairs.put('Y', 25);
        keyValuePairs.put('Z', 26);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + keyValuePairs.get(s.charAt(i));
        }
        return res;
    }*/
}

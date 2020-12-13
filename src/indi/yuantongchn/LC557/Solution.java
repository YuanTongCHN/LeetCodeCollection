package indi.yuantongchn.LC557;

class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        StringBuffer res = new StringBuffer();
        int fast = 0;
        int slow = 0;
        while(fast <= len){
            while(fast < len && s.charAt(fast) != ' '){
                fast++;
            }
            String temp =  reverse(s,slow,fast);
            res.append(temp).append(" ");
            fast++;
            slow = fast;
        }
        return res.toString().trim();
    }

    private String reverse(String s, int slow, int fast) {
        StringBuffer str = new StringBuffer();
        for(int i = fast - 1; i >= slow; i--){
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}

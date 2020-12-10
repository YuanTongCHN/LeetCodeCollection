package indi.yuantongchn.LC7;

class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int res = 0;
        while(x != 0){
            int unit = x % 10;
            x = x / 10;
            if(res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && unit > Integer.MAX_VALUE % 10){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && unit < Integer.MIN_VALUE % 10){
                return 0;
            }
            res = res * 10 + unit;
        }
        return res;
    }
}

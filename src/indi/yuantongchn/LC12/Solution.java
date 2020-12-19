package indi.yuantongchn.LC12;

//12. 整数转罗马数字

class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuffer res = new StringBuffer();
        while(index < 13) {
            while(num >= nums[index]){
                res.append(str[index]);
                num -= nums[index];
            }
            index++;
        }
        return res.toString();
    }
}

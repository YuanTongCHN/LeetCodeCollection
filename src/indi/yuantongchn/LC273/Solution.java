package indi.yuantongchn.LC273;

//273. 整数转换英文表示

import java.util.HashMap;

class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int billion = num / 1000000000;
        num = num % 1000000000;
        int million = num / 1000000;
        num = num % 1000000;
        int thousand = num / 1000;
        num = num % 1000;
        StringBuffer str = new StringBuffer();
        if(billion!=0){
            str.append(three(billion)).append(" Billion ");
        }
        if(million!=0){
            str.append(three(million)).append(" Million ");
        }
        if(thousand!=0){
            str.append(three(thousand)).append(" Thousand ");
        }
        str.append(three(num));
        return str.toString().trim();
    }

    private String one(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private String twoLessThan20(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

    private String two(int num) {
        if(num == 0){
            return "";
        }else if (num < 10) {
            return one(num);
        }else if(num < 20){
            return twoLessThan20(num);
        }else{
            int tens = num / 10;
            int units = num % 10;
            StringBuffer str = new StringBuffer();
            str.append(ten(tens)).append(" ").append(one(units));
            return str.toString().trim();
        }
    }

    private String three(int num){
        int hundred = num / 100;
        int rest = num % 100;
        StringBuffer str = new StringBuffer();
        if(hundred != 0){
            str.append(one(hundred)).append(" Hundred ");
        }
        str.append(two(rest));
        return str.toString().trim();
    }
}

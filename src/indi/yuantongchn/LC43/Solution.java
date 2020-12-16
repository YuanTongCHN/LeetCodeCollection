package indi.yuantongchn.LC43;

//43. 字符串相乘

/*class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            int jump = 0;
            StringBuffer temp = new StringBuffer();
            for (int j = len1 - 1; j > i; j--) {
                temp.append("0");
            }
            for (int j = len2 - 1; j >=0 ; j--) {
                int y = num2.charAt(j) - '0';
                int number = x * y + jump;
                temp.append(number % 10);
                jump = number / 10;
            }
            while (jump != 0) {
                temp.append(jump % 10);
                jump = jump / 10;
            }
            res = addString(res, temp.reverse().toString());
        }
        return res;
    }

    private String addString(String str1, String str2) {
        StringBuffer res = new StringBuffer();
        int i1 = str1.length() - 1;
        int i2 = str2.length() - 1;
        int jump = 0;
        while (i1 >= 0 || i2 >= 0|| jump > 0) {
            int x = i1 >= 0 ? str1.charAt(i1) - '0' : 0;
            int y = i2 >= 0 ? str2.charAt(i2) - '0' : 0;
            int sum = x + y + jump;
            res.append(sum % 10);
            jump = sum / 10;
            i1--;
            i2--;
        }
        return res.reverse().toString();
    }
}*/

class Solution {
    public String multiply(String num1, String num2)    {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int resLen = len1 + len2;
        int[] res = new int[resLen];
        for (int i = 0; i < len1; i++) {
            int x = num1.charAt(i) - '0';
            for (int j = 0; j < len2; j++) {
                int y = num2.charAt(j) - '0';
                int muti = x * y;
                int index = i + j + 1;
                while(muti != 0){
                    res[index] += muti % 10;
                    muti /= 10;
                    index--;
                }
            }
        }
        int jump = 0;
        for (int i = resLen - 1; i >= 0 ; i--) {
            int sum = jump + res[i];
            res[i] = sum % 10;
            jump = sum / 10;
        }
        int index = 0;
        StringBuffer ans = new StringBuffer();
        while (res[index] == 0){
            index++;
        }
        while(index < resLen){
            ans.append(res[index]);
            index++;
        }
        return ans.toString();
    }
}

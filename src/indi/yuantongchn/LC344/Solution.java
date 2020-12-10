package indi.yuantongchn.LC344;

//344. 反转字符串

class Solution {
    public void reverseString(char[] s) {
        if(s.length < 2){
            return;
        }
        int indexL = 0;
        int indexR = s.length - 1;
        while(indexL < indexR){
            Swap(s, indexL,indexR);
            indexL++;
            indexR--;
        }
    }

    private void Swap(char[] s, int indexL, int indexR) {
        char temp = s[indexL];
        s[indexL] = s[indexR];
        s[indexR] = temp;
    }
}

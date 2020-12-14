package indi.yuantongchn.LC277;

//277. 搜寻名人

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

import javax.management.relation.Relation;

/*public class Solution extends Relation {
    public int findCelebrity(int n) {
        //先钦定i为候选人
        int i = 0;
        //用i遍历所有人
        for (int j = 1; j < n; j++) {
            //如果i认识j，则i不是候选人，换j为候选人
            //如果i不认识j，则j不是候选人
            if(knows(i, j)){
                i = j;
            }
        }
        //因为最多只有一个名人，所以目前的i是唯一候选人，判断其是否名人即可
        for (int j = 0; j < n; j++) {
            if(j == i){
                continue;
            }
            if(knows(i,j)){
                return -1;
            }
            if(!knows(j,i)){
                return -1;
            }
        }
        return i;
    }
}*/

/*
//双指针
public class Solution extends Relation {
    public int findCelebrity(int n) {
        //双指针
        int i = 0;
        int j = n - 1;
        while(i != j){
            if (knows(i, j)){
                //如果i认识j，则i不是名人，下一个
                i++;
            }else {
                //如果i不认识j，则j不是名人，下一个
                j--;
            }
        }
        //由于最多只有一个名人，则此时的i为唯一候选人
        for (int k = 0; k < n; k++) {
            if(k == i){
                continue;
            }
            if(knows(i,k)){
                return -1;
            }
            if (!knows(k,i)){
                return -1;
            }
        }
        return i;
    }
}*/

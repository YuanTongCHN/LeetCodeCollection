package indi.yuantongchn.LC165;

import java.security.KeyPair;

class Solution {

    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i1 = 0;
        int i2 = 0;
        while (i1 < len1 || i2 < len2) {
            int[] pair1 = getNum(version1, len1, i1);
            int[] pair2 = getNum(version2, len2, i2);
            int num1 = pair1[1];
            int num2 = pair2[1];
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }
            i1 = pair1[0] + 1;
            i2 = pair2[0] + 1;
        }
        return 0;
    }

    private int[] getNum(String str, int len, int i) {
        if (i >= len) {
            return new int[]{len, 0};
        }
        int start = i;
        while (i < len && str.charAt(i) != '.') {
            i++;
        }
        int end = i;
        int num;
        if (start == end) {
            num = 0;
        } else {
            num = Integer.parseInt(str.substring(start, end));
        }
        return new int[]{end, num};
    }

    /*
    //时间空间复杂度不好
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (index1 < len1 && index2 < len2) {
            int num1 = Integer.parseInt(nums1[index1]);
            int num2 = Integer.parseInt(nums2[index2]);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            index1++;
            index2++;
        }
        if (len1 == len2) {
            return 0;
        }
        if (index1 == len1) {
            while(index2 < len2){
                if(Integer.parseInt(nums2[index2]) > 0){
                    return -1;
                }
                index2++;
            }
            return 0;
        }
        if (index2 == len2) {
            while(index1 < len1){
                if(Integer.parseInt(nums1[index1]) > 0){
                    return 1;
                }
                index1++;
            }
            return 0;
        }
        return 0;
    }*/

}


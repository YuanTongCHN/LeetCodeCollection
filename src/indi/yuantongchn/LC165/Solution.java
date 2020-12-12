package indi.yuantongchn.LC165;

class Solution {
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
    }
}

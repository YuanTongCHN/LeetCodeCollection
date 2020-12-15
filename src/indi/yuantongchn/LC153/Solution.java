package indi.yuantongchn.LC153;

//153. 寻找旋转排序数组中的最小值

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] < nums[right]){//先判断没有旋转的情况
            return nums[0];
        }
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] >= nums[0]){//等号很关键
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}

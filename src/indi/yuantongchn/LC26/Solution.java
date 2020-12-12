package indi.yuantongchn.LC26;

//26. 删除排序数组中的重复项

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        //双指针
        int fast = 0;
        int slow = 0;
        while(fast < len){
            if(nums[fast] == nums[slow]){
                fast++;
            }else{
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;
    }
}

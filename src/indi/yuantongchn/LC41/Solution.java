package indi.yuantongchn.LC41;

//41. 缺失的第一个正数

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            //第三个判定好好理解
            /*
            nums[nums[i] - 1] 为 nums[i] 应该在的位置的值
            如果该值不等于num[i]
            则交换，使该值等于nums[i]
            并继续判断交换后的nums[i]对应的位置的值nums[nums[i] - 1]
            * */
            while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

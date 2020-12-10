package indi.yuantongchn.LC75;

//75. 颜色分类

class Solution {

    /*
     * [zero, i) == 0
     * [i, two) == 1
     * [two, len - 1] == 2
     * */
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int zero = 0;
        int i = 0;
        int two = nums.length; //保证闭区间一开始不包含元素
        while (i < two) {
            if (nums[i] == 0) {
                Swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                Swap(nums, i, two);
            }
        }
        return;
    }

    private void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

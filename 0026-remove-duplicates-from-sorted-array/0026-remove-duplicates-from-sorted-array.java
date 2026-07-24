class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){

                i++;

                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
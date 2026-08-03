class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int l = 0;
        int r = n - 1;
        int index = n - 1;

        while( l <= r){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                ans[index] = nums[l] * nums[l];
                l++;
            }
            else{
                ans[index] = nums[r] * nums[r];
                r--;
            }
            index--;
        }
        return ans;
    }
}
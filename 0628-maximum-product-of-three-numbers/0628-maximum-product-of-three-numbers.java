class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        // Product of three largest numbers
        int sum1 = nums[n-1] * nums[n - 2] * nums[n - 3];

        // Product of two smallest and the largest number
        int sum2 = nums[0] * nums [1] * nums[n-1];

        // return maximum product
        return Math.max(sum1, sum2);
    }
}
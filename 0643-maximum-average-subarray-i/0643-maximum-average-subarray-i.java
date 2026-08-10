class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // Calculate sum of first window
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {

            // Remove element leaving the window
            sum -= nums[i - k];

            // Add new element entering the window
            sum += nums[i];

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
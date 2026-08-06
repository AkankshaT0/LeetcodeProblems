class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // Left pointer of the sliding window
        int l = 0;

        // Stores the sum of the current window
        int sum = 0;

        // Stores the minimum length of a valid subarray
        // Initialize with a very large value
        int ans = Integer.MAX_VALUE;

        // Expand the window by moving the right pointer
        for (int r = 0; r < nums.length; r++) {

            // Add the current element to the window sum
            sum += nums[r];

            // Shrink the window while its sum is greater than or equal to target
            while (sum >= target) {

                // Update the minimum subarray length
                ans = Math.min(ans, r - l + 1);

                // Remove the leftmost element from the window
                sum -= nums[l];

                // Move the left pointer forward
                l++;
            }
        }

        // If no valid subarray was found, return 0
        // Otherwise, return the minimum length
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
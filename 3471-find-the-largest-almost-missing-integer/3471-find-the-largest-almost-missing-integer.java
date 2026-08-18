import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            int maxVal = -1;
            for (int num : nums) maxVal = Math.max(maxVal, num);
            return maxVal;
        }
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) counts.put(num, counts.getOrDefault(num, 0) + 1);
        
        if (k == 1) {
            int maxVal = -1;
            for (int num : counts.keySet()) {
                if (counts.get(num) == 1) maxVal = Math.max(maxVal, num);
            }
            return maxVal;
        }
        
        int result = -1;
        if (counts.get(nums[0]) == 1) result = Math.max(result, nums[0]);
        if (counts.get(nums[n - 1]) == 1) result = Math.max(result, nums[n - 1]);
        return result;
    }
}

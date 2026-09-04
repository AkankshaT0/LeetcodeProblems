import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        // Store all possible permutations
        List<List<Integer>> ans = new ArrayList<>();

        // Stores the permutation currently being built
        List<Integer> current = new ArrayList<>();

        // used[i] = true means nums[i] is already selected
        boolean[] used = new boolean[nums.length];

        // Start the backtracking process
        backtrack(nums, used, current, ans);

        return ans;
    }

    private void backtrack(int[] nums,
                           boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Base case:
        // If current contains all elements,
        // we have formed one complete permutation
        if (current.size() == nums.length) {

            // Add a copy of current to the answer
            ans.add(new ArrayList<>(current));

            return;
        }

        // Try every element as the next element
        for (int i = 0; i < nums.length; i++) {

            // Skip the element if it is already used
            if (used[i]) {
                continue;
            }

            // ---------------- CHOOSE ----------------

            // Add the current number to the permutation
            current.add(nums[i]);

            // Mark this number as used
            used[i] = true;

            // ---------------- EXPLORE ----------------

            // Recursively choose the next number
            backtrack(nums, used, current, ans);

            // ---------------- BACKTRACK ----------------

            // Remove the last selected number
            // so we can try another possibility
            current.remove(current.size() - 1);

            // Mark the number as unused again
            used[i] = false;
        }
    }
}
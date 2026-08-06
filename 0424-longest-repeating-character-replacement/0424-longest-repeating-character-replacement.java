class Solution {
    public int characterReplacement(String s, int k) {

        // Frequency array to store count of each uppercase letter (A-Z)
        int[] freq = new int[26];

        // Left pointer of the sliding window
        int left = 0;

        // Stores the highest frequency of any character in the current window
        int maxFreq = 0;

        // Stores the maximum valid window length found so far
        int maxLength = 0;

        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {

            // Include the current character in the window
            freq[s.charAt(right) - 'A']++;

            // Update the maximum frequency in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If more than k replacements are needed,
            // shrink the window from the left
            while ((right - left + 1) - maxFreq > k) {

                // Remove the leftmost character from the window
                freq[s.charAt(left) - 'A']--;

                // Move the left pointer forward
                left++;
            }

            // Update the answer with the largest valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the length of the longest valid substring
        return maxLength;
    }
}
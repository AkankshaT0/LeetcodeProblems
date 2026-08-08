class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer, its permutation can't fit inside s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency array for s1
        int[] need = new int[26];

        // Frequency array for current window in s2
        int[] window = new int[26];

        // Store frequency of characters in s1
        for (char ch : s1.toCharArray()) {
            need[ch - 'a']++;
        }

        int k = s1.length(); // Fixed window size

        // Traverse s2
        for (int i = 0; i < s2.length(); i++) {

            // Add current character to the window
            window[s2.charAt(i) - 'a']++;

            // If window size becomes greater than k,
            // remove the leftmost character
            if (i >= k) {
                window[s2.charAt(i - k) - 'a']--;
            }

            // Compare both frequency arrays
            // If equal, current window is a permutation of s1
            if (isSame(need, window)) {
                return true;
            }
        }

        // No permutation found
        return false;
    }

    // Compare two frequency arrays
    private boolean isSame(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) {
                return false;
            }
        }
        return true;
    }
}
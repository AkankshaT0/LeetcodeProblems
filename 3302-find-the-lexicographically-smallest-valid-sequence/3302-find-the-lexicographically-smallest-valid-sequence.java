class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];

        // Find how many characters from the END of word2
        // can be matched in word1[i...]
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int p = 0;
        boolean changed = false;

        for (int i = 0; i < n && p < m; i++) {

            // Normal matching
            if (word1.charAt(i) == word2.charAt(p)) {
                ans[p] = i;
                p++;
            }

            // Use the one allowed modification
            else if (!changed) {

                // Number of characters still needed
                int remaining = m - p - 1;

                // Can the remaining characters be matched
                // after choosing index i?
                if (suf[i + 1] >= remaining) {
                    ans[p] = i;
                    p++;
                    changed = true;
                }
            }
        }

        if (p != m) {
            return new int[0];
        }

        return ans;
    }
}
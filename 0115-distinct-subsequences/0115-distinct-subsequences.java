class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        // dp[i][j] = number of ways to form
        // t[0...j-1] using s[0...i-1]
        long[][] dp = new long[m + 1][n + 1];

        // Empty t can be formed in exactly 1 way
        // by deleting all characters from s.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Empty s cannot form a non-empty t
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Option 1: Don't take s[i-1]
                dp[i][j] = dp[i - 1][j];

                // Option 2: Take s[i-1] if it matches t[j-1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return (int) dp[m][n];
    }
}
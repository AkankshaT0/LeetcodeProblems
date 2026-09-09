class Solution {
    public long countCommas(long n) {
        long ans = 0;

        // Comma positions: 1,000 ; 1,000,000 ; 1,000,000,000 ...
        for (long power = 1000; power <= n; power *= 1000) {
            ans += n - power + 1;

            // Prevent overflow of power *= 1000
            if (power > n / 1000) {
                break;
            }
        }

        return ans;
    }
}
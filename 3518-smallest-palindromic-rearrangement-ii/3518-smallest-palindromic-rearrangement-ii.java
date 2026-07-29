class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int half = n / 2;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Keep only characters needed for the left half
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        // If total number of palindromes < k
        if (count(freq, half, k) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        // Construct the k-th lexicographically smallest left half
        for (int pos = 0; pos < half; pos++) {

            for (int c = 0; c < 26; c++) {

                if (freq[c] == 0) continue;

                // Try placing character c
                freq[c]--;

                long ways = count(freq, half - pos - 1, k);

                if (ways >= k) {
                    // k-th answer is inside this group
                    left.append((char) ('a' + c));
                    break;
                }

                // Skip this entire group
                k -= ways;
                freq[c]++;
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        // Original s is already palindrome,
        // so the middle character is s[n / 2]
        if (n % 2 == 1) {
            return left.toString() + s.charAt(n / 2) + right;
        }

        return left.toString() + right;
    }

    // Count distinct permutations, but cap answer at k
    private long count(int[] freq, int remaining, long k) {
        long ways = 1;
        int used = 0;

        for (int f : freq) {
            if (f == 0) continue;

            // Choose positions for these f identical characters
            long comb = nCr(used + f, f, k);

            if (ways >= (k + comb - 1) / comb) {
                return k;
            }

            ways *= comb;
            used += f;
        }

        return ways;
    }

    // Calculate nCr while capping the result at k
    private long nCr(int n, int r, long k) {
        r = Math.min(r, n - r);

        long res = 1;

        for (int i = 1; i <= r; i++) {
            long x = n - r + i;

            // res * x / i >= k
            if (res > k * i / x) {
                return k;
            }

            res = res * x / i;

            if (res >= k) {
                return k;
            }
        }

        return res;
    }
}
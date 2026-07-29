class Solution {
    long C(int n, int r, long k) {
        r = Math.min(r, n - r);
        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= k) return k;
        }
        return ans;
    }

    long ways(int[] f, long k) {
        long ans = 1;
        int n = 0;

        for (int x : f) {
            if (x > 0) {
                ans *= C(n + x, x, k);
                if (ans >= k) return k;
                n += x;
            }
        }
        return ans;
    }

    public String smallestPalindrome(String s, int k) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;

        for (int i = 0; i < 26; i++)
            f[i] /= 2;

        StringBuilder a = new StringBuilder();

        for (int p = 0; p < s.length() / 2; p++) {
            for (int c = 0; c < 26; c++) {
                if (f[c] == 0) continue;

                f[c]--;
                long cnt = ways(f, k);

                if (cnt >= k) {
                    a.append((char)('a' + c));
                    break;
                }

                k -= cnt;
                f[c]++;
            }
        }

        if (a.length() != s.length() / 2)
            return "";

        String b = new StringBuilder(a).reverse().toString();

        return s.length() % 2 == 0
                ? a + b
                : a + "" + s.charAt(s.length() / 2) + b;
    }
}
class Solution {
    public String smallestPalindrome(String s) {

        // Count frequency of each character
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        // Process characters from 'a' to 'z'
        // to make the palindrome lexicographically smallest
        for (int i = 0; i < 26; i++) {

            // Put half of the occurrences on the left side
            int half = freq[i] / 2;

            for (int j = 0; j < half; j++) {
                left.append((char) ('a' + i));
            }

            // If frequency is odd, this character goes in the middle
            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        // Right side is the reverse of the left side
        String right = new StringBuilder(left).reverse().toString();

        // Construct final palindrome
        if (middle != 0) {
            return left.toString() + middle + right;
        }

        return left.toString() + right;
    }
}
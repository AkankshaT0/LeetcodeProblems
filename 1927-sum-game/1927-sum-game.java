class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;

        // Step 1: Count sums and question marks for both halves
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // Step 2: Use the mathematical strategy to check if Bob can force a tie
        // Bob wins if and only if the difference in sums can be perfectly neutralized 
        // by the difference in question marks (each pair of ? balances out to a sum of 9).
        return (leftSum - rightSum) * 2 != (rightQ - leftQ) * 9;
    }
}

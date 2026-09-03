class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean hasOdd = false;
        boolean hasEven = false;

        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums1) {

            if (num % 2 == 0) {
                hasEven = true;
                minEven = Math.min(minEven, num);
            } else {
                hasOdd = true;
                minOdd = Math.min(minOdd, num);
            }
        }

        // All numbers are already even
        if (!hasOdd) {
            return true;
        }

        // All numbers are already odd
        if (!hasEven) {
            return true;
        }

        // Mixed parity:
        // We can make everything odd only if
        // the smallest odd number is smaller than
        // the smallest even number.
        return minOdd < minEven;
    }
}
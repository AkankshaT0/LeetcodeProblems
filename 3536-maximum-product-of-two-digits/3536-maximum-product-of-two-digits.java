class Solution {
    public int maxProduct(int n) {
        int largest = 0;
        int secondLargest = 0;

        while(n > 0){

             // Extract last digit
            int digit = n % 10;

            if(digit >= largest){

                // Current largest becomes second largest
                secondLargest = largest;
                largest = digit;
            }
            else if(digit > secondLargest){
                secondLargest = digit;
            }

            // Remove last digit
            n /= 10;
        }
        return largest * secondLargest;
    }
}
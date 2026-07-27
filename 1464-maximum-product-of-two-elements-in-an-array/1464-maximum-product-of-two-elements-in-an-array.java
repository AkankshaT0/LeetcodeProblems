class Solution {
    public int maxProduct(int[] nums) {

        // Store the largest and second largest elements
        int max1 = 0;
        int max2 = 0;
        
        // Traverse through the array
        for(int num : nums){

            // If current number is greater than the largest
            if(num > max1){

                // Previous largest becomes second largest
                max2 = max1;
                max1 = num;
            }

            // If current number is not the largest
            // but greater than the second largest
            else if(num > max2){
                max2 = num;
            }
        }

        // Calculate maximum product according to the formula
        return (max1 - 1) * (max2 - 1);
    }
}
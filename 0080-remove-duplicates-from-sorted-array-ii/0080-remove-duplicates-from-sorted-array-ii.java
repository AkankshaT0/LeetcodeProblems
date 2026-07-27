class Solution {
    public int removeDuplicates(int[] nums) {

        // k represents the position where the next valid element will be placed
        int k = 0;

        // Traverse through every element in the array
        for ( int num : nums ){

            // Keep the element if:
            // 1. We have stored fewer than 2 elements, OR
            // 2. Current element is different from the element
            //    located 2 positions before it
            if( k < 2 || num != nums[k-2]){

                // Place the valid element at index k
                nums[k] = num;

                // Move to the next position
                k++;
            }
        }

        return k;  // k is the length of the modified array
    }
}
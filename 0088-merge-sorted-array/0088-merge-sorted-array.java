class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer to last valid element of nums1
        int i = m - 1;

        // Pointer to last element of nums2
        int j = n - 1;

        // Pointer to last position of nums1
        int k = m + n - 1;

         // Compare elements from the end
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements remaining, copy them into nums1
        while( j >= 0 ){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
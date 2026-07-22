class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while( l < r ){

            // Skip special characters from left
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            // Skip special characters from right
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            // Compare characters
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
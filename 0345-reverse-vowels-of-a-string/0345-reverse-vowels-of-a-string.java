class Solution {
    public String reverseVowels(String s) {

        char[] chars = s.toCharArray(); 
        String vowels = "aeiouAEIOU";
        int l = 0;
        int r = chars.length-1;

        while(l < r ){
            while(l < r && vowels.indexOf(chars[l]) == -1){
                l++;
            }
            while(l < r && vowels.indexOf(chars[r]) == -1){
                r--;
            }

            if(l < r){
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--; 
            }
        }
        return new String(chars);
    }
}
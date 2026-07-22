class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if(s.length() != t.length()){
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] freq = new int[26];

        // Traverse both strings
        for(int i = 0; i < s.length(); i++){

            // Increase frequency of character from s
            freq[s.charAt(i) - 'a']++;

            // Decrease frequency of character from t
            freq[t.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for(int count : freq){

            // Non-zero means character frequencies don't match
            if(count != 0){
                return false;
            }
        }

        // All character frequencies matched
        return true;
    }
}
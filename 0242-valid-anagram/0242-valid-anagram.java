class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths are different, they cannot be anagrams
        if(s.length() != t.length()){
            return false;
        }

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){

            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
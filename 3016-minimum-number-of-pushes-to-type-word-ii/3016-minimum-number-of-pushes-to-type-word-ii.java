class Solution {
    public int minimumPushes(String word) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq,0);

        // Count frequency of each character
        for(char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        // Sort frequencies in descending order
        Arrays.sort(freq,Collections.reverseOrder());

        int ans = 0;
        
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0){
                break;
            }

            int pushes = (i / 8) + 1;
            ans += freq[i] * pushes;
        }

        return ans;
    }
}
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                lower[word.charAt(i) - 'a']++;
            } else {
                upper[word.charAt(i) - 'A']++;

            }
        }

        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(lower[i] > 0 && upper[i] > 0) {
                ans ++;
            }
        }
        return ans;
    }
}
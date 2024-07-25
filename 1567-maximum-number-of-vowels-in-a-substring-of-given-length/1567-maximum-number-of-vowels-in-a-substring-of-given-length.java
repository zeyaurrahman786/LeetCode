class Solution {
    public int maxVowels(String s, int k) {
        int maxLen = 0;

        int[] vowels = new int[26];
        vowels['a' - 'a'] = 1;
        vowels['e' - 'a'] = 1;
        vowels['i' - 'a'] = 1;
        vowels['o' - 'a'] = 1;
        vowels['u' - 'a'] = 1;

        int count = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            count += vowels[ch - 'a'];

            if (right >= k - 1) {

                maxLen = Math.max(maxLen, count);
                char c = s.charAt(left);

                if (vowels[c - 'a'] != 0) {
                    count--;
                }
                left++;
            }
        }
        return maxLen;
    }
}
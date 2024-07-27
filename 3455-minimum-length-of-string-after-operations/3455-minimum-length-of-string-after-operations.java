class Solution {
    public int minimumLength(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0) {
                if (hash[i] % 2 == 0) {
                    ans += 2;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}
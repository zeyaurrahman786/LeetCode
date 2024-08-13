class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low = 0, max = 0;
        int[] a = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            low = Math.max(low, a[ch]);
            max = Math.max(max, i - low + 1);
            a[ch] = i + 1;
        }
        return max;
    }
}
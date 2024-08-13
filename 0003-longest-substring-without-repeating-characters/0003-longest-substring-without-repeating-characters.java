class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> substring = new HashMap<>();
        int res = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (substring.containsKey(s.charAt(j))) {
                i = Math.max(i, substring.get(s.charAt(j)) + 1);
            }
            res = Math.max(res, j - i + 1);
            substring.put(s.charAt(j), j);
        }
        return res;
    }
}
class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String res = sb.reverse().toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(res.substring(i))) {
                return res.substring(0, i) + s;
            }
        }
        return res + s;
    }
}
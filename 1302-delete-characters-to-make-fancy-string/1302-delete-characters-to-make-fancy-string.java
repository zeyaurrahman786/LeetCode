class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 2; i < n; i++) {
            if (sb.charAt(sb.length() - 1) != s.charAt(i) || sb.charAt(sb.length() - 2) != s.charAt(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
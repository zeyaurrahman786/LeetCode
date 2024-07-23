class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int j = -1;
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            if (d % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}
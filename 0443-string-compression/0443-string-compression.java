class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int k = 0;
        int n = chars.length;
        while (right < n) {
            while (right < n && chars[right] == chars[left]) {
                right++;
            }
            chars[k++] = chars[left];
            int num = right - left;
            if (num > 1) {
                String countStr = Integer.toString(num);
                for (char c : countStr.toCharArray()) {
                    chars[k++] = c;
                }
            }
            left = right;

        }
        return k;
    }
}
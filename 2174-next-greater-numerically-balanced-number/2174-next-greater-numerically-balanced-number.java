class Solution {
    public int nextBeautifulNumber(int n) {
        for (int num = n + 1;; num++) {
            if (isBalanced(num))
                return num;
        }
    }

    private boolean isBalanced(int num) {
        int[] freq = new int[10];
        int temp = num;

        while (temp > 0) {
            freq[temp % 10]++;
            temp /= 10;
        }

        for (int d = 0; d < 10; d++) {
            if (freq[d] != 0 && freq[d] != d)
                return false;
        }
        return true;
    }
}

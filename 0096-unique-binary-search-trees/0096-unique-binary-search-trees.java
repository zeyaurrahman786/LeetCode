class Solution {
    public int numTrees(int n) {
        return fact(2 * n);
    }

    int fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        long ans = 1;
        int j = 2;

        for (int i = n / 2 + 1; i <= n; i++) {
            ans *= i;
            while (true) {
                if (ans % j != 0 || j > n / 2)
                    break;
                ans = ans / j;
                j++;
            }
        }
        return Integer.valueOf(String.valueOf(ans / (n / 2 + 1)));
    }
}
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0; // Any number to the power 0 is 1
        long N = n; // Use long to handle edge case when n is Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0)
            return 1.0;
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

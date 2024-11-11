class Solution {

    public boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int p = 0;
        for (int x : nums) {
            if (x <= p) {
                return false;
            }
            int prime = x - p - 1;
            while (prime > 0 && !isPrime(prime)) {
                prime--;
            }
            if (prime == 0) {
                p = x;
            } else {
                p = x - prime;
            }
        }
        return true;
    }
}
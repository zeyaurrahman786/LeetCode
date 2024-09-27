public class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0; // No primes less than 2
        }

        boolean[] isPrime = new boolean[n]; // Create a boolean array for prime tracking
        for (int i = 2; i < n; i++) {
            isPrime[i] = true; // Assume all numbers are prime initially
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count; // Return the total count of primes less than n
    }
}

class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0; //Checking 0 & 1
        boolean[] composites = new boolean[n];
        int limit = (int)Math.sqrt(n);
        //Array of compoites --> True represent composite and False represents primes
        for(int i = 2; i <= limit; i++){
            if(composites[i] == false) {
                //Mark all the multiples of i as true. 
                //The first index to be flipped to true, is i*i
                for(int j = i*i; j < n; j+=i){
                    composites[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(composites[i] == false) count++;
        }
        
        return count;
    }
}
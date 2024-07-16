class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i = 0; i <= n; i++){
            int bits = 0;
            int mask = 1;
            for(int j = 0; j < 32; j++){
                if((mask & i) != 0){
                    bits++;
                }
                mask <<= 1;
            }
            arr[i] = bits;
        }
        return arr;
    }
}
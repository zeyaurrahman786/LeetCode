class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        long i = 1, j = x;
        while(i <= j){
            long mid = i + (j - i) / 2;
            if(mid * mid == (long)x){
                return (int)mid;
            }
            else if(mid * mid > (long)x){
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }
        return (int)j;
    }
}
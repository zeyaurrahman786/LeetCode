class Solution {
    public int largestAltitude(int[] gain) {
        int alt  = 0;
        int max = 0;

        for(int val: gain){
            alt += val;
            max = Math.max(max, alt);
        }
        return max;
    }
}
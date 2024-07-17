class Solution {
    public int longestSubarray(int[] nums) {
        int previous = 0;
        int current = 0;
        int ans = 0;
        for(int a : nums){
            if(a==1) current ++;
            else{
                ans = Math.max(ans, current + previous);
                previous = current;
                current = 0;
            }
        }
        ans = Math.max(ans, current + previous);
        return ans == nums.length ? ans - 1 : ans;
    }
}
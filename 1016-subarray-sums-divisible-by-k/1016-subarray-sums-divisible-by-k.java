class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int map[] = new int[k];
        map[0] = 1; // (0,1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            // convert negative rem to pos
            if (mod < 0) {
                mod = mod % k + k;
            }
            res += map[mod];
            map[mod]++;
        }
        return res;
    }
}
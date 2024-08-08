class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int req_num = target - nums[i];
            if (hashMap.containsKey(req_num)) {
                int[] arr = { hashMap.get(req_num), i };
                return arr;
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }
}
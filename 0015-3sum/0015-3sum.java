class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            twoSum(-nums[i], nums, i + 1, list);
        }
        return list;
    }

    public void twoSum(int target, int[] nums, int startIndex, List<List<Integer>> list) {
        int i = startIndex;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
                continue;
            }

            if (nums[i] + nums[j] > target) {
                j--;
                continue;
            }

            list.add(Arrays.asList(-target, nums[i], nums[j]));
            i++;
            j--;

            while (j > i && nums[j] == nums[j + 1]) {
                j--;
            }
        }
    }
}
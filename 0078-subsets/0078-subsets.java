class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void findSubsets(int nums[], int index, List<Integer> subList) {
        // Base case
        if (index == nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        // Pick
        subList.add(nums[index]);
        findSubsets(nums, index + 1, subList);
        subList.remove(subList.size() - 1);

        // No pick
        findSubsets(nums, index + 1, subList);
    }
}
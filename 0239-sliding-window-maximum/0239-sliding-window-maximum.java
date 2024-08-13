class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int j = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.removeFirst();
            }
            q.addLast(i);
            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}
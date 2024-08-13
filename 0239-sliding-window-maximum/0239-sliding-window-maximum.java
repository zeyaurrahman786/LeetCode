class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && nums[que.peekLast()] < nums[i]) {
                que.removeLast();
            }
            que.addLast(i);
        }
        ans[0] = nums[que.peekFirst()];
        for (int i = k; i < n; i++) {
            if (!que.isEmpty() && i - k >= que.peekFirst()) {
                que.removeFirst();
            }

            while (!que.isEmpty() && nums[que.peekLast()] < nums[i]) {
                que.removeLast();
            }
            que.addLast(i);
            ans[i - k + 1] = nums[que.peekFirst()];
        }
        return ans;
    }
}
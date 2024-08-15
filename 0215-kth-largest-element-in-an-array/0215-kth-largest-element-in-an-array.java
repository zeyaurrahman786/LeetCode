class Solution {
    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums){
            maxHeap.offer(num);
        }
        while(k > 0) {
            res = maxHeap.poll();
            k--;
        }
        return res;
    }
}
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         Arrays.sort(nums);
//         return nums[nums.length-k];
//     }
// }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(k+1);
        
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        return pq.poll();
    }
}

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         return quickselect(nums,0,nums.length-1,k);
//     }
    
//     int quickselect(int[] nums,int left,int right,int k){
//         int pivot=left;
        
//         for(int i=left;i<right;i++){
//             if(nums[i]<=nums[right]){
//                 swap(nums,pivot++,i);
//             }
//         }
        
//         swap(nums,pivot,right);
        
//         int count=right-pivot+1;
        
//         if(count==k){
//             return nums[pivot];
//         }
//         else if(count>k){
//             return quickselect(nums,pivot+1,right,k);
//         }
        
//         return quickselect(nums,left,pivot-1,k-count);
//     }
    
//     void swap(int[] nums,int l,int r){
//         int temp=nums[l];
//         nums[l]=nums[r];
//         nums[r]=temp;
//     }
// }
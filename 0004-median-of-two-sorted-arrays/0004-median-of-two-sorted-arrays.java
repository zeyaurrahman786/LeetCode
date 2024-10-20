class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            ans.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            ans.add(nums2[i]);
        }
        Collections.sort(ans);

        double median = 0;
        if (ans.size() % 2 == 1) {
            return ans.get(ans.size() / 2);
        } else {
            double left = ans.get(ans.size() / 2);
            double right = ans.get(ans.size() / 2 - 1);
            median = (left + right) / 2.0;
        }
        return median;

    }
}
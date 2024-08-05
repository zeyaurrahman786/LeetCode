class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        double product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            if (product > ans)
                ans = (int) product;
            if (product == 0)
                product = 1;
        }

        int ans2 = Integer.MIN_VALUE;
        double product2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product2 *= nums[i];
            if (product2 > ans2)
                ans2 = (int) product2;
            if (product2 == 0)
                product2 = 1;
        }
        return Math.max(ans, ans2);
    }
}
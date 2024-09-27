class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0; // Initialize maximum area to 0
        int lp = 0, rp = height.length - 1; // Left and right pointers

        while (lp < rp) {
            int width = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int currWater = width * ht; // Calculate the current area
            maxWater = Math.max(maxWater, currWater); // Update maxWater if current area is larger

            // Move the pointer corresponding to the smaller height
            if (height[lp] < height[rp]) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater; // Return the maximum area found
    }
}

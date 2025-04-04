// class Solution {
//     public int largestRectangleArea(int[] h) {
//         // Check null condition
//         if (h == null || h.length == 0)
//             return 0;

//         // Initialize variables left and right
//         int n = h.length;
//         int[] left = new int[n];
//         left[0] = -1;

//         int[] right = new int[n];
//         right[n - 1] = n;

//         // Fill left array
//         for (int i = 1; i < n; i++) {
//             int prev = i - 1;
//             while (prev >= 0 && h[prev] >= h[i]) {
//                 prev = left[prev];
//             }
//             left[i] = prev;
//         }

//         // Fill right array
//         for (int i = n - 2; i >= 0; i--) {
//             int prev = i + 1;
//             while (prev < n && h[prev] >= h[i]) {
//                 prev = right[prev];
//             }
//             right[i] = prev;
//         }

//         int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             maxArea = Math.max(maxArea, h[i] * (right[i] - left[i] - 1));
//         }

//         return maxArea;
//     }
// }

class Solution {
    public int largestRectangleArea(int[] h) {
        // Check null condition
        if (h == null || h.length == 0)
            return 0;

        // Initialize variables left and right
        int n = h.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int ht = (i == n) ? 0 : h[i];
            // If stack is empty of ht >= h[top] push in stack
            // Else process the elements and find area.

            if (stack.isEmpty() || ht >= h[stack.peek()]) {
                stack.push(i);
            } else {
                // Process elements and find the mexArea for popped index
                int top = stack.pop();
                int width = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                int area = h[top] * width;
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }
}
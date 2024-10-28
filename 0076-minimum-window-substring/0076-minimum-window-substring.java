class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary to keep a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t that need to be present in the desired
        // window.
        int required = dictT.size();

        // Left and Right pointers for the sliding window.
        int left = 0, right = 0;

        // Number of unique characters in the current window that match the required
        // counts in t.
        int formed = 0;

        // Dictionary to keep a count of characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // Array to store the result (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if the character frequency in the window matches that in t
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window until it no longer contains all characters in t
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the result if this window is smaller
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the left character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer to the right
                left++;
            }

            // Expand the window by moving right
            right++;
        }

        // Return the smallest window, or an empty string if no valid window was found
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

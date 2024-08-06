class Solution {
    public int minimumPushes(String word) {
        // Frequency
        int arr[] = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch-'a']++;
        }
        // Decreasing order sort
        Arrays.sort(arr); // increasing
        int count = 0;
        int minKeyPress = 0;
        // reverse
        for (int i = 25; i >= 0; i--) {
            int multi = 0;
            if (count < 8) {
                multi = 1;
            }
            else if (count < 16) {
                multi = 2;
            }
            else if (count < 24) {
                multi = 3;
            }
            else {
                multi = 4;
            }
            int val = arr[i]*multi;
            minKeyPress += val;
            count++;
        }
        return minKeyPress;
    }
}
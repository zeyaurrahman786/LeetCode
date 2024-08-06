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
            int val = arr[i]*(count/8 + 1);
            minKeyPress += val;
            count++;
        }
        return minKeyPress;
    }
}
class Solution {
    public int hIndex(int[] citations) {
        int h = citations.length;
        int maxi = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h - i) {
                maxi = Math.max(maxi, h - i);

            }
        }
        return maxi;
    }
}
class Solution {
    private int binarySearch(int[][] items, int price) {
        int left = 0, right = items.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid][0] <= price) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Return the maximum beauty up to the given price
        return right >= 0 ? items[right][1] : 0;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price in ascending order
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // Calculate prefix max beauty
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int price = queries[i];
            res[i] = binarySearch(items, price);
        }
        return res;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] cpy = arr.clone();
        Arrays.sort(cpy);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : cpy) {
            map.putIfAbsent(i, map.size() + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            cpy[i] = map.get(arr[i]);
        }
        return cpy;
    }
}
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minEle = arrays.get(0).get(0);
        int maxEle = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDis = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentList = arrays.get(i);
            int currentMin = currentList.get(0);
            int currentMax = currentList.get(currentList.size() - 1);

            maxDis = Math.max(maxDis, Math.max(
                    Math.abs(maxEle - currentMin),
                    Math.abs(currentMax - minEle)));

            minEle = Math.min(minEle, currentMin);
            maxEle = Math.max(maxEle, currentMax);
        }
        return maxDis;
    }
}
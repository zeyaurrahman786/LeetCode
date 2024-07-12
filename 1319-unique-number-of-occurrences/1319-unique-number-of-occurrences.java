class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                int value = map.get(arr[i]);
                map.put(arr[i], value+1);
            }
            else{
            map.put(arr[i], 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            set.add (e.getValue());
        }
        return map.size() == set.size();
    }
}
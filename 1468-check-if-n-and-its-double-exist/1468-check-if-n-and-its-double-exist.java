class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i); // Array Of Element & Index
        }
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(2*arr[i]) && map.get(2*arr[i]) !=i){
                return true;
            }
        }
        return false;
    }
}
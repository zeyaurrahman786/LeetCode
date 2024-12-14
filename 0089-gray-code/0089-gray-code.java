class Solution {
    public List<Integer> grayCode(int n) {
       List<Integer> list = new ArrayList<Integer>();
       list.add(0);
       if(n==0){
        return list;
       }
       list.add(1);
       int c = 1;
       for(int i=2;i<=n;i++){
        c*=2;
        for(int j=list.size()-1;j>=0;j--){
            list.add(c+list.get(j));
        }
       }
       return list;
    }
}
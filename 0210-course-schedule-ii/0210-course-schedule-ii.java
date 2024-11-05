class Solution {
    int p[],pos=0;
    HashSet<Integer> visi = new HashSet<Integer>();
    HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    public int[] findOrder(int numCourses, int[][] prer) {
        int i,j,n=prer.length;
        for(i=0;i<n;i++){
            List<Integer> lis = map.getOrDefault(prer[i][0],new ArrayList<Integer>());
            lis.add(prer[i][1]);
            map.put(prer[i][0],lis);
        }
        p=new int[numCourses];
        for(i=0;i<numCourses;i++){
            if(!map.containsKey(i)){
                p[pos++]=i;
                visi.add(i);
            }
        }
        for(i=0;i<n;i++){
            if(!visi.contains(prer[i][0])){
                if(!dfs(prer[i][0],new HashSet<Integer>()))
                    return new int[0];
            }
        }
        return p;
    }
    boolean dfs(int cour,HashSet<Integer> set){
        if(visi.contains(cour))return true;
        if(!map.containsKey(cour) || map.get(cour).size()==0){
            p[pos++]=cour;
            visi.add(cour);
        }else{
            for(int node: map.get(cour)){
                if(set.contains(node))return false;
                set.add(node);
                if(!visi.contains(node)){
                    if(!dfs(node,set))return false;
                }
                set.remove(node);
            }
            p[pos++]=cour;
            visi.add(cour);
        }
        return true;
    }
}
class Solution {
    public String largestGoodInteger(String num) {
        int i=0;
        String max="";
        while(i<num.length())
        {
            if(i+1<num.length() && num.charAt(i)==num.charAt(i+1) && i+2 < num.length() && num.charAt(i)==num.charAt(i+2))
                if(max.compareTo(num.substring(i,i+3))<0)
                {
                    max=num.substring(i,i+3);
                }
            i++;
        }
       return max;
    }
}
class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int j = -1;
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            if (d % 2 == 1) {
                j = i;
                break;
            }
        }
        if(j== -1){
            return "";
        }
        String ans= "";
        for(int i =0; i<=j;i++){
            ans+=num.charAt(i);

        }
        return ans;
    }
}
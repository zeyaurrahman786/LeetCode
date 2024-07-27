class Solution {
    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                lower[s.charAt(i) - 'a']++;
            }
            else{
                upper[s.charAt(i) - 'A']++;

            }
        }
        
        boolean check = false;
        int ans = 0;
        for(int i=0; i<26; i++){
            if(lower[i]%2==0){
                ans += lower[i];
            }
            else{
                ans += (lower[i]-1);
                check = true;
            }
        }

        for(int i=0; i<26; i++){
            if(upper[i]%2==0){
                ans += upper[i];
            }
            else{
                ans += (upper[i]-1);
                check = true;
            }
        }
        if(check == true){
            ans ++;
        }
        return ans;
    }
}
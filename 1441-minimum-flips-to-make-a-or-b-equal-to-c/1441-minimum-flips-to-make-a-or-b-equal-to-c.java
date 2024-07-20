class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        int or = a|b;

        for(int i=0;i<32;i++){
            if((or&(1<<i)) != (c&(1<<i))){

                //System.out.println((or&(1<<i)) +" "+ (c&(1<<i)));

                if((or&(1<<i)) == 0){
                    flips++;
                }
                else{
                    if((a&(1<<i)) != 0)
                        flips++;
                    if((b&(1<<i)) != 0)
                        flips++;
                }
            }
        }
        return flips;
    }
}
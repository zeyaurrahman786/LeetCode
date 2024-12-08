// Buy and Sell Stock Pattern
// Approach - 3 Space Optimized


class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int [][]prev = new int [2][3];
        int [][]cur = new int [2][3];
        int profit =0;
        
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int transaction =1;transaction<=2;transaction++){
                    if(buy ==0){
                        profit = Math.max(0+prev[0][transaction], -prices[i]+ prev[1][transaction]);
                    }
                    if(buy ==1){
                        profit = Math.max(0+prev[1][transaction],prices[i]+prev[0][transaction-1]);
                    }
                    cur[buy][transaction] = profit;
                }
                prev = (int [][])(cur.clone());
            }
        }
        return prev[0][2];
        
    }
}
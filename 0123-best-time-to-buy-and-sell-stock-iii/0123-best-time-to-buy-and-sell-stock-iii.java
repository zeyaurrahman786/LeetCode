// Buy and Sell Stock Pattern
// Approach - 2 Tabulation


class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int [][][]dp = new int [n+1][2][3];
        int profit =0;
        
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int transaction =1;transaction<=2;transaction++){
                    if(buy ==0){
                        profit = Math.max(0+dp[i+1][0][transaction], -prices[i]+ dp[i+1][1][transaction]);
                    }
                    if(buy ==1){
                        profit = Math.max(0+dp[i+1][1][transaction],prices[i]+dp[i+1][0][transaction-1]);
                    }
                    dp[i][buy][transaction] = profit;
                }
            }
        }
        return dp[0][0][2];
        
    }
}
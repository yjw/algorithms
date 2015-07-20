public class Solution {
     public int maxProfit(int k, int[] prices) {       // k: k times transactions
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][] local = new int[len][k+1];      // local[i][j]: max profit till i day, j transactions,
                                                // where there is transaction happening on i day
        int[][] global = new int[len][k+1];     // global[i][j]: max profit across i days, j transactions
        for(int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1; j<=k; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}
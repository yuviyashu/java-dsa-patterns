package com.yuvaraj.dsa.slidingwindow;

/**
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Pattern: Sliding Window
 * Intuition: Like walking past market stalls with a note of the cheapest price seen so far — at
 * every stall, check what you'd make selling here, and update the note if this stall is cheaper.
 * Time: O(n)   Space: O(1)
 */
public final class MaxProfit {

    private MaxProfit() {
    }

    /**
     * Returns the best profit from buying on one day and selling on a later day.
     *
     * @param prices the price on each day; expected to contain at least one day
     * @return the maximum profit, or {@code 0} if no profitable trade exists
     * @throws ArrayIndexOutOfBoundsException if {@code prices} is empty
     * @throws NullPointerException if {@code prices} is null
     */
    public static int maxProfit(int[] prices) {

        int buyingPrice = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length;i++){
            if(prices[i]>buyingPrice){
                maxProfit = Math.max(maxProfit, prices[i]-buyingPrice);
            }else{
                buyingPrice = prices[i];
            }
        }
        return maxProfit;
    }
}

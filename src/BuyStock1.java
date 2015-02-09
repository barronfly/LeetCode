/**
Solution: 
http://lifexplorer.me/leetcode-best-time-to-buy-and-sell-stock-i-ii-iii/

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

 */

public class BuyStock1 {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) return 0;
		
		int profit = 0, curprofit = 0;
		int lowest = prices[0];
		for (int i=1; i<prices.length; i++) {
			curprofit = prices[i] - lowest;
			if (curprofit < 0)
				lowest = prices[i];
			profit = Math.max(curprofit, profit);
		}
		return profit;
	}
	
	public int maxProfit2(int[] prices) {
		int profit = 0, curprofit = 0, gap = 0;
		if (prices.length <= 1) return profit;
		
		for (int i=1; i<prices.length; i++) {
// http://lifexplorer.me/leetcode-best-time-to-buy-and-sell-stock-i-ii-iii/
		}

		return profit;
	}
	
	public static void main(String args[]){
		int[] prices = {6,3,7,2,5};
		BuyStock1 bs = new BuyStock1();
		System.out.println("Max profit = " + bs.maxProfit(prices));
	}
}
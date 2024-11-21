/*Stock Buy and Sell – Multiple Transaction Allowed

The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

Examples:

Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865*/
class Solution {
    public int maximumProfit(int prices[]) {
      int buy=prices[0];
      int max=0;
      for(int i=0;i<prices.length;i++){
          if(buy<prices[i]){
              max+=prices[i]-buy;
          }
          buy=prices[i];
      }
      return max;
    }
}
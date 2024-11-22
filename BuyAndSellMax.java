
class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int buy=prices[0];
        int max=0;
        for(int i=0;i<prices.length;i++){
            if(buy>prices[i]){
                buy=prices[i];
            }
            if(prices[i]-buy>max){
                max=prices[i]-buy;            }
        }
        return max;
    }
}
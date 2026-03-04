package Array;

public class BuySellStocks {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};

        int profit = calculateMaxProfit(nums);
        System.out.println(profit);
    }

    /* Calculates max profit from buying and selling stocks
     According to the prices given in the input */
    private static int calculateMaxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            int currentProfit = prices[i] - min;
            if(currentProfit > maxProfit) maxProfit = currentProfit;
            if(prices[i] < min) min = prices[i];
        }
        return maxProfit;
    }
}

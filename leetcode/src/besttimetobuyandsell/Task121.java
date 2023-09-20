package besttimetobuyandsell;

public class Task121 {
    public static void main(String[] args) {
        System.out.println(new Task121().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int output = 0;
        int currentMin = prices[0];
        int price;

        for (int i = 0; i < prices.length; i++) {
            price = prices[i];
            output = Math.max(output, price-currentMin);
            currentMin = Math.min(currentMin, price);
        }

        return output;
    }
}

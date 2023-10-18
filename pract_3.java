//knapsack 0-1 problem using dynamic programming

public class pract_3 {
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int n = values.length;

        int maxProfit = knapsack(capacity, weights, values, n);
        System.out.println("Maximum profit: " + maxProfit);
    }
}

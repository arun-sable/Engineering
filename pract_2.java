//Knapsack using greedy method
import java.util.Scanner;
public class pract_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.println("Enter Number of elements or items");
        int n = sc.nextInt(); // Number of elements or items
        int[] vals = new int[n]; // Profits        
        int[] wts = new int[n]; // Weights
        System.out.println("Enter Profits");
        for (int i = 0; i < vals.length; i++) {
            vals[i] = sc.nextInt();
        }
        System.out.println("Enter Weights");4
        for (int i = 0; i < wts.length; i++) {
            wts[i] = sc.nextInt();
        }
        System.out.println("Enter Capacity of the Knapsack");
        int cap = sc.nextInt(); // Capacity
        sc.close();

        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j >= wts[i - 1]) {
                    int rCap = j - wts[i - 1];
                    if (dp[i - 1][rCap] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rCap] + vals[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j]; // if not any greater profit
                    }
                } else {
                    dp[i][j] = dp[i - 1][j]; // if not any greater profit
                }
            }
        }
        System.out.println("Maximum Profit Achievable is");
        System.out.println(dp[n][cap]);
    }
}

package TinkoffContest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] horses = new int[n][3];
        int[][][] dp = new int[n][1001][1001];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (char c : s.toCharArray()) {
                horses[i][c - 'a']++;
            }
        }

        Arrays.sort(horses, Comparator.comparingInt(a -> a[0] + a[1] + a[2]));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; j++) {
                for (int k = 0; k <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; k++) {
                    if (i > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                        if (j >= horses[i][0]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - horses[i][0]][k] + horses[i][0] + horses[i][1]);
                        }
                        if (j >= horses[i][0] && k >= horses[i][1]) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - horses[i][0]][k - horses[i][1]] + horses[i][0] + horses[i][1] + horses[i][2]);
                        }
                    } else {
                        if (j >= horses[0][0]) {
                            dp[0][j][k] = Math.max(dp[0][j][k], horses[0][0] + horses[0][1]);
                        }
                        if (j >= horses[0][0] && k >= horses[0][1]) {
                            dp[0][j][k] = Math.max(dp[0][j][k], horses[0][0] + horses[0][1] + horses[0][2]);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= horses[n - 1][0] + horses[n - 1][1] + horses[n - 1][2]; j++) {
            for (int k = 0; k <= j; k++) {
                ans = Math.max(ans, dp[n - 1][j][k]);
            }
        }

        System.out.println(ans);
    }
}

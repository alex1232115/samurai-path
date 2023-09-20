package Contest_Sirius;

import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        //0 1 1 3 3
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt() - 1;
        }

        //-1 0 0 2 2
        // 1 2 3 4 5
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            fillDepth(arr, i, ans);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] - 1 + " ");
        }
        //0 1 1 2 2
    }

    //    -1 0 0 2 2         4     depth 1 2 2 3 3 -  кол-во директоров у этих сотрудников
    public static void fillDepth(int[] parent, int i, int[] depth) {
        if (depth[i] != 0) {
            return;
        }

        if (parent[i] == -1) {
            depth[i] = 1;
            return;
        }

        if (depth[parent[i]] == 0) {
            fillDepth(parent, parent[i], depth);
        }

        depth[i] = depth[parent[i]] + 1;
    }
}
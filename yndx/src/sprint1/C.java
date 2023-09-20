package sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        List<Integer> list;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int cordN = Integer.parseInt(bufferedReader.readLine());
        int cordM = Integer.parseInt(bufferedReader.readLine());

        list = findNeighbours(cordN, cordM, arr);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : list) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    private static List<Integer> findNeighbours(int n, int m, int[][] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = -1; i <= 1; i = i + 2) {
            try {
                list.add(arr[n + i][m]);
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        for (int i = -1; i <= 1; i = i + 2) {
            try {
                list.add(arr[n][m + i]);
            } catch (IndexOutOfBoundsException ignored) {
            }
        }

        list.sort(Comparator.naturalOrder());
        return list;
    }
}

/*
1
2
-3 8
0
0
 */
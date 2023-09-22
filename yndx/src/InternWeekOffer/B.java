package InternWeekOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(st.nextToken()); // n kol-vo dosok
            int k = Integer.parseInt(st.nextToken()); // k kol-vo lishnih dosok
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            List<Integer> boards = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boards.add(Integer.parseInt(st2.nextToken()));
            }
            System.out.println(fenceRough(n, k, boards));
        }
    }

    private static int fenceRough(int n, int k, List<Integer> boards) {
        Collections.sort(boards);

        if (k == 0) return boards.get(boards.size() - 1) - boards.get(0);

        if (k % 2 == 0){
            for (int i = 0; i < k; i++) {
                boards.remove(0);
                i++;
                boards.remove(boards.size() - 1);
            }
        } else {
            for (int i = 0; i < k-1; i++) {
                boards.remove(0);
                i++;
                boards.remove(boards.size() - 1);
            }
            if (boards.get(boards.size() - 1) - boards.get(1) < boards.get(boards.size() - 1 - 1) - boards.get(0)){
                boards.remove(0);
            } else boards.remove(boards.size() - 1);
        }
        if (boards.size() == 1) return boards.get(0);
        return boards.get(boards.size() - 1) - boards.get(0);
    }
}

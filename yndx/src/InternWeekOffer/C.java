package InternWeekOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Map<Integer, Integer> nodes = new HashMap<>(); // Key = node Val = parent
            nodes.put(0, null);
            for (int i = 1; i <= n; i++) {
                int currentPar = Integer.parseInt(reader.readLine());
                nodes.put(i, currentPar);
            }
            maxLength(nodes);
        }
    }

    private static void maxLength(Map<Integer, Integer> nodes) {
        int maxLen = 0;
        int repoNum = 0;
        if (nodes.size() == 1) System.out.println(repoNum);



    }
}

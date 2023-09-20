package sprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class I {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i + 1);
            }
            int root = list.get(0);
            int sum = 0;
            System.out.println(makeDiffTrees(list, root, sum));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int makeDiffTrees(List<Integer> tree, int root, int sum) {
        makeDiffTrees(List.copyOf(tree).remove(root))
        
    }
}

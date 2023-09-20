package TinkoffFintech;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(rd.readLine());
            List<Integer> list = new ArrayList<>();
            List<Integer> deletedIndexes = new ArrayList<>();
            Map<Integer, Integer> valuesIndexes = new HashMap<>();
            int countAdded = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(rd.readLine());
                char operation = st.nextToken().charAt(0);
                int digit = Integer.parseInt(st.nextToken());

                switch (operation) {
                    case '+':
                        if (deletedIndexes.size() != 0) {
                            Collections.sort(deletedIndexes);
                            int index = deletedIndexes.remove(0);
                            list.add(index, digit);
                            valuesIndexes.put(digit, index);
                            wt.write(String.valueOf(index + 1));
                        } else {
                            list.add(countAdded, digit);
                            valuesIndexes.put(digit, countAdded);
                            countAdded++;
                            wt.write(String.valueOf(countAdded));
                        }
                        wt.newLine();
                        break;
                    case '-':
                        int index = valuesIndexes.remove(digit);
                        list.remove(index);
                        deletedIndexes.add(index);
                        if (index == countAdded) countAdded--;
                        break;
                }
            }
        }
    }
}

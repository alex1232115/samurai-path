package sprint4;

import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out))){
            int n = Integer.parseInt(rd.readLine());
            Map<String, List<Integer>> listOfIndexes = new HashMap<>();
            StringTokenizer st = new StringTokenizer(rd.readLine());
            List<String> orders = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char [] currentWord = st.nextToken().toCharArray();
                Arrays.sort(currentWord);
                String current = String.valueOf(currentWord);
                if (!listOfIndexes.containsKey(current)){
                    orders.add(current);
                }
                List<Integer> currentList = listOfIndexes.getOrDefault(current, new ArrayList<>());
                currentList.add(i);
                listOfIndexes.put(current, currentList);
            }
            for (String order : orders) {
                for (int j = 0; j < listOfIndexes.get(order).size(); j++) {
                    wt.write(String.valueOf(listOfIndexes.get(order).get(j)));
                    wt.write(" ");
                }
                wt.newLine();
            }
        }
    }
}


package TinkoffContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> list = new LinkedList<>();
            ArrayList<Character> commands = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] arrLine = reader.readLine().replace(" ", "").toCharArray();
                for (char c : arrLine) {
                    commands.add(c);
                }
            }
            for (int i = 0; i < commands.size(); i++) {
                int action = commands.get(i) - '0';
                if (action == 1) {
                    list.add(commands.get(i + 1) - '0');
                    i++;
                } else if (action == 2) {
                    list = expandList(list);
                } else if (action == 3) {
                    System.out.println(list.remove(0));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Integer> expandList(List<Integer> list) {
        List<Integer> newList = new LinkedList<>();
        for (Integer integer : list) {
            newList.add(integer);
            newList.add(integer);
        }
        return newList;
    }
}

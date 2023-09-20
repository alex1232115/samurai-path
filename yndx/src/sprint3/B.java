package sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] dict = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            StringBuilder n = new StringBuilder(reader.readLine());
            StringBuffer prefix = new StringBuffer();
            combinations(Integer.parseInt(String.valueOf(n.reverse())), dict, prefix);
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void combinations(int n, String[] dict, StringBuffer prefix) {
        //базовый случай - мы выходим, когда больше нет чисел для работы
        if (n % 10 == 0) {
            System.out.print(prefix + " ");
            return;
        }
        //рекурсивный случай - когда ещё есть число
        char[] currentDigitArr;

        currentDigitArr = dict[n%10].toCharArray();

        for (char c : currentDigitArr) {
            prefix.append(c);
            combinations(n / 10, dict, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}

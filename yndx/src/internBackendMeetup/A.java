package internBackendMeetup;

import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizerGlass = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(stringTokenizerGlass.nextToken());
        int m = Integer.parseInt(stringTokenizerGlass.nextToken());

        char[][] glass = new char[n][m];

        for (int i = 0; i < n; i++) {
            glass[i] = reader.readLine().toCharArray();
        }

        int k = Integer.parseInt(reader.readLine());
        LinkedList<String[]> ingredients = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            String[] ingredient = new String[2];
            StringTokenizer stringTokenizerIngredients = new StringTokenizer(reader.readLine());
            stringTokenizerIngredients.nextToken();
            String count = (stringTokenizerIngredients.nextToken());
            String symbol = stringTokenizerIngredients.nextToken();

            ingredient[0] = symbol;
            ingredient[1] = count;

            ingredients.add(ingredient);
        }

        fillGlass(glass, ingredients, n, m);
    }

    private static void fillGlass(char[][] glass, LinkedList<String[]> ingredients, int n, int m) throws IOException {
        char symbol = ingredients.getFirst()[0].charAt(0);
        int count = Integer.parseInt(ingredients.removeFirst()[1]);

        for (int i = n - 2; i >= 0; i--) { //последнюю строку пропускаем, т.к это дно стакана
            if (count == 0 && !ingredients.isEmpty()) {
                symbol = ingredients.getFirst()[0].charAt(0);
                count = Integer.parseInt(ingredients.removeFirst()[1]);
            } else if (count == 0 && ingredients.isEmpty()) break;
            for (int j = m - 1; j >= 0; j--) {
                if (glass[i][j] == ' ') {
                    glass[i][j] = symbol;
                }
            }
            count--;
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                writer.write(glass[i][j]);
            }
            writer.newLine();
        }
        writer.flush();
    }
}

/*
_ - дно стакана
\ / | (n символов)- грани (i и i+1 строки содержат символы граней в одном или соседних столбцах)
space - пустое место между гранями
. - фон изображения (m - столбцы n - строки, т.е (m - заполненные столбцы) - точки)
 */
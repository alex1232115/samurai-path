package sprint4;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class D {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out))){
            Map<String, Integer> courses = new HashMap<>();
            int n = Integer.parseInt(rd.readLine());
            String currentLine;
            for (int i = 0; i < n; i++) {
                currentLine = rd.readLine();
                if (!courses.containsKey(currentLine)){
                    courses.put(currentLine, 1);
                    wt.write(currentLine);
                    wt.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

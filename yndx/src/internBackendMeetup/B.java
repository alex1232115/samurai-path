package internBackendMeetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] platforms = new int[n];
        StringTokenizer stringTokenizerPlatform = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            platforms[i] = Integer.parseInt(stringTokenizerPlatform.nextToken());
        }
        List<Integer> guardsList = new ArrayList<>();
        StringTokenizer stringTokenizerGuards = new StringTokenizer(reader.readLine());

        for (int i = 0; i < m; i++) {
            guardsList.add(Integer.parseInt(stringTokenizerGuards.nextToken()));
        }

        System.out.println(maxGuardsForPlatforms(platforms, guardsList, n, m));
    }

    private static int maxGuardsForPlatforms(int[] platforms, List<Integer> guards, int n, int m) {
        int maxGuards = 0;

        int previewLight = 0;

        for (int i = platforms.length - 1; i >= 0; i--) {
            int currentLight = platforms[i] - previewLight;

            if (currentLight <= 0) {
                previewLight = platforms[i];
                continue;
            }
            for (int j = 0; j < guards.size(); j++) {
                if (platforms[i] >= guards.get(j) && currentLight >= guards.get(j)) {
                    maxGuards++;
                    guards.remove(j);
                    break;
                }
            }
            previewLight = platforms[i];
        }
        return maxGuards;
    }
}

/*
сторожевая башня:
n платформ (одинаковой ширины) -> длина i платформы = a
m охранников -> j доброволец с шириной плеч b
1. боком
2. ширина плеч охранника b < a платформы
3. охранник должен быть полностью под освещением
4. <=1 охранников на одну платформу

max (m) Граф?
 */
package YandexContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class B {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer line1 = new StringTokenizer(reader.readLine());
            final int N = Integer.parseInt(line1.nextToken());
            final int X = Integer.parseInt(line1.nextToken());
            final int T = Integer.parseInt(line1.nextToken());

            StringTokenizer line2 = new StringTokenizer(reader.readLine());

            Map<Integer, Integer> differenceAndIndex = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                int currentWeight = Integer.parseInt(line2.nextToken());
                int abs = Math.abs(X - currentWeight);
                if (abs <= T) {
                    differenceAndIndex.put(i, abs);
                }
            }
            differenceAndIndex = valueSort(differenceAndIndex);
            optimalSculptureNum(differenceAndIndex, T);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void optimalSculptureNum(Map<Integer, Integer> differenceAndIndex, int restTime) {
        ArrayList<Integer> sculptureIndex = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : differenceAndIndex.entrySet()) {
            if (restTime >= 0) {
                int currentWeighDiff = entry.getValue();
                if (currentWeighDiff <= restTime) {
                    restTime = restTime - currentWeighDiff;
                    sculptureIndex.add(entry.getKey() + 1);
                }
            } else {
                break;
            }
        }
        System.out.println(sculptureIndex.size());
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (Integer index : sculptureIndex) {
                writer.write(index + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <K, V extends Comparable<V>> Map<K, V>
    valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {

            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }
}
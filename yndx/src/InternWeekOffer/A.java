package InternWeekOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int usbPorts = Integer.parseInt(reader.readLine());
            int gadgetsNum = Integer.parseInt(reader.readLine());
            int duoUsbPrice = Integer.parseInt(reader.readLine()); // +1
            int hubUsbPrice = Integer.parseInt(reader.readLine()); // +4

            //int neededPorts = gadgetsNum - usbPorts;
            //Map<Integer, Integer> cache = new HashMap<>();
            //System.out.println(findMinPrice(neededPorts, duoUsbPrice, hubUsbPrice, 0, cache));
            System.out.println(findMinPriceDp(usbPorts, gadgetsNum, duoUsbPrice, hubUsbPrice));
        }
    }

    private static int findMinPrice(int neededPorts, int duoUsbPrice, int hubUsbPrice, int minPrice, Map<Integer, Integer> cache) {
        if (cache.containsKey(neededPorts)) {
            return cache.get(neededPorts);
        } else {
            int curMin = cache.getOrDefault(neededPorts, minPrice);
            if (curMin > minPrice) {
                cache.put(neededPorts, minPrice);
            }
        }

        if (neededPorts <= 0) {
            return minPrice;
        }
        int min = 0;

        min = Math.min(findMinPrice(neededPorts - 1, duoUsbPrice, hubUsbPrice, minPrice + duoUsbPrice, cache),
                findMinPrice(neededPorts - 4, duoUsbPrice, hubUsbPrice, minPrice + hubUsbPrice, cache));

        return min;
    }

    private static int findMinPriceDp(int n, int m, int duoPr, int hubPr) {
        if (n > m) return 0;
        int target = m - n;
        int[][] costs = new int[target / duoPr][target / hubPr];
        for (int i = 0; i < target / duoPr; i++) {
            for (int j = i; j < target / hubPr; j++) {
                costs[i][j] = duoPr * i + hubPr * j;
            }
        }
        int minVal = 0;
        for (int i = 0; i < target / duoPr; i++) {
            for (int j = i; j < target / hubPr; j++) {

            }
        }
        return 1;
    }
}

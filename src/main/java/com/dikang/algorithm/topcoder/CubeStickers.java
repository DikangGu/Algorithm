import java.util.HashMap;
import java.util.Map;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 507 > Div II 500.
 */
public class CubeStickers {

    public String isPossible(String[] sticker) {

        Map<String, Integer> colorMap = new HashMap<String, Integer>(0);
        for (String oneSticker : sticker) {
            if (colorMap.containsKey(oneSticker)) {
                colorMap.put(oneSticker, colorMap.get(oneSticker) + 1);
            } else {
                colorMap.put(oneSticker, 1);
            }
        }

        int total = 0;
        for (String color : colorMap.keySet()) {
            total += colorMap.get(color) > 2 ? 2 : colorMap.get(color);
        }

        return total >= 6 ? "YES" : "NO";
    }
}

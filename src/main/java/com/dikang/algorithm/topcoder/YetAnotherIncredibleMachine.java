import java.util.HashMap;
import java.util.Map;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 513 -> Div II -> 500
 */
public class YetAnotherIncredibleMachine {

    public int countWays(int[] platformMount, int[] platformLength, int[] balls) {
        double result = 1;
        double mode = 1000000009;

        for (int i=0; i<platformMount.length; i++) {
            Map<Integer, Boolean> map = new HashMap<Integer, Boolean>(0);
            for (int j=0; j<balls.length; j++) {
                for (int k=0; k<=platformLength[i]; k++) {
                    map.put(balls[j] - k, false);
                }
            }

            double count = 0;
            for (int left = platformMount[i] - platformLength[i];
                 left <= platformMount[i]; left ++) {
                if (!map.containsKey(left)) {
                    count ++;
                }
            }

            if (count == 0) {
                return 0;
            }


            result = (result*count)% mode;
        }

        return (int) result;
    }
}

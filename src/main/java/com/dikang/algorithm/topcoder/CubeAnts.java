/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 507 > Div II 250.
 */
public class CubeAnts {

    public int getMinimumSteps(int[] pos) {

        int[] dis = new int[] {0, 1, 2, 1, 1, 2, 3, 2};
        int min = 0;

        int len = pos.length;
        for (int i=0; i<len; i++) {
            if (min < dis[pos[i]]) {
                min = dis[pos[i]];
            }
        }

        return min;
    }

}

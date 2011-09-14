import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 507 > Div II 1000.
 */
public class CubeRoll {

    int findLargerNum(int[] sortedArray, int num) {

        int left = 0, right = sortedArray.length - 1;

        // all smaller than num
        if (sortedArray[right] < num) {
            return -1;
        }

        while (left < right - 1) {
            int mid = (left + right) >> 1 ;
            if (sortedArray[mid] > num) {
                right = mid;
            } else if (sortedArray[mid] < num) {
                left = mid;
            } else {
                left = mid;
                right = mid;
                break;
            }
        }

        if (sortedArray[left] > num) {
            return left;
        }

        if (sortedArray[right] > num) {
            return right;
        }

        return right + 1;
    }

    public int getMinimumSteps(int initPos, int goalPos, int[] holePos) {

        Queue<Integer> queue = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(0);

        queue.add(initPos);
        map.put(initPos, 0);

        while(!queue.isEmpty()) {

        }


        return 0;
    }
}

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 514 -> Div II -> 250.
 */
public class MagicalGirlLevelOneDivTwo {

    public double theMinDistance(int d, int x, int y) {

        int minx = -d;
        int maxx = d;
        int miny = -d;
        int maxy = d;

        if (minx<=x && x<=maxx && miny<=y && y<=maxy) {

            return 0.0;
        }

        if (minx <=x && x<=maxx) {
            return Math.min(Math.abs(y+d), Math.abs(y-d));
        }

        if (miny<=y && y<=maxy) {
            return Math.min(Math.abs(x+d), Math.abs(x-d));
        }

        double result = Math.min(Math.sqrt((x+d)*(x+d) + (y+d)*(y+d)),
                Math.sqrt((x-d)*(x-d) + (y+d)*(y+d)));
        result = Math.min(result, Math.sqrt((x+d)*(x+d) + (y-d)*(y-d)));
        result = Math.min(result, Math.sqrt((x-d)*(x-d) + (y-d)*(y-d)));

        return result;
        /*double cy = (double)y *(double)d / (double)x;
        double cx = (double)x *(double)d / (double)y;

        double dst = 0;
        if (miny <= cy & cy <=miny) {
            dst = Math.min(Math.sqrt((x+d)*(x+d) + (y+cy)*(y+cy)),
                    Math.sqrt((x-d)*(x-d)+(y-cy)*(y-cy)));
        } else {
            dst = Math.min(Math.sqrt((x+cx)*(x+cx) + (y+d)*(y+d)),
                    Math.sqrt((x-cx)*(x-cx)+(y-d)*(y-d)));
        }
        return dst;*/
    }
}

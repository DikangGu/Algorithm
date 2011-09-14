package com.dikang.algorithm.topcoder.SRM515;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 */
public class RotatedClock {

    public String getEarliest(int hourHand, int minuteHand)
	{

        int hourMod = hourHand % 30;
        int minute = hourMod * 2;
        int expected = minute * 6;

        for (int i=0; i<12; i++) {
            if ((minuteHand - hourHand + i*30 + hourMod + 360)%360 == expected) {
                int hour = i;
                String result = "";
                if (hour < 10) {
                    result += "0";
                }
                result += String.valueOf(hour);
                result += ":";
                if (minute < 10) {
                    result += "0";
                }
                result += String.valueOf(minute);

                return result;
            }
        }

	    return "";
	}
}

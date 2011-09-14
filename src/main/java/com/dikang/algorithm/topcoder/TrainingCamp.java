/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * SRM 513 -> Div II -> 250
 */
public class TrainingCamp {
    public String[] determineSolvers(String[] attendance,
                                     String[] problemTopics) {

        int N = attendance.length;
        int K = problemTopics.length;
        String[] result = new String[N];

        for (int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<K; j++) {
                if (solvable(attendance[i], problemTopics[j])) {
                    sb.append('X');
                } else {
                    sb.append('-');
                }
            }
            result[i] = sb.toString();
        }

        return result;
	}

    private boolean solvable(String attendance, String topic) {
        for (int i=0; i<topic.length(); i++) {
            if (topic.charAt(i) == 'X' && attendance.charAt(i)!='X') {
                return false;
            }
        }
        return true;
    }

    public static void main(String [] argv) {
    }
}

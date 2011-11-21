import java.util.Scanner;

public class P1221{

    private static long[][] result;
    public static void main(String[] args) {

	result = new long[300][300];
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	    int n = sc.nextInt();
	    if (n == 0) 
		return;

	    for (int i=0; i<=n; i++) {
		for (int j=0; j<=n; j++) {
		    result[i][j] = 0;
		}
		result[i][i] = 1;
		result[0][i] = 1;
	    }

	    // calculate
	    //init
	    result[0][0] = 1;
	    result[1][0] = 1;
	    result[1][1] = 1;
	    result[2][1] = 2;
	    result[2][2] = 1;
	    result[2][0] = 2;

	    for (int i=3; i<=n; i++) {
		for (int j=i-1;j>0; j--) {
		    result[i][j] = result[i][j+1];
		    if (i-2*j>=0) {
			result[i][j] += result[i-2*j][j];
		    }
		}
	    }

	    System.out.println(n + " " + result[n][1]);
	}
    }
}

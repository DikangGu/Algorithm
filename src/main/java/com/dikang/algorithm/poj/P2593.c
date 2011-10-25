#include <stdio.h>

int main() {     
	
	int count;
	int i,j,k;   
	int max, result;
	int forward[100002];
	int backward[100002];
	int data[100002];
	
	scanf("%d", &count);
	while(count!=0) {
		
		for (j=0; j<count; j++) {
			scanf("%d", &data[j]);
		}                          
		 
		max = -2147483648;
		result = max;
		
		for (j=0; j<count; j++) {
			if (result<0) result = data[j];
			else result = result + data[j];
			
			if (max < result) max = result;
			forward[j] = max;
		}            
		
		max = -2147483648;
		result = max;
		
		for (j=count-1; j>=0; j--) { 
			if (result<0) result = data[j];
			else result = result + data[j];
			
			if (max < result) max = result;
			backward[j] = max;
		}  
		    
		max = -2147483648; 
		for (j=0; j<count-1; j++) {   
			int t = forward[j] + backward[j+1];
			if (max < t) max = t;
		}                        
		
		printf("%d\n", max);  
		scanf("%d", &count);
	}                              
	
	return 0;
}
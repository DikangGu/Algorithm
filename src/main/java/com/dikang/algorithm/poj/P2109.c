#include<cstdio>
#include<cmath>
int main()
{
    double n,k;
    while(scanf("%lf %lf",&n,&k)==2)
       printf("%.0lf\n",pow(k,1/n));
    return 0;
}
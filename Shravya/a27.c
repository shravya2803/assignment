#include<stdio.h>
void main()
{
    int n,i,x;
    printf("Please enter the no\n");
    scanf("%d",&n);
    for (i=2;i<n;i++){
        if((n%i)==0){
            printf("%d is not a prime\n",n);
            break;
        }
        x=i;
    }
if ((n%x)!=0){
    printf("the no %d is prime\n",n);
}
}
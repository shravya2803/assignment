#include<stdio.h>
void main()
{
    int n;
    printf("Please enter the no\n");
    scanf("%d",&n);
    for (int i=1;i<=n;i++){
        if(i%2==0){
            printf("%d is even\n",i);
        }
        else {
            printf("%d is odd\n",i);
        }
    }
}
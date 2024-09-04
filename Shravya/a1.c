#include<stdio.h>
void main()
{
    double principal,rate,time,interst,totalamount;
    printf("Please enter the principal amount and rate and time and time\n");
    printf("principal:-\n");
    scanf("%d",&principal);
    printf("rate:-\n");
    scanf("%d",&rate);
    printf("time:-\n");
    scanf("%d",&time);
    interst=((principal*rate*time)/100);
    totalamount=interst+principal;
    printf("the interst and total amount are %d %d",interst,totalamount);
}

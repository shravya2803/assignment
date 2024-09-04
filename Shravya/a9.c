#include <stdio.h>
void main(){
    int hour,min,second,total;
    printf("Please enter the hour\n");
    scanf("%d",&hour);
    printf("Please enter the no of mninutes\n");
    scanf("%d",&min);
    printf("PLease enter the no of second\n");
    scanf("%d",&second);
    total=(hour*3600)+(min*60)+second;
    printf("total no of second are %d\n",total);
}
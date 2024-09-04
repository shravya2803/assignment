#include<stdio.h>
void main()
{
    int sec,min,hour;
    printf("Please enter the no of sec \n");
    scanf("%d",&sec);
    hour=((sec/3600));
    sec=(sec%3600);
    min=(sec/60);
    sec=(sec%60);
    printf("The time is %d:%d:%d in format hour:min:sec",hour,min,sec);
}
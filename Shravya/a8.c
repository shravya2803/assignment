# include <stdio.h>
void main (){
    int onerev = 31558150;
    int years,hours,min,sec;
    printf("please enter the number years\n");
    scanf("%d",&years);
    hours=((years*onerev)/3600);
    sec= ( (years*onerev)%3600);
    min=(sec/60);
    sec=(sec%60);
    printf("the no of hours %d and min %d and sec %d",hours,min,sec);
}
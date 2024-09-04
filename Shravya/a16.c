#include <stdio.h>
void s1(){
    printf("this is a funtion\n");
}
void main()
{
int a,b,c;
printf("Please enter the num 1 \n");
scanf("%d",&a);
printf("Please enter the num 2 \n");
scanf("%d",&b);
printf("Please enter the num 3 \n");
scanf("%d",&c);
if (a>b){
    if (c>a){
        printf("num 3 is the highest\n");
    }
    else{
        printf("first num is the highest num\n");
    }
}
else{
    if (c>b){
        printf("num 3 is the highest\n");
    }
    else{
        printf("second num is the highest num\n");
    }
}
s1();   
}

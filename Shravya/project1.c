//this is my first program in c
#include<stdio.h>
int main(){
    printf("hello world\n");
    int num1,num2;
    printf("Please enter the first number\n");
    scanf("%d",&num1);
    printf("Please enter the second number\n");
    scanf("%d",&num2);
   int sum=num1+num2;
    printf("The sum is %d",sum);
    return 0;
}
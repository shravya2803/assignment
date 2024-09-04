# include<stdio.h>
void main(){
    int power;
   int num;
   int y=1;
   scanf ("%d",&power);
   scanf("%d",&num);
   for (int x=1;x<=power;x++){
    y=num*y;
   }
   printf("%d",y);
}
# include <stdio.h>
 void main(){
   int x;
   int y=1;
    printf("Please enter the no that we have to find factirol\n");
    scanf("%d",&x);
    for (int i=1;i<=x;i++){
        y=y*i;
    }
    printf("your factrioal is %d\n",y);
 }
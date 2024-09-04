# include <stdio.h>
void condi(float per){
    if (90<=per){
        printf("your grade is A+\n");
    }
    else if (80<=per){
        printf("your grade is A\n");
    }
     else if (70<=per){
        printf("your grade is B+\n");
    }
     else if (60<=per){
        printf("your grade is B\n");
    }
     else if (50<=per){
        printf("your grade is C+\n");
    }
}
void sum(int a,int b,int c,int d,int e){
    float sum,per;
    sum = a+b+c+d+e;
    printf("%d",sum);
    per = ((sum/500)*100);
    condi(per);
}

void main()
{
    int a,b,c,d,e;
    printf("Please enter the first subject\n");
    scanf("%d",&a);
     printf("Please enter the second subject\n");
    scanf("%d",&b);
     printf("Please enter the 3rd subject\n");
    scanf("%d",&a);
     printf("Please enter the 4th subject\n");
    scanf("%d",&a);
     printf("Please enter the 5th subject\n");
    scanf("%d",&a);
   sum(a,b,c,d,e);
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

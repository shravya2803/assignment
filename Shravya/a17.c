# include <stdio.h>
int main()
{
    int a,b,c;
    printf("Please enter the 1st number\n");
    scanf("%d",&a);
    printf("Please enter the 2nd number\n");
    scanf("%d",&b);
    printf("Please enter the 3rd number\n");
    scanf("%d",&c);
    if (a>b && a>c){
        printf("the 1st no is the highest\n");
    }
    else  if (a<b && b>c){
        printf("the 2nd no is the highest\n");
    }
    else{printf("the 3rd number is the highest\n");}
    return 0;
}

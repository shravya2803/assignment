# include <stdio.h>
void main(){
    int num,n;
     int ans;
        int number;
    printf("Please enter the no of num you want\n");
    scanf("%d",&num);
    printf("Please enter 1 for add.\nPlease enter the 2 for sub\nPlease enter 3 for multi.\nPlease enter 4 for div.\n"); 
    scanf("%d",&n);
    switch(n){
        case 1:ans=0;
        for (int i=1;i<=num;i++){
            printf("Please enter the number\n");
            scanf("%d",&number);
            
            ans=ans+number;
        }
        printf("The ans is %d ",ans);
        break;
        case 2:ans=0;
        for (int i=1;i<=num;i++){
            printf("Please enter the number\n");
            scanf("%d",&number);
            
            ans=ans-number;
        }
        printf("The ans is %d ",ans);
        break;
        case 3:ans=1;
        for (int i=1;i<=num;i++){
            printf("Please enter the number\n");
            scanf("%d",&number);
           
            ans=ans*number;
        }
        printf("The ans is %d ",ans);
        break;
        case 4:ans=1;
        for (int i=1;i<=num;i++){
            printf("Please enter %d the number\n",i);
            scanf("%d",&number);
            
            ans=number/ans;
        }
        printf("The ans is %d ",ans);
        break;
    }
}
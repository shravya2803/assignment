# include<stdio.h>
# include<ctype.h>
void main(){
    printf("please enter the char of your choice\n");
    char user ;
    scanf("%c",&user);
    
    if(islower(user))
    {
        printf("your char is in small case\n");
    }
    else if(isupper(user))
    {
        printf("your char is in upper case\n");
    }
    else if(isdigit(user))
    {
        printf("your char is a digit\n");
    }
    else 
    {
        printf("your char is a special symbol\n");
    }
}
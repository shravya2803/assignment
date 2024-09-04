# include<stdio.h>
# include<ctype.h>
void main(){
    printf("please enter the char of your choice\n");
    char user ;
    scanf("%c",&user);
    
    if(islower(user))
    {
        printf("your char is in small case and it is '%c'\n",user);
    }
    else 
    {
        printf("your char is not small case your char is in upper case");
    }
}
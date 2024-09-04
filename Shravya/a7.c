#include <stdio.h>
void main (){
    double height,base,area;
    printf("Please enter the height of the triangle\n");
    scanf("%lf",&height);
    printf("Please enter the base length\n");
    scanf("%lf",&base);
    area = (0.5)*(height*base);
    printf("area is %lf",area);
}
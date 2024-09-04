#include <stdio.h>
void main()
{
    double fer;
    printf("PLease enter tempture in fer\n");
    scanf("%lf",&fer);
    double deg=(((fer-32)*5)/9);
    printf("tempture celsus are %lf\n",deg);
}

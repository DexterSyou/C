#include <stdio.h>

int main(){
 
 float fahr,celsius;
 float l=0 , u=300 , s = 20; 

 fahr = l;
 while(fahr <= u){
   celsius = (5.0 / 9.0) * (fahr -32.0);
   printf("%3.0f %6.1f\n",fahr ,celsius);
   fahr = fahr + s;
 }
 return 0;
}

#include <stdio.h>
#include "pG6.h"

void get_names(names *pn){
  
  int i;
  printf("PLease enter your first name:");
  fgets(pn->first,SLEN,stdin);
  i=0;
  while(pn->first[i]!='\n' && pn->first[i] != '\0')
     i++;
    
   if(pn->first[i]=='\n')
      pn->first[i] = '\0';
   else
      while(getchar()!='\n')
         continue;

   printf("PLease enter your last name:");
   fgets(pn->last,SLEN,stdin);
   i=0;
   while(pn->last[i]!='\n' && pn->last[i] != '\0')
      i++;
    
   if(pn->last[i]=='\n')
      pn->last[i] = '\0';
   else
      while(getchar()!='\n')
         continue;

}

void show_names(const names *pn){
    printf("%s %s\n",pn->first,pn->last);
}

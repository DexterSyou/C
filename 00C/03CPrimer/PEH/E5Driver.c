
#include <stdio.h>
#include <stdlib.h>
#include "E5.h"


#define SIZE 20

int main(void){

    Stack strline;
    InitializeStack(&strline);

    char str[SIZE];
    printf("Please enter an string: \n");
    scanf("%s",str);
    printf("Your string is [ %s ] \n",str); 
    int idx=0;
    Item pushItem;
    while(str[idx]!='\0'){
        pushItem.ch = str[idx];
        if(!FullStack(&strline)){
            Push(pushItem, &strline);  
        }else{
            printf("Stack is full... \n");
        }
        idx++;
    }    
    Item popItem;
    while(!EmptyStack(&strline)){
       Pop(&popItem,&strline);
       printf("Pop a item : %c \n", popItem.ch);
    }


    return 0;
}

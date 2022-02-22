#include <stdio.h>
#include <stdlib.h>
#include "E5.h"

void InitializeStack(Stack *ps){
    ps->top  = -1;
}

bool FullStack(const Stack *ps){
   return  ps->top == MAXSTACK;
}

bool EmptyStack(const Stack *ps){
    return ps->top == -1; 
}

bool Push(Item item, Stack *ps){
    printf("Push a item : %c \n", item.ch);
    ps->top++;
    ps->items[ps->top]=item;
    return true;
}

bool Pop(Item *pitem,Stack *ps){
     char ch;
     ch=(ps->items[ps->top]).ch; 
     ps->top--;
     pitem->ch=ch;
     return true;
}

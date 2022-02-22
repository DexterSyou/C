#ifndef E5STACK_H_
#define E5STACK_H_

#include <stdbool.h>
#define MAXSTACK 10

typedef struct ch{
   char ch;
}Item;

typedef struct stack{
	Item items[MAXSTACK];
	int top;
}Stack;

void InitializeStack(Stack *ps);
bool FullStack(const Stack *ps);
bool EmptyStack(const Stack *ps);
bool Push(Item item, Stack *ps);
bool Pop(Item *pitem,Stack *ps);

#endif


#include <stdbool.h>

#define MAXSTACK 100
typedef struct stack{

	Item items[MAXSTACK];
	int top;
}Stack;

void InitializeStack(Stack *ps);
bool FullStack(const Stack *ps);
bool EmptyStack(const Stack *ps);
bool Push(Item item, Stack *ps);
bool Pop(Item *pitem,Stack *ps);

#include <stdio.h>
#include <stdlib.h>
#include "E3.h"

void InitializeList(List *plist){
     plist->items = 0;
}

bool ListIsEmpty(const List *plist){ 
    return (plist->items == 0);
}

bool ListIsFull(const List *plist){
    return (plist->items== MAXSIZE);
}

unsigned int ListItemCount(const List *plist){
    return plist->items;
}

bool AddItem(Item item,List *plist){
     
    if(plist->items == MAXSIZE) {
        printf("The list is already full...");
        return false;
    }
    plist->entries[plist->items] = item;
    plist->items++;
    return true;
}

void Traverse(const List *plist, void(*pfun)(Item item)){
    int cnt = 0;
    for(;cnt<plist->items;cnt++){
        (*pfun)(plist->entries[cnt]);
    }
}

void EmptyTheList(List *plist){
     plist->items = 0;
}

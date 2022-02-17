 #include <stdio.h>
 #include <stdlib.h>
 #include "pH6queue.h"

 static void CopyToNode(Item item, Node *pn);
 static void CopyToItem(Node *pn, Item *pi);

 void InitializeQueue(Queue *pq){
   pq->front = pq->rear = NULL;
   pq->items = 0;
 }

 bool QueueIsFull(const Queue *pq){
   return pq->items == MAXQUEUE;
 }

 bool QueueIsEmpty(const Queue *pq){
    return pq->items==0; //
 }

 int QueueItemCount(const Queue *pq){
    return pq->items; //
 }

 bool EnQueue(Item item, Queue *pq){

     /*
      1.分配节点Node
      2.赋值节点Node的item
      3.如果队列没有节点  front ---》 Node0
        否则加入队尾， pq->rear队尾节点， pq->rear->next---》Noden 
      4.队尾指针再次指向队尾　
      5.项目加1
     */
     Node *pnew;
     if(QueueIsFull(pq)){
        return false;
     }
     pnew = (Node *)malloc(sizeof(Node));
     if(pnew == NULL){
         fprintf(stderr,"Unable to allocoate memoty!\n");
         exit(1);
     }
     CopyToNode(item,pnew);
     pnew->next = NULL;
     if(QueueIsEmpty(pq)){
         pq->front = pnew;
     }else{
         pq->rear->next = pnew;
     }
     pq->rear = pnew;
     pq->items++;
     return true;
 }

 bool DeQueue(Item *pitem, Queue *pq){
// 队列只能从头节点删除
    Node *pt;
    if(QueueIsEmpty(pq)){
        return false;
    }
    CopyToItem(pq->front,pitem);
    pt=pq->front;
    pq->front = pq->front->next;
    free(pt);
    pq->items--;
    if(pq->items == 0)
       pq->rear = NULL;
    return true;   
 }

 void EmptyTheQueue(Queue *pq){
    Item dummy;
    while(!QueueIsEmpty(pq)){
        DeQueue(&dummy,pq);
    }
 }

 static void CopyToNode(Item item,Node *pn){
    pn->item = item;
 }

 static void CopyToItem(Node *pn,Item *pi){
    *pi =pn->item;
 }

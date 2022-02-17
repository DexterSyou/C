#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "pHAtree.h"

//
static Node *MakeNode(const Item *pi);

//
bool AddItem(const Item *pi,Tree *ptree){

	Node * new_node;
	if(TreeIsFull(ptree)){
	  fprintf(stderr,"Tree is full\n");
	  return false;
	}
    if(SeekItem(pi,ptree).child!=NULL){
	    fprintf(stderr,"Attempted to add duplicate item\n");
	 	return false;
	} 

	new_node=MakeNode(pi);
	if(new_node == NULL){
	  fprintf(stderr,"Counldn't create node\n");
	  return false;
	}

	ptree->size++;
	if(ptree->root == NULL){
	   ptree->root=new_node;
	}else{
	   AddNode(new_node,ptree->root);
	}
	return true;
}

static Node *MakeNode(const Item *pi){
    Node * new_node;
	new_node = (Node *)malloc(sizeof(Node));
	if(new_node !=NULL){
	  new_node->item = *pi;
	  new_node = NULL;
	  new_node = NULL; 
	}
    return new_node;
}


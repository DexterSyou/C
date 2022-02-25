#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "E7tree.h"
//
#define SEPARATOR ' '
//
static void CountWordsFromFile(FILE *fp, Tree *wds);
static void printItem(Item item);
void showWords(const Tree * wds);
char menu(void);
void findWords(const Tree *wds);
//
int main(void){
   //Words Tree
   Tree words;
   InitializeTree(&words); 
   //Open the file
   printf("\n**************STARTING******************\n");
   FILE *fp;
   if((fp=fopen("dat","r"))==NULL){
       fprintf(stderr,"Cannot open the file");
       exit(1);
   }

   //CountWordsFile
   CountWordsFromFile(fp,&words);
   
   char choice;
   while((choice=menu())!='q'){
       switch(choice){
           case 'f':
             findWords(&words);break;
           case 'l':
             //Show Words 
             showWords(&words);break;
           default : puts("Switching error");
       }
   }
   
   printf("\n**************ENDING*******************\n");
}


static void CountWordsFromFile(FILE *fp, Tree *wds){
   int  widx=0;
   char ch;
   char word[WSIZE];
   bool flag = false;
   Item item;
   Item *fdItem;
   while((ch=getc(fp))!=EOF){
       if(ch == SEPARATOR || ch == '\n'){
           word[widx]='\0';
           widx=0;
           flag=true;
       }else{ 
           word[widx++]=ch;
       }
       if(flag){
          if(TreeIsFull(wds)){
              puts("No space in the Tree");
          }else{  
            strcpy(item.word,word);
            if(fdItem=InTree(&item,wds)){
                 fdItem->wordCnt++;
            }else{
                 item.wordCnt = 1; 
                 AddItem(&item,wds);               
            }                
          }
          flag = false;
       }
   }
}
//
static void printItem(Item item){
    printf("Words: %-19s  Conut: %d\n",item.word,item.wordCnt);
}
//
char menu(void){
    int ch;
    puts("l) show List of words    f) find word");
    puts("q) quit");
    while((ch=getchar())!=EOF){
        while(getchar()!='\n')continue;
        if(strchr("lqf",ch)==NULL){
            puts("Please enter an l,f or q:");
        }else{
            break;
        }
    }
    if(ch==EOF){
        ch = 'q';
    }
    return ch;
}
//
void showWords(const Tree * wds){
   if(TreeIsEmpty(wds)){
       puts("No words");
   }else{
       Traverse(wds,printItem);
   }
}
//
void findWords(const Tree *wds){
 
   Item *fdItem;
   Item item;
   if(TreeIsEmpty(wds)){
       puts("No Words.");
       return ;
   }
   
   puts("Please enter your want to find word:  ");
   gets(item.word);
   printf("Your word : %s\n",item.word);
   if(fdItem=InTree(&item,wds)){
       printf("The Count : %d\n",fdItem->wordCnt);
   }else{
       printf("Cannot Found.!!\n");
   }
}

#include <stdio.h>
#include <string.h>
#include <ctype.h>

#include "pHAtree.h"
//
char menu(void);
void addpet(Tree *pt);
void droppet(Tree *pt);
void showpets(const Tree *pt);
void findpet(const Tree *pt);
void printitem(Item item);
void uppercase(char *str);


//*******************************************************************
int main(void){

    Tree pets;
    char choice;

    InitializeTree(&pets);
    while((choice=menu())!='q'){
        switch(choice){
            case 'a':addpet(&pets);break;
            case 'l':showpets(&pets);break;
            case 'f':findpet(&pets);break;
            case 'n':printf("%d pets in clud\n",TreeItemCount(&pets));break;
            case 'd':droppet(&pets);break;
            default:puts("Switching error");         
        }
    }
    DeleteAll(&pets);
    puts("Bye.");
    return 0;
}

char menu(void){
   int ch;
   puts("Nerfville Pet Club Membership Program");
   puts("Enter the letter corresponding to your choice: ");
   puts("a)add apet               l)show list of pets");
   puts("n)number of pets         f)find pets");
   puts("d)delete a pet           q)quit");
   while((ch=getchar())!=EOF){
       while(getchar()!='\n')continue;

       ch = tolower(ch);
       if(strchr("alrfndq",ch)==NULL){
           puts("Please enter an a,l,f,n,d, or q"); 
       }else{
           break;
       }
   }
   if(ch==EOF)
      ch = 'q';
    return ch;
}

void addpet(Tree *pt){
   Item temp;
   if(TreeIsFull(pt)){
      puts("No room in the club");
   }else{
      puts("Please enter name of pet: ");
      gets(temp.petname);
      puts("Please enter pet kind");
      gets(temp.petkind);
      uppercase(temp.petname);
      uppercase(temp.petkind);
      AddItem(&temp,pt);
   }
}


void showpets(const Tree *pt){
    if(TreeIsEmpty(pt)){
          puts("No entries!"); 
    }else{
          Traverse(pt,printitem);
    }
}

void printitem(Item item){
    printf("Pet:%-19s Kind: %-19s\n",item.petname,item.petkind);
}

void findpet(const Tree *pt){
     Item temp;
     if(TreeIsEmpty(pt)){
          puts("No entries!"); 
          return;
     }
     puts("Please enter name of pet you wish to find: ");
     gets(temp.petname);
     puts("Please enter pet kind"); 
     gets(temp.petkind);
     uppercase(temp.petname);
     uppercase(temp.petkind);     
     printf(" %s the %s ",temp.petname,temp.petkind);  
     if(InTree(&temp,pt)){
        printf("is a memmber.\n");
     }else{
        printf("is not a member.\n");
     }
}

void droppet(Tree *pt){
     Item temp;
     if(TreeIsEmpty(pt)){
          puts("No entries!"); 
          return;
     }
     puts("Please enter name of pet you wish to delete: ");
     gets(temp.petname);
     puts("Please enter pet kind"); 
     gets(temp.petkind);
     uppercase(temp.petname);
     uppercase(temp.petkind);     
     printf(" %s the %s ",temp.petname,temp.petkind);
     if(DeleteItem(&temp,pt)){
        printf("is dropped from the club.\n");
     }else{
        printf("is not a member.\n");
     }  
}

void uppercase(char *str){
    while(*str){
        *str = toupper(*str);
        str++;
    }
}

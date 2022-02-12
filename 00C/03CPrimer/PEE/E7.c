#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAXTITL 40
#define MAXAUTL 40
#define MAXBKS  5
//
struct book {
   char  title[MAXTITL];
   char  author[MAXAUTL];
   float value;
   int   del; 
};
//
int choicemenu(void);
//
int main(void){

	struct book library[MAXBKS]={{'\0','\0',0.0,0}};
	int count = 0;
	int index, filecount;
	FILE *pbooks;
	int size = sizeof(struct book);

    if((pbooks = fopen("te7book.dat","r+b"))==NULL){
	  fputs("Can't open te7book.dat file.\n",stderr);
	  exit(1);
	}
	rewind(pbooks);
    while(count<MAXBKS && fread(&library[count],size,1,pbooks)==1){
	   if(count == 0)
	   puts("Current contents of pEEbook.dat");
	   printf("No:%d, %s by %s: $%.2f\n",(count+1),library[count].title,
			   library[count].author,library[count].value);
	   count++;
	}
		
    filecount = count;
    if(count==MAXBKS){
	    puts("book full...");
		exit(2);
	}
	puts("Please add new book titles.");
    puts("Press [enter] at the start of a line to stop.");

	while(count < MAXBKS && gets(library[count].title)!=NULL
			&&library[count].title[0]!='\0'){
	   puts("Now enter the author.");
	   gets(library[count].author);
	   puts("Now enter the value.");
	   scanf("%f",&library[count++].value); // .的运算级 比 & 优先
	   while(getchar()!='\n')
		   continue;
	   if(count < MAXBKS)
		   printf("Enter the next title.\n");
	}

	if(count>0){
	   puts("Here is the list of your books: \n");
	   for(index = 0; index < count;index++){
	      printf("No:%d, %s by %s : $%.2f\n",(index+1),library[index].title,
				  library[index].author, library[index].value);
	      fwrite(&library[filecount],size,count-filecount,pbooks);
	   }
	}else{
       puts("No books? Too bad.\n");
	}
	//*********** 
    while(true){
	   int  choice;
	   int  ch;
	   printf("which book do you want DELETE or UPDATE.\n");
	   if(scanf("%d",&choice)!=1){
	      break;
	   }
	   printf("[1]Delete or [2]Update\n");
	   scanf("%d",&ch);
	   getchar();//
       switch(ch){
	    case 1:
			library[choice-1].del=1;
			puts("Deleted!!");
			break;
		case 2:
			printf("Enter the book title: ");
            gets(library[choice-1].title);
			printf("Enter the author: ");
			gets(library[choice-1].author);
			printf("Enter the value: ");
			scanf("%f",&library[choice-1].value);
			while(getchar()!='\n')
				continue;
			break;
	    default:break;
	   }
	}
	fclose(pbooks);
	
	if((pbooks=fopen("te7book.dat","w"))==NULL){
	   puts("Can't open file.\n");
	   exit(-1);
	}
	for(int i=0;i<count;i++){
	   if(library[i].del != 1){
	     fwrite(&library[i],size,1,pbooks);
	   }
	}
	puts("Done.!!");
	fclose(pbooks);
	return 0;
}




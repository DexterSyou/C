#include <stdio.h>
#define MAXTITL 41
#define MAXAUTL 31
#define MAXBKS  3

struct book {
   char  title[MAXTITL];
   char  author[MAXAUTL];
   float value;
};

//
void sortByValue(struct book library[MAXBKS]);
//
int main(void){

	struct book library[MAXBKS];
	int count = 0;
	int index;
	printf("Please enter the book title.\n");
	printf("Press [enter] at the start of a line to stop.\n");
    while(count<MAXBKS && gets(library[count].title)!=NULL 
			           && library[count].title[0] != '\0'){	
	   printf("Now enter the author.\n");
	   gets(library[count].author);
	   printf("Now enter the value.\n");
	   scanf("%f",&library[count++].value); // .的运算级 比 & 优先
	   while(getchar()!='\n')
		   continue;
	   if(count < MAXBKS)
		   printf("Enter the next title.\n");
	}

	if(count>0){
	   printf("Here is the list of your books: \n");
	   for(index = 0; index < count;index++){
	      printf("%s by %s : $%.2f\n",library[index].title,
				  library[index].author, library[index].value);
	   }
       //
	   printf("The sorted by value: \n");
	   sortByValue(library);
       //

	}else{
       printf("No books? Too bad.\n");
	}
	
	return 0;
}

void sortByValue(struct book library[MAXBKS]){
	struct book *sortV[MAXBKS];
	struct book *temp;
	for(int i=0;i<MAXBKS;i++){
	   sortV[i] = &library[i];
	}
//	标题运用strcmp比较即可
    for(int i=1;i<MAXBKS;i++){
	   for(int j=i;j>0;j--){
		   if((sortV[j]->value) < (sortV[j-1]->value)){
		      temp       = sortV[j];
			  sortV[j]   = sortV[j-1];
		      sortV[j-1] = temp;
		   }
	   }
	} 
 //
   for(int idx=0;idx<MAXBKS;idx++){
	      printf("%s by %s : $%.2f\n",sortV[idx]->title,
				  sortV[idx]->author, sortV[idx]->value); 
   }	  
    

}



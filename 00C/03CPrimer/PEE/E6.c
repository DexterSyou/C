#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//
#define SIZE 100
//
struct data{
   char   position[3];
   char   name[50];
   char   team[50];
   int    shots;
   int    goals;
   double rate;
};
//
void show(struct data *);
//
int main(void){
 
	FILE *fp;
	struct data players[5]; 
	int idx=0;
	//
	char line[SIZE];
	char *word;
	char *data[5];
	const char *sep=",";
	//
	if((fp=fopen("te6.dat","r"))==NULL){
	    printf("Can't open the file.\n");
		exit(1);
	}
    
	int shots=0;
	int goals=0;
	char *find;
	int i;
    while(fgets(line,SIZE,fp)!=NULL){	
       
	   if((find=strchr(line,'\n'))!=NULL){
	      *find='\0';
	   }
	   puts(line);
	   for(i=0,word=strtok(line,sep);word;word=strtok(NULL,sep),i++){
	      data[i]=word;
	   }
	   
	   
       strcpy(players[idx].position,data[0]);
	   strcpy(players[idx].name,data[1]);
	   strcpy(players[idx].team,data[2]);
	   shots=atoi(data[3]);
	   players[idx].shots=shots;
	   goals=atoi(data[4]);
	   players[idx].goals=goals;
	   players[idx].rate = (goals*1.0) / shots;       
	   idx++;        
	}

	show(players);
	fclose(fp);
}

void show(struct data *ptr){
    printf("The player Goals List.\n");
    printf("P\tPLAYER\t\t\t\tTEAM\t\tPLAYS\tGOALS\tSCCEED RATE\n");
	for(int i=0;i<5;i++){
	    printf("%s\t%s\t%s\t%d\t%d\t%0.2f\n",
				ptr->position,ptr->name,ptr->team,ptr->shots,ptr->goals,ptr->rate);
		ptr++;
	}
}
/* 6.
 * struct[]
 *   position name team plays goals rate 
 * .dat
 *   position players team plays goals  
 *   ***数据假设为足球射手榜数据数据，不用棒球
 *    
 * 从文件读入数据，显示出来
 * 不使用二进制存储
 * 使用文本文件，用空格分隔
 */

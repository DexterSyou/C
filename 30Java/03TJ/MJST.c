#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NAME_SIZE 30 // 预估20个
#define JTNM_SIZE 50
#define CONTENT_SIZE 200

const char *jtbd[]={"    public static void main(String []args){",   
                    "    }",
					"}"
                      };
const char  jex[] = ".java"; 
//
void fpnewline(FILE *);
//
int main(int argc, char *argv[]){

   if(argc!=2){
	   fprintf(stderr,"Usage. MJST JavaName\n");
	   exit(1);
   }

   char jName[NAME_SIZE];  
   char jhead[JTNM_SIZE];
   //
   strncpy(jName,argv[1],strlen(argv[1]));
   strcat(jName,jex);
   //
   strcpy(jhead,"public class ");
   strcat(jhead,argv[1]);
   strcat(jhead," {");

   printf("Create the file %s\n.",jName);
   FILE * fp;

   if((fp=fopen(jName,"w"))==NULL){
     fprintf(stderr,"Can't open the file!\n");
	   exit(56);
   }
   //
   fputs(jhead,fp);
   for(int i=0;i<3;i++){
     fpnewline(fp);
     fputs(jtbd[i],fp);
   }

   fclose(fp);
   return 0;
}

void fpnewline(FILE *fp){
    for(int i=0;i<5;i++){
		fputs("\n",fp);
	}
}

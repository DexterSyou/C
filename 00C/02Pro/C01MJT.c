#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NAME_SIZE 50 // 预估20个
#define JTNM_SIZE 50
#define CONTENT_SIZE 200

const char *jtbd[]={"    public static void main(String []args){",   
                    "    }",
					"}"
                      };
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
   strcpy(jName,argv[1]);
   
   //Create file.
   FILE * fp;
   if((fp=fopen(jName,"w"))==NULL){
     fprintf(stderr,"Can't open the file!\n");
	 exit(56);
   }else{
     printf("Create the file %s\n.",jName);
   }
   //
   strcpy(jhead,"public class ");
   char *find;
   find = strchr(jName,'.');
   if(find) 
	  *find = '\0';
   strcat(jhead,jName);
   strcat(jhead," {");
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

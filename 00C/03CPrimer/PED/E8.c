
#include <stdio.h>
#include <stdlib.h>
//
#define ARGC_LEAST_SIZE 2
//
static unsigned int cnt;
//
void countChFromStream(FILE *fp, int inputch);
//
int main(int argc, char *argv[]){

    if(argc < ARGC_LEAST_SIZE){
        printf("Usage : a.out  param1 ... \n");
        printf("[param1] is a char, [...] is 0 ro much filename.\n"); 
        exit(1);
    }

    char *filename[argc-2];
    int inputch = argv[1][0];

    // 保存命令行中FILE NAME
    if(argc > ARGC_LEAST_SIZE){
         for(int i=0;i<(argc-ARGC_LEAST_SIZE);i++){
            filename[i] = argv[i+2];
         }
    }
    
    // ?算各FILE中指定字符的个数
    if( filename[0][0] != '\0'){
        FILE *fp;
        for(int i=0;i<(argc-ARGC_LEAST_SIZE);i++){

            if((fp=fopen(filename[i],"r"))==NULL){
                printf("Can't open the %s file.\n",filename[i]);
                exit(56);    
            }  
            countChFromStream(fp,inputch);
            fclose(fp);
        }
    }else{
        countChFromStream(stdin,inputch);
    }

    printf("THE CHAR : [ %c ] , COUNTS : [%d] \n", inputch, cnt);

    return 0;
}

void countChFromStream(FILE *fp, int inputch){
   int ch;
   while((ch=fgetc(fp))!=EOF){
       if(ch == inputch)
          cnt++;
   }
}

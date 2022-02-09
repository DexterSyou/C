#include <stdio.h>
#include <stdlib.h>
#include <time.h>
//
void eD(int [][30]);
//
int main(void){
   
  int  numAry[20][30];
  char chsAry[20][31];
  srand((unsigned int)time(0));

  for(int i=0;i<20;i++)
	  for(int j=0;j<30;j++)
         numAry[i][j] = rand() % 10;
  //ED.c
  

  //
  char ch;
  int  j=0;
  for(int i=0;i<20;i++){
	 for(j=0;j<30;j++){
	     switch(numAry[i][j]){
			case 0:ch=' '; break;
			case 1:ch='.'; break;
			case 2:ch='*'; break;
			case 3:ch=' '; break;
			case 4:ch='o'; break;
			case 5:ch='o'; break;
			case 6:ch='*'; break;
			case 7:ch='*'; break;
			case 8:ch=' '; break;
			case 9:ch=' '; break;
            default: break;
		  }
		 chsAry[i][j]=ch; 
	  }
	  chsAry[i][j]='\0';
   }
  //
  FILE *fp;
  if((fp=fopen("out.dat","w"))==NULL){
      printf("Can't open the file.\n");
	  exit(3);
  }
  //
  for(int i=0;i<20;i++){
    fprintf(fp,"%s\n",chsAry[i]); }
  fclose(fp);
  return 0;
}

void eD(int ary[][30]){
/*
 * 1 1 1 1 1 1 1 1 1 
 * 1               1 
 * 1               1
 * 1               1
 * 1 1 1 1 1 1 1 1 1
 */ 
	int n1=0;
	int n2=0;
	int n3=0;
	int n4=0;
	int v=0;
	for(int i=0;i<20;i++)
      for(int j=0;j<30;j++){
	       v = ary[i][j];
	       if((0==i) && (0==j)){
		        n1=ary[0][1]; 
                n2=ary[1][0];
                if((v-n1)>1 && (v-n2)>1 ){
			      ary[i][j] = (n1+n2)/2;
			    }
		   }else if(i==0&&j<29){
		       n1=ary[0][j-1];
			   n2=ary[0][j+1];
			   n3=ary[1][j];
			   if(v-n1>1 && v-n2>1 && v-n3 >1){
			     ary[i][j] = (n1+n2+n3) / 3;
			   }
		   }else if(j==29){
		    //.......
		   }
	  }
	  //....
}

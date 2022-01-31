#include <stdio.h>

int main(void){

  char ch;
  while((ch=getchar())!=EOF){
    
  if(ch < ' '){
     switch(ch){
	    case '\n':
			printf("\\n\n");break;
		case '\t':
			printf("\\t\n");break;
	    default:
			printf("^%c:%d \n",ch +64,ch);
	 }		
   }else{
     printf("%c:%d \n",ch,ch);
	 getchar();
   }
    
    //cnt is 10 printf("\n") cnt=0;
  }
  return 0;
}

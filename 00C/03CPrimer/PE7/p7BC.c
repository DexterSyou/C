#include <stdio.h>
#include <ctype.h>

int main(void){

  char ch;
  printf("Give me a letter of the alphabet, and I will give ");
  printf("an animal name\nbeginning with that letter.\n");
  printf("Please type in a letter: type # to end my act.\n");
  while((ch=getchar())!='#'){
     if('\n'==ch)
		 continue;
	 if(islower(ch))
		 switch(ch){
		    case 'a': printf("argali, a wild sheep of Asia  \n");  
					  break;
			case 'b': printf("babirusa, a wild pig of Malay \n"); 
					  break;	
		    case 'c': printf("coati, racoonlike nammal \n");  
					  break;	
			case 'd': printf("desman,aquatic,molelike critter\n"); 
					  break;	 
			case 'e': printf("echidna, the spiny anteater\n");
					  break;	
			case 'f': printf("fisher,brownish marten\n");
					  break;
			default : printf("That's a stumper!\n");    
					  break; 
		 }
     else
		 printf("I recognize only lowercase letters.\n");
     while(getchar()!='\n')
		 continue;
	 printf("Please type another letter or a #.\n");
  }
  printf("Byte!\n");
  return 0;
}
/*
 *  switch(expression){
 *     case label1: statements;break;
 *     ...
 *     case labeln: statements;break;
 *     default : statements;break;
 *  }
 *  expression 为整形，lebel也得为整形
 *  可多重标签
 *  case 1:
 *  case 2:
 *        statements；
 *
 *
 *
 */














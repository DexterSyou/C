#include <stdio.h>

void display(char cr, int lines, int width);
int main(void){
   
   int ch;
   int rows, cols;
   printf("Enter a character and two integers: \n");
   while((ch=getchar())!='\n'){
      scanf("%d %d",&rows,&cols);
  	  display(ch,rows,cols);
	  /*  p86.c
	   *  if(scanf("%d %d",&rows,&cols)!=2)
	   *     break;
	   *  while(getchar()!='\n')
	   *     continue;
	   */
	  printf("Enter another character and two integers: \n");
	  printf("Enter a newline to quit.\n");
   }
   printf("Bye.\n");
   return 0;
}

void display(char cr, int lines,int width){

	int row, col;
	for(row=1;row <=lines;row++){
	   for(col=1;col<=width;col++)
		   putchar(cr);
	   putchar('\n'); 
	}
}
/*  
 *  getchar()是stdio.h中的库函数
 *  实际上是(按的键是放进缓冲区了,然后供程序getchar(): 
 *           输入设备->内存缓冲区->getchar() )
 *  如果stdin有数据的话不用输入它就可以直接读取了，第一次getchar()时，需要人工的输入，
 *  如果你输了多个字符，以后的getchar()再执行时就会直接从缓冲区中读取了。
 *
 *  键盘输入的字符都存到缓冲区内, 一旦键入回车, getchar就进入缓冲区读取字符,一次只返回
 *  第一个字符作为getchar函数的值
 *  ########?1
 *  char ary[SIZE];
 *  scanf("%s", ary)
 *  printf("your first  str : %s",ary);
 *  printf("your second str ...");
 *  输入abc（enter）
 *  第一次输入并按下回车的时候，控制台一共获得了四个字符，分别是:a、b、c、回车
 *  scanf()方法遇到非字符的时候会结束从控制台的获取，所以在输入’abc’后，
 *  按下 ‘回车（enter）’ 的同时，将’abc’这个值以字符串的形式赋值给了类型为 ‘char’ 的 ‘ary’ 数组，
 *  ‘回车(enter)’ 保存在控制台输入的缓冲区，然后继续执行下一段输出代码，然后又要求用户输入。
 *  *****
 *  *前面的scanf()在读取输入时会在缓冲区中留下一个字符’\n’（输入完按回车键所致），
 *  *接下来的scanf()就不会等待从键盘键入字符，
 *  *而是会直接取走这个“无用的”回车符，从而导致读取有误。
 *  *****
 *  getchar 从缓冲区读走一个字符，相当于清除缓冲区。
 *  printf("yur first str : %s",ary);
 *  getchar();
 *
 *  ########?2 如果在第一次输入ab后加一个空格再回车???
 *  scanf("%s",&m);
 *  %s的作用是“把输入解释成字符串。从第一个非空白字符开始，到下一个空白字符之前的所有字符都是输入。
 *  scanf把输入的 ab空格+回车 就理解为 ab+回车 (ab后面没有空格)，但是依然以 ab空格+回车 的形式存储缓冲区。
 *  
 *  清除剩下的输入：while(getchar()!='\n') continue;
 *  
 *
 *
 *  #######?3
 *  getchar : 从缓冲区读取每个字符，包括空格、制表符和换行符
 *  scanf   : 读取数字时则会跳过空格、制表符和换行符
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


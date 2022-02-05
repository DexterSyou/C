#include <stdio.h>
#include <string.h>
//
#define  PBE_SIZE     80
#define  PBF_SIZE     30
#define  PBF_BUGSIZE  13
#define  PBGHI_ANSWER  "Grant"
#define  PBGHI_MAX     40 
//
void fit(char *string, unsigned int size);
void pBD(void);
void pBE(void);
void pBF(void);
void pBGHI(void);
//
int main(void){
  //
  //pBD();
  //
  //pBE();
  //
  //pBF();
  //
  pBGHI();
  //
}

// strlen
void pBD(void){
  char mesg[] = "Hold on to your hats, hackers.";
  puts(mesg);
  fit(mesg,7);
  puts(mesg);
  puts("Let's look at some more of the string.");
  puts(mesg+8);
}

void fit(char *string, unsigned int size){
	if(strlen(string) > size)
    //strlen 得到字符串的长度
		*(string+size) = '\0';
}

// strcat
void pBE(void){
   char flower[PBE_SIZE];
   char addon[] = "s smell like old shoes.";
   puts("What is your favorite flower?");
   gets(flower);
   strcat(flower,addon); 
   //strcat 将第二个字符串一份拷贝添加到第一个字符串的结尾
   //strcat返回它第一个参数的值，第一个字符串的第一个字符的地址。
   puts(flower);
   puts(addon);
}

//
void pBF(void){
  char flower[PBF_SIZE];
  char addon[]="s smell like old shoes.";
  char bug[PBF_BUGSIZE];
  int  available;

  puts("What is your favorite flower?");
  gets(flower);
  if((strlen(addon)+strlen(flower)+1) <= PBF_SIZE)
        strcat(flower,addon);
  puts(flower);
  puts("What is your favorite bug?");
  gets(bug);
  available=PBF_BUGSIZE - strlen(bug) - 1;
  strncat(bug, addon,available);
  puts(bug);

}
//
void pBGHI(void){
  
	char try[PBGHI_MAX];
    puts("Who is buried in Grant 's tomb");
	gets(try);
	//pBG try!=PBGHI_ANSWER 比较的事两个不同的地址
    while(strcmp(try,PBGHI_ANSWER) != 0){
	// while(strcmp(try,PBGHI_ANSWER))
	//strcmp 比较的是字符串，只看第一个空字符之前的部分 
	/* pBH.c 
	 * strcmp 根据系统依赖于不同的C实现
	 *   两个字符串相等返回0
	 *   第一个字符串<第二个字符串，返回 -1（负数）      
	 *   第一个字符串>第二个字符串，返回  1（正数）
	 *比较是按照字母表顺序排序的，一般是ASCII值
	 */
	   puts("No, that 's wrong. Try again. ");
	   gets(try);
	}
	puts("That 's right!");
    //pBI.c
	/* 
	 * char input[LIM][SIZE]
	 * while( ct<LIM && gets(input[ct]) != NULL && 
	 *        strcmp(input[ct],STOP) != 0 )
     * #define STOP "quit"
     * 
	 * while( ct<LIM && gets(input[ct]) != NULL
	 *        && input[ct][0] != '\0')
	 * 
	 *
	 */
}

//strncmp
/*  
 * void pBJ(void){
 *   
 *     strncmp(string1,string2,number);
 * }
 */





















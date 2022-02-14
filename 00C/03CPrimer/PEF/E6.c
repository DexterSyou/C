#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

struct {
  unsigned int ID: 8;
  unsigned int SIZE: 8;
  unsigned int ALIGNMENT: 8;
  unsigned int BOLD: 8;
  unsigned int ITALIC: 8;
  unsigned int UNDERLINE: 8;
}font;
//
void menu(void);
void show_setting(void);
int menu_choice(void);
void end(void);
void change_font(void);
void change_size(void);
void change_alignment(void);
void toggle_bold(void);
void toggle_italic(void);
void toggle_underline(void);
//
int main(void){
  
  font.ID = 1;
  font.SIZE = 12;
  font.ALIGNMENT=0;
  font.BOLD=0;
  font.ITALIC=0;
  font.UNDERLINE=0;
  system("clear");
  while(menu_choice()){
    system("clear");
  }

  return 0;
}

void menu(void){
   
 static char * menu_str[]={
    "Please select the menu label you need",
    "f) change font   s)change size    a)change alignment",
	"b) toggle bold   i)toggle italic  u)toggle underline",
	"q) quit"
 };

 for(int i=0;i<sizeof(menu_str)/sizeof(menu_str[0]);i++)
	 puts(menu_str[i]);
}


void show_setting(void){
  int x;
  char tmp[10];
  static char *set[]={
     "ID",
	 "SIZE",
	 "ALIGNMENT",
	 "B",
	 "I",
	 "U"
  };

  const int width=15;
  for(int i=0;i<sizeof(set)/sizeof(set[0]);i++){
      printf("%*c%s%*c",(int)(width-strlen(set[i]))/2,' ',set[i],(int)(width-strlen(set[i]))/2,' ');
  } 
  putchar('\n');
  printf("%*c%d%*c ",(width-sprintf(tmp,"%d",font.ID))/2,' ',font.ID,
		   (width - sprintf(tmp,"%d",font.ID)) / 2,' ' );
  printf("%*c%d%*c ",(width-sprintf(tmp,"%d",font.SIZE))/2,' ',font.SIZE,
		   (width - sprintf(tmp,"%d",font.SIZE)) / 2,' ' );
  switch(font.ALIGNMENT){
	  case 0:
		  printf("%*c%s%*c",(int)(width-strlen("left"))/2,' ',"left",(int)(width-strlen("left"))/2,' ');
		  break;
	  case 1:
		  printf("%*c%s%*c",(int)(width-strlen("center"))/2,' ',"center",(int)(width-strlen("center"))/2,' ');
		  break;
	  case 2:
		  printf("%*c%s%*c",(int)(width-strlen("right"))/2,' ',"right",(int)(width-strlen("right"))/2,' ');
		  break;
	  default:
		  printf("%*c%s%*c",(int)(width-strlen("Unknow type"))/2,' ',"Unknow type",
				  (int)(width-strlen("Unknow type"))/2,' ');
  }
  
  
   
  printf("%*c%s%*c ",(int)(width-strlen(font.BOLD?"on":"off"))/2,' ',font.BOLD?"on":"off",
		   (int)(width - strlen(font.BOLD?"on":"off")) / 2,' ' ); 
  printf("%*c%s%*c ",(int)(width-strlen(font.ITALIC?"on":"off"))/2,' ',font.ITALIC?"on":"off",
		   (int)(width - strlen(font.ITALIC?"on":"off")) / 2,' ' );
  printf("%*c%s%*c ",(int)(width-strlen(font.UNDERLINE?"on":"off"))/2,' ',font.UNDERLINE?"on":"off",
		   (int)(width - strlen(font.UNDERLINE?"on":"off")) / 2,' ' );
  puts("\n");
}
//
int menu_choice(void){
   void(* menufun[])(void) = {end,change_font,change_size,change_alignment,
                                    toggle_bold,toggle_italic,toggle_underline};

   const char *label="qfsabiu";
   char choice;
   char *find;
   int cmd=0;
   show_setting();
   menu();
   while(!scanf(" %c",&choice)||!(find=strchr(label,tolower(choice)))){
     fputs("Invalid choice, please re-select",stderr);
	 while(getchar()!='\n');
   }

   while(getchar()!='\n');
   cmd=find-label;
   menufun[cmd]();
   return cmd;
}

void end(void){
  puts("Bye !");
}


void change_font(void){
   unsigned int n = 0;
   puts("Please enter the ID of your favorite font");
   while(!scanf("%d",&n) || n>255){
      if(n>255){
	    fputs("Err: ID cannot exceed 0~255\n",stderr);
	  }else{
	    fputs("Err: Illegal input,Please try again.\n",stderr);
	  }
	  while(getchar()!='\n');
   }
   while(getchar()!='\n');
   font.ID = n;
}

void change_size(void){
   unsigned int n = 0;
   puts("Please enter the font size you want set");
   while(!scanf("%d",&n) || n>127){
      if(n>127){
	    fputs("Err: cannot exceed 0~127\n",stderr);
	  }else{
	    fputs("Err: Illegal input,Please try again.\n",stderr);
	  }
	  while(getchar()!='\n');
   }
   while(getchar()!='\n');
   font.SIZE = n;
}

void change_alignment(void){

   unsigned int n = 0;
   puts("Please choose the alignment method");
   puts("1)left  2)center 3)right");
   while(!scanf("%d",&n) || n>3){
      if(n>3){
	    fputs("Err:  cannot exceed 0~3\n",stderr);
	  }else{
	    fputs("Err: Illegal input,Please try again.\n",stderr);
	  }
	  while(getchar()!='\n');
   }
   while(getchar()!='\n');
   font.ALIGNMENT = n;

}

void toggle_bold(void){

   unsigned int n = 0;
   puts("Whether tp open hold or not");
   puts("0) close   1)open");
   while(!scanf("%d",&n) || n>1){
      if(n>1){
	    fputs("Err: ID cannot exceed 0~1\n",stderr);
	  }else{
	    fputs("Err: Illegal input,Please try again.\n",stderr);
	  }
	  while(getchar()!='\n');
   }
   while(getchar()!='\n');
   font.BOLD = n;

}

void toggle_italic(void){

   unsigned int n = 0;
   puts("Whether tp open italic or not");
   puts("0) close   1)open");
   while(!scanf("%d",&n) || n>1){
      if(n>1){
	    fputs("Err: ID cannot exceed 0~1\n",stderr);
	  }else{
	    fputs("Err: Illegal input,Please try again.\n",stderr);
	  }
	  while(getchar()!='\n');
   }
   while(getchar()!='\n');
   font.ITALIC = n;
}

void toggle_underline(void){


   unsigned int n = 0;
   puts("Whether tp open underline or not");
   puts("0) close   1)open");
   while(!scanf("%d",&n) || n>1){
      if(n>1){
	    fputs("Err: ID cannot exceed 0~1\n",stderr);
	  }else{
	    fputs("Err: Illegal input,Please try again.\n",stderr);
	  }
	  while(getchar()!='\n');
   }
   while(getchar()!='\n');
   font.UNDERLINE = n;
}


/*
 * unsigned int font = 8576;
 * unsigned int f = fond & ((~0) >> (CHAR_BIT * sizeof(unsigned int)-21));
 * ##### (font &~((0xff)<<(21-8)))|(n<<(21-8))
 * id:  f>>(21-8)
 * ##### (font &~((0xff)<<(21-8)))|(n<<(21-8))
 *
 * size:(f>>(21-16))&0xff; 
 * ##### (font &~((0xff)<<(21-16)))|(n<<(21-16))
 *
 * alignmet: (f>>(21-18))&3
 * ##### (font &~(3<<3))|((n-1)<<3)
 *
 * bold: (f>>2)&1
 * ##### (font & ~(1<<2)) | (v<<2)
 *
 * italic:(f>>1)&1
 * ##### (font & ~(1<<1)) | (n << 1)
 *
 * underline:f&1
 * ##### (font &~(1))|n
 *
 */



















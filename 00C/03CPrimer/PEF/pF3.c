#include <stdio.h>
#define YES    1
#define NO     0
//
#define SOLID  0 
#define DOTTED 1
#define DASHED 2
//
#define BLUE   4
#define GREEN  2
#define RED    1
//
#define BLACK  0
#define YELLOW  (RED | GREEN)
#define MAGENTA (RED | BLUE)
#define CYAN    (GREEN | BLUE)
#define WHITE   (RED | GREEN | BLUE)

const char *colors[8] = {"black","red","green","yellow",
                         "blue","magenta","cyan","white"};
struct box_pros{
  unsigned int opaque       :1;
  unsigned int fill_color   :3;
  unsigned int              :4;
  unsigned int show_border  :1;
  unsigned int border_color :3;
  unsigned int border_style :2;
  unsigned int              :2; 
};

void show_settings(const struct box_pros *pb);

int main(void){
  
	struct box_pros box = {YES, YELLOW, YES, GREEN, DASHED};
    printf("Original box setting:\n");
    show_settings(&box);
	box.opaque = NO;
	box.fill_color = WHITE;
	box.border_color = MAGENTA;
	box.border_style = SOLID;
	printf("\nModified box setting:\n");
    
	show_settings(&box);
	return 0;
}

void show_settings(const struct box_pros *pb){
  printf("Box is %s.\n",pb->opaque==YES?"opaque":"transparent");
  printf("The fill color is %s.\n",colors[pb->fill_color]);
  printf("Border %s.\n",pb->show_border==YES?"shown":"not shown");
  printf("The border color is %s.\n",colors[pb->border_color]);
  printf("The border style is ");
  switch(pb->border_style){
    case SOLID :printf("solid.\n");break;
    case DOTTED:printf("dotted.\n");break;
    case DASHED:printf("dashed.\n");break;
    default: printf("unknow type.\n");break;
  }
}

/*
 * 位字段
 * struct {
 *   unsigned int autfd:1;
 *   unsigned int code: 2;
 * }
 * 
 * 边界对齐
 * 
 * struct {
 *   unsigned int f1:1;
 *   unsigned int   :2; **有2bit间隙
 *   unsigned int f2:1;
 *   unsigned int   :0;
 *   unsigned int f3:1;  **f3存储在下一个int
 * }
 *
 */

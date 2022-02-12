#include <stdio.h>
#include <string.h>

struct namect {
  char fname[20];
  char lname[20];
  int  letters;
};

void getinfo(struct namect *);
void makeinfo(struct namect *);
void showinfo(const struct namect *);

int main(void){
  
	struct namect person;
	getinfo(&person);
	makeinfo(&person);
	showinfo(&person);

	return 0;
}
// struct namect getinfo(void)
void getinfo(struct namect * pst){

	printf("Please enter your first name.\n");
	gets(pst->fname);
	printf("Please enter your last name.\n");
	gets(pst->lname);
	//定义结构 struct namect temp
	//input msg into temp
	//return  temp
}
//struct namect makeinfo(struct namect info)
void makeinfo(struct namect *pst){
  pst->letters = strlen(pst->fname) + strlen(pst->lname);
  // info.letters = ...
  // return info
}

//void showinfo(const struct namect info)
void showinfo(const struct namect *pst){
  printf("%s %s, your name contains %d letters.\n",pst->fname,pst->lname,pst->letters);
  //show info
}






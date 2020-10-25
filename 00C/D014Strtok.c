#include <stdio.h>
#include <string.h>

int main(void){
  char test[80];
  char *word;
  char *seq="\\/:;=-.";
  int i=0;
  strcpy(test,"This;is;.a:test:of=the/string\\tokenizer-function.");
  for(word=strtok(test,seq);word;word=strtok(NULL,seq),i++){
    printf("str[%d]:%s  \n",i+1, word);
  }
  return 0;
}

#ifndef NAMES_H_
#define NAMES_H_

#define SLEN 32

struct names_st{
   char first[SLEN];
   char last[SLEN];
};

typedef struct names_st names;

#endif

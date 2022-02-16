/*
 * **1. 
 * *a 5280 * miles
 * *b 4 * 4 + 4  
 * *c 6
 * * y = y+5
 *   berg = berg + 5 * lob
 *   est  = berg + 5 / y + 5
 *   nilp = lob * -berg + 5
 * **2. #define NEW(X) ((X)+5) 
 *
 * **3. #define MIN(x,y) ((x)>(y)?(y):(x))
 * 
 * **4. #define EVEN_GT(X,Y) ((X)%2==0&&(X)>(Y)?1:0)
 *
 * **5. #define FMT(X,Y) printf(#x " is %d and " #y " is %d\n", X,Y)
 *
 * **6. 
 * *a #define VAL 25
 * *b #define SPACE ' '
 * *c #define PS() putchar(' ')
 * *d #define BIG(X) ((X)+3)
 * *e #define SUMSQ(X,Y) ((X)*(X)+(Y)*(Y))
 *
 * **7.
 *  #define PI(X) printf("name " #X ": value:%d: address:%p",X,&X)
 *  
 * **8.
 *  #define BLOCK
 *  #if defined(BLOCK)
 *     ...
 *  #endif
 *  
 * **9. 
 *  #define PR_DATE
 *  #ifdef PR_DATE
 *    printf("%s",__DATE__);
 *  #endif 
 * **10.sqrt 接受double类型，argv[1] 为指针指向字符串
 *
 * **11.
 *    qsort((void *)scores,(size_t)1000,sizeof(double),comp)
 *    int comp(const void *p1, const void *p2){
 *        const int *a1 =p1;
 *        const int *a2 =p2;
 *    
 *        if(*a1 > *a2){
 *           return -1; 
 *        }else if(*a1==*a2){
 *           return 0;
 *        }else{
 *           return 1;
 *        }
 *    }
 *
 * **12.
 *    a. memcpy(data1,data2,100*sizeof(double))
 *    a. memcpy(data1,data2+200,100*sizeof(double));
 */

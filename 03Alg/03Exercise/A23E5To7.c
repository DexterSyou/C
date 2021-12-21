2.3-5
//sort the array 
merge_sorted

int binarySearch(int array[], ){
  begin , end = array.length, mid;
  while(begin <= end){
     mid = end + begin / 2 
     if （array[mid] < key）{
         begin = mid;
     }
     if(array[mid] > key) {
         end = mid;
     }
     if(array[mid] == key){
        return mid;
    }
  }
  return -1;
}
二分查找树
层数 lgn
层级总时间为常量级别c

T（n）= clgn
2.3-6
  如果改用二分查找来替代第5~7行代码，那么二分查找i的时间开销将会是θ(lgn)，
  但是将A[i..j-1]的元素全部往后赋值的时间开销依然是θ(n)，则最终整个INSERTION-SORT的时间开销依然是θ(n^2) 

2.3-7  
  a+b = x  S|(a,b...n) , n > 2
  1.
  排序S        merge_sort
  查找S中a，b   binarySearch
  2.其他
  

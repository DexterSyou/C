# coding: UTF-8

s1='index lucy lucky goods'

#1
result = 'x' in s1
print(result)

#2
position = s1.find('R')
print(position)
position = s1.find('l')
print(position)
p=s1.find('l',position+1,len(s1)) #查找范围
print(p)

#3
url='http://www.baidu.com/img/bd_logol.png'
p=url.rfind('/')
filename=url[p+1:]
print(filename)
print(url.endswith('.png'))

#4
print('The {} Str : {} '.format('Moto',s1))
print(s1.replace(' ','$',2))

#5
msg='上课认真听讲！！！'
result=msg.encode('UTF-8') # 字节表示形式
print("The encode : %s" % result)
m=result.decode('UTF-8')
print(m)


'''
#字符串的内建函数
 find #返回第一次找到字符下标的位置,没有找到，返回-1 
 lfind
 rfind
 index # 跟find功能相似，没有找到的情况下，抱异常
 rindex
 lindex

 replace
 
 编码 encode ， 解码decode

 startswith
 endswith
 isalpha 是否是字母 
 isdigit 是否是数字

'''

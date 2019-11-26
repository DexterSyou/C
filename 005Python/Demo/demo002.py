# coding : UTF-8
#1
print("-1------------------")
person='Andy'
address='the earth'
phone='1234567890'
print('The Name: %s, His Addrres: %s And His phone number: %s' % (person, address, phone))

year=2019
salary=8899.99
print("The %06d salary %.1f" % (year,salary))

#2
print("-2-------------------")
age=20
message = 'I am {} years old ，study in {} '.format(age , "大学")
print(message)

#3
print("-3----------------------")
name = input("Please enter your name:  ")
print(name)

'''
###<1> 格式化输出
 字符串的格式化输出：
 @1 占位符  %s %d %f 
 @2 format 字符串函数
 
 input() 从标准输入流读入一个字符串
 input(prompt=None)
 阻塞式
'''

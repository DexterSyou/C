# coding: UTF-8

msg = 'andy is a beautiful girl!'
print("msg=[%s]" % msg)
s=msg.capitalize() # 将首字符转换成大写
print(s+"\n")
print("msg=[%s]" % msg)
s=msg.title() #每个单词的首字母
print(s+"\n")
print("msg=[%s]" % msg)
result=msg.istitle()
print(result)
print("msg=[%s]" % msg)
s=msg.upper()  #  字符串转化大写
               #  lower() 
print(s+"\n")


print("**验证码案列**********************************")
s='qwertyuioplkjhgfdsazxcvbnm1234567890QWERTYUIOPLKJHGFDSAZXCVBNM'
code=''
import random
for i in range(4):
    ran=random.randint(0,len(s)-1)
    code+=s[ran]
print("验证码：" + code)

usr_in_code = input("请输入验证码： ")
if usr_in_code.lower() == code.lower():
    print("验证码输入正确！")
else:
    print("验证码错误!")


'''
 字符串的内建函数： 
   声明一个字符串，默认可以调用内建函数（系统准备好的一些函数）
 
'''

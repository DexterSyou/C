## 控制脚本

```
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
1/ 函数
   1. 创建函数
     a）function name {
	       commands	
	    }
     b）name（）{
		   commands
		}
   2. 使用函数
      函数名必须唯一
	  函数不能没有定义就使用
   
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
2/ 返回值
   bash shell会把函数当作一个小型脚本，运行结束时会返回一个退出状态码
   在函数执行结束后，可以用标准变量$?来确定函数的退出状态码
   1.默认退出状态码
      函数的退出状态码是函数中最后一条命令返回的退出状态码。
   2.return 命令
      退出函数并返回特定的退出状态码
         ⚠️ 函数一结束就取返回值
	       （如果在用$?变量提取函数返回值之前执行了其他命令，函数的返回值就会丢失。
	         $? 变量会返回执行的最后一条命令的退出状态码。）
	     ⚠️ 退出状态码必须是 0 ～ 255
   3.使用函数输出
      echo 进行输出，获得任何类型的函数输出，并将其保存到变量
      
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
3/ 函数中变量
   1.函数参数
     函数可以使用标准的参数环境变量来表示命令行上传给函数的参数
	 $0 函数名
	 $1
	 $2
	 ...
	 $9
	 $# 函数的参数数目
     ⚠️  尽管函数也使用了$1和$2变量，但它们和脚本主体中的$1和$2变量并不相同
   
   2.变量作用域
     作用域是变量可见的区域。函数 中定义的变量与普通变量的作用域不同
     对脚本的其他部分而言，它们是隐藏的
	 函数使用两种类型的变量: 
	    全局变量：全局变量是在shell脚本中任何地方都有效的变量
	      在脚本的主体部分定义了一个全句变量，在函数内能读取它的值
          在函数内定义了一个全局变量，脚本的主体部分能读取它的值
          
		  默认情况下，你在脚本中定义的任何变量都是全局变量
	    局部变量：
          函数内部使用的任何变量都可以被声明成局部变量
          只要在变量声明的前面加上local关键字
   3.数组变量和函数
   4.函数递归
     函数可以调用自己来得到结果
   5.创建库
     函数库的关键在于source命令。source命令会在当前shell上下文中执行命令，创建一个新shell。
     source命令有个快捷的别名，称作点操作符(dot operator)
   6.在命令行上使用函数
   7.在.bashrc文件中定义函数  
    
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
---------0---------1---------2---------3---------4---------5---------6---------7---------8---------9
```
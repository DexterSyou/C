##

```
#--------------------------------------------------
GUN make
BSD make 
Microsoft nmake
#--------------------------------------------------
########
#DEMO
#
cc = gcc
prom = calc
deps = calc.h
src = $(shell find ./ -name "*.h")  # 执行shell命令，找出当前目录下所有.c文件
obj = $(src:%c=%.c)                 # 一个字符替换函数 
$(prom):$(obj)
	$(cc) -o $(prom) $(obj)
%.o:%.c $(deps)                     #%.o:%.c 所有的吗.o目标都依赖与它同名的.c文件
	$(cc) -c $< -o $@               #$@当前语句的目标，即%.o, 
clean：
	rm -rf $(obj) $(prom)
#--------------------------------------------------
makefile
cmake
sh

#makefile 规则说明
<target1><target2>...:<prerequisites1><prerequisites2>
[TAB]<command1>
[TAB]<command2>

target是一个obj file，也可以是一个执行文件
prerequisites 是要生成那个target所需要的文件或目标
command 是make需要执行的命令（shell命令）


#内容展开
 list_a = 1.a 2.a
 list_b = 1.b 2.b 3.b

test:list_a
%.a:list_a #展开
            1.a：1.b 2.b 3.b  &@为1.a $<为1.b 2.b 3.b
			2.a：1.b 2.b 3.b  &@为2.a $<为1.b 2.b 3.b
%.b:%.x
     1.b:1.x
	 2.b:2.x
	 3.b:3.x

#赋值
=   最后再复制
:=  立即赋值
+=  追加赋值

#伪目标
.PHONY:clean
clean:
	-rm edit $(objects)

#自动变量 与 隐含变量
[$@] 目标集合
[$%] 当目标是函数库文件时，表示其中的目标文件名
[$<] 第一个依赖目标，如果依赖目标是多个，逐个表示依赖目标
[$?] 比目标新的依赖目标
[$^] 所有依赖目标的集合（去重）
[$+] 所有依赖目标的集合（不去重）

[RM]       rm -f
[AR]       ar
[CC]       cc
[CXX]      g++
[ARFLAGS]  AR命令的参数
[CFLAGS]   语言编译器的参数 
[CXXFLAGS] C++ 语言编译器的参数

#定义命令包
define<command-name>
command
...
endef

#条件判断
ifeq()
  @echo ""
else
  @echo ""
endif

#自定义函数
$(call<expression>,<parm1>,<parm2>,<parm3>...)
hello="hello"$(1)"world"
#函数
export EX_VAR = value 同一个进程传参
$(subst<source>,<new>,<text>) 
  把字符串<text>中的<source>替换为<new>，返回替换过的字符串
$(patsubst<source>,<new>,<text>)
  每个元素的替换
$(strip<tetx>)
  去掉<string>字符串中开头和结尾的空字符串，被去掉空格的字符串
$(findstring<tetx>,<elem>)
查找tetx中elem字符串，如果存在返回elem，否则返回空字符串
$(filter<elem1 elem2...>,<text>)
  保留复合条件的元素
$(filter-out<elem1 elem2...>,<text>)
  去掉符合条件的元素
$(wildcard*,X)
 获取该目录下所有.x文件
$(notdir<elem elem...>)

$(dir<elem1 elem2...>)

$(suffix<elem1 elem2...>)

$(basename<elem1 elem2...>)

$(addsuffix<suffix>,<elem1 elem2...>)

$(addprefx<prefix,<elem1 elem2...>)


#执行shell指令
$(shell<shell command>)
`<shell command>`























```

##

```
#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
#makefile 初识
#--------------------
#编译compile：把源文件编译成中间代码文件       UNIX下是.o  ObjectFile
 链接link。 ：把大量的Object File合成执行文件

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
#MakeFile的规则
#--------------------
#Makefile
   1. 显式规则。
      显式规则说明了如何生成一个或多个目标文件。这是由 Makefile 的书写者明显指出要
      生成的文件、文件的依赖文件和生成的命令。
   2. 隐晦规则。由于我们的 make 有自动推导的功能，所以隐晦的规则可以让我们比较简略地书写
      Make-file，这是由 make 所支持的。
        make看到一个.o文件，它就会自动的把.c文件加在依赖关系中。
	    如果 make 找到一个 whatever.o ，那么 whatever.c 就会是 whatever.o 的依赖文件。
	    并且 cc -c whatever.c 也会被推导出来
   3. 变量的定义。在 Makefile 中我们要定义一系列的变量，变量一般都是字符串，
      这个有点像你 C 语言中的宏，当 Makefile 被执行时，其中的变量都会被扩展到相应的引用位置上。
   4. 文件指示。
	  4.1 在一个Makefile中引用另一个Makefile，就像C语言中的include一样
	      include <filename>
		  filename 可以是当前操作系统 Shell 的文件模式(可以包含路径和通配符)
		  make 命令开始时，会找寻include 所指出的其它Makefile，并把其内容安置在当前的位置。
		  如果文件都没有指定绝对路径或是相对路径的话，make 会在当前目录下首先寻找，如果当前目录下没有找到，
		  那么，make 还会在下面的几个目录下找:
		  4.1.1. 如果 make 执行时有-I或--include-dir参数，那么make就会在这个参数所指定的目录下去寻找。
                 如果目录<prefix>/include(一般是:/usr/local/bin或/usr/include)存在的话，make也会去找。
          
		  -include <filename> 无论include过程中出现什么错误，都不要报错继续执行。
	      其他make的相关命令sinclude

	  4.2 指根据某些情况指定Makefile中的有效部分，就像C语言中的预编译#if一样
	  4.3 定义一个多行的命令
   5. 注释。Makefile 中只有行注释，和 UNIX 的 Shell 脚本一样，其注释是用#字符，
            Makefile 中的命令，必须要以 Tab 键开始。

#文件名
  默认的情况下,make命令会在当前目录下按顺序找寻文件名为“GNUmakefile”、“makefile”、“Make- file”的文件
  如果要指定特定的 Makefile，使用 make 的-f 和--file 参数，如:make -f Make.Linux。

#环境变量
  当前环境中定义了环境变量MAKEFILES ，make会把这个变量中的值做一个类似于include的动作。
  这个变量中的值是其它的Makefile，用空格分隔。
  和include不同，从这个环境变量中引入的 Makefile 的“目标”不会起作用，
  如果环境变量中定义的文件发现错误，make也会不理。
  这个变量一被定义，当使用 make 时，所有的Makefile都会受到它的影响

#make的工作方式
  GNU 的 make 工作时的执行步骤如下
  1. 读入所有的 Makefile。
  2. 读入被 include 的其它 Makefile。
  3. 初始化文件中的变量。
  4. 推导隐晦规则，并分析所有规则。
  5. 为所有的目标文件创建依赖关系链。
  6. 根据依赖关系，决定哪些目标要重新生成。 
  7. 执行生成命令。

  makefile的变量的展开： 依赖关系被决定使用，要生成目标时 ，变量才会在内部展开

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# 规则
#--------------------
#makefile的规则，makefile中最核心的内容
 target ... : prerequisites ...
	command
	...
	...
 
 target        可以是一个object file，也可以是一个执行文件，还可以是标签
 prerequisites 生成该target所依赖的文件和 / 或 target
               如果有一个以上的文件比target文件要新的话，command所定义的命令就会被执行
 command       该target要执行的命令（任意的shell命令）
               以UNIX标准Shell，即/bin/sh 来执行命令
#通配符
	*
	?
	~
	  ～/test 当前用户$HOME 目录下的test目录
	  ～sd/test 表示用户sd宿主目录下的test目录
	  windows下，根据环境变量HOME 耳定
    obj := $(wildcard *.c)
      obj是所有.c文件的集合
    obj = *.c  
	  obj 就是 *.c 

#文件搜索
  Makefile 文件中的特殊变量 VPATH,如果没有指明这个变量，make 只会在当前的目录中去找寻依赖文件和目标文件。
  如果定义了这个变量，那么，make 就会在当前目录找不到的情况下，到所指定的目录中去找寻文件了。
  VPATH = src:../headers   
    目录由“冒号”分隔。(当前目录永远是最高优先搜索的地方)

  另一个设置文件搜索路径的方法是（ make的关键字vpath ）
  可以指定不同的文件按照先后顺序在不同的搜索目录中
    <pattern> 指定了要搜索的文件集，而 <directories> 则 指定了 < pattern> 的文件集的搜索的目录
      vpath <pattern> <directories> 为符合模式 <pattern> 的文件指定搜索目录 <directories>。 
      vpath <pattern> 清除符合模式 <pattern> 的文件的搜索目录。
      vpath 清除所有已被设置好了的文件搜索目录。
 
    vpath %.h ../headers
	如果当前目录没有.h文件，在../headers目录下搜索所有的.h文件
	% 的意思是匹配零或若干字符,%.h 表示所有以.h 结尾的文件

#伪目标, 伪目标只是一个标签不会生成文件
#无法生成依赖关系，和决定它是否要执行
 使用一个特殊标记.PHONY来显示地指明一个目标是 伪目标
 向make说明，不管是否有这个文件，这个目标就是 伪目标
 .PHONY: clean
 clean : 
	rm *.o temp

#多目标
  $@ 表示目标集合
  $()表示执行一个makefile函数

#静态模式
  <targets ...>:<target-pattern>:<prereq-pattern ...>
	<commands>
	...
   obj = foo.o bar.o
   all: $(obj)

   $(obj):%.o:%.c
	$(CC) -c $(CFLAGS) $< -o $@
    $< 依赖第一个文件
	$@ 自动化变量，目标集合

#自动生成依赖性
   cc -M main.c
   gcc -MM main.c

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# make命令&变量
#--------------------

make 会把其要执行的命令行在命令执行前输出到屏幕上。
当我们用@字符在命令行前，这个命令将不被make显示出来

make -n  --just-print       只是显示命令
make -s  --silent  --quiet  全面禁止命令
make -k  --keep-going       终止当前规则，继续下一个规则
make -i  --ignore-errors    所有命令会忽略错误

#命令执行i
  make的命令默认是/bin/sh------UNIX的标准Shell解释执行的
  一般使用SHELL环境变量的解析命令

  上一条命令结果应用于下一条命令时，你应该使用分号分隔这两条命令
  exec：
	cd /home/test；pwd

#命令出错
  每当命令运行完后，make 会检测每个命令的返回码，如果命令返回成功，那么 make 会执行下一条命令，
  当规则中所有的命令成功返回后，这个规则就算是成功完成了。如果一个规则中的某个命令出错了
  (命令退出码非零)，那么 make 就会终止执行当前规则，这将有可能终止所有规则的执行。
 
  命令行前加一个 - ， 表示不管命令出不出错都是成功的
  
 你要传递变量到下级 Makefile 中，那么你可以使用这样的声明:
 export <var ...>
 不想让某些变量传递到下级 Makefile 中，那么你可以这样声明:
 unexport <var ...>

有两个变量一个是SHELL ，一个是 MAKEFLAGS ，这两个变量不管你是否 export， 
其总是要传递到下层 Makefile中，MAKEFLAGS变量其中包含了 make 的参数信息，
执行“总控 Makefile”时有 make 参数或是在上层 Makefile 中定义了这个变量，
那么MAKEFLAGS变量将会是这些参数，并会传递到下层Makefile 中，这是一个系统级的环境变量。

#定义命令包
define cmdName
 cmds
endif

#-------------------
#变量 makefile中的变量就像C中宏，代表了一个文本字符串
#-------------------
1. :=  
     前面的变量不能使用后面的变量
2.  =

3. nullstring :=
   space := ${nullstring}# end of the line
   dir := /foo/bar    #

4. FOO ?= bar
   如果FOO没被定义，则为bar， 如果定义了，什么也不做
   variable += value

5.高级变量
  5.1变量替换 $(var:a=b) 或是 ${var:a=b} 
  把变量“var”中所有以“a”字串“结尾”的“a”替换成“b”字串。这里的“结尾”意思是“空格”或“结束符”。

  foo := a.o b.o c.o
  bar := $(foo:.o=.c)
  bar := $(foo:%.o=%.c) 

  5.2 把变量的值再当成变量
  （1）
     x=y
     y=z
     a := $($(x))
  （2）
      first_second = Hello a = first
      b = second
      all = $($a_$b)
  （3）
      根据a1 来变
      a_objects := a.o b.o c.o
      1_objects := 1.o 2.o 3.o
      sources := $($(a1)_objects:.o=.c)
  (4)
  ifdef do_sort
    func := sort 
  else
    func := strip 
  endif
  bar := a d b g q c
  foo := $($(func) $(bar))
 把变量的值再当成变量”这种技术，同样可以用在操作符的左边
 dir = foo
 $(dir)_sources := $(wildcard $(dir)/*.c)
 define $(dir)_print
 lpr $($(dir)_sources)
 endef

6.override 指示符
  有变量是通常 make 的命令行参数设置的，那么 Makefile 中对这个变量的赋值会被忽略
  override <variable>; := <value>;
  override <variable>; += <more text>;
  override <variable>; = <value>;
  override define foo
  bar
  endef

7.多行变量
  用 define 定义的命令变量中没有以 Tab 键开头，那么 make 就不会把其认为是命令。

8.环境变量
  make 运行时的系统环境变量可以在make开始运行时被载入到Makefile文件中，
  但是如果Makefile中已定义了这个变量，或是这个变量由make命令行带入，
  那么系统的环境变量的值将被覆盖。
  (如果 make 指定了“-e”参数，那么，系统环境变量将覆盖 Makefile 中定义的变量)

  当 make 嵌套调用时，上层Makefile中定义的变量会以系统环境变量的方式传递到下层的Makefile
  默认情况下，只有通过命令行设置的变量会被传递

9.目标变量“Target-specific Variable”
  它的作用范围只在这条规则以及连带规则中，所以其值也只在作用范围内有 效。而不会影响规则链以外的全局变量的值。
  <target ...> : <variable-assignment>;
  <target ...> : overide <variable-assignment>

10.模式变量
  %.o : CFLAGS = -O
  <pattern ...>; : <variable-assignment>;
  <pattern ...>; : override <variable-assignment>;
  override 同样是针对于系统环境传入的变量，或是 make 命令行指定的变量。

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# 条件判断
#--------------------

使用条件判断，可以让 make 根据运行时的不同情况选择不同的执行分支。
条件表达式可以是比较 变量的值，或是比较变量和常量的值。

<conditional-directive> 
<text-if-true>
endif

<conditional-directive> 
<text-if-true>
else
<text-if-false>
endif


ifeq (<arg1>, <arg2>)
ifeq '<arg1>' '<arg2>'
ifeq "<arg1>" "<arg2>"
ifeq "<arg1>" '<arg2>'
ifeq '<arg1>' "<arg2>"

ifeq ($(strip $(foo)),)
<text-if-empty>
endif

ifneq (<arg1>, <arg2>)
ifneq '<arg1>' '<arg2>'
ifneq "<arg1>" "<arg2>"
ifneq "<arg1>" '<arg2>'
ifneq '<arg1>' "<arg2>"

如果变量 <variable-name> 的值非空，那到表达式为真。否则，表达式为假。
ifdef <variable-name>              测试变量是否有值   
ifndef <variable-name>             

在 <conditional-directive> 这一行上，多余的空格是被允许的，不能以Ta 键作为开始(不
然就被认为是命令)。而注释符 # 同样也是安全的。else和endif也一样，不是以Tab键开始
make是在读取MakeFile时候，就计算条件表达式的值，并根据条件表达式的值来选择语句
自动化变量是在运行时才有的，所以不能放在条件表达式中
为了避免混乱，make 不允许把整个条件语句分成两部分放在不同的文件中 

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# 函数
#--------------------
Makefile中可以使用函数来处理变量，让命令或是规则更为的灵活和具有智能
$(<function> <arguments>)
${<function> <arguments>}
<arguments> 为函数的参数，参数间以逗号 , 分隔，而函数名和参数之间以“空格”分隔

#-------------------
#字符串处理函数
#-------------------
1.$(subst <from>,<to>,<text>)
• 名称:字符串替换函数
• 功能:把字串<text>中的<from>字符串替换成<to>。
• 返回:函数返回被替换过后的字符串。
  $(subst ee,EE,feet on the street)

2.$(patsubst <pattern>,<replacement>,<text>)
•名称:模式字符串替换函数。
•功能:查找<text>中的单词(单词以“空格”、“Tab”或“回车”“换行”分隔)是否符合模式 <pattern> ，
      如果匹配的话，则以 <replacement> 替换。
•返回:函数返回被替换过后的字符串
 $(patsubst %.c,%.o,x.c.c bar.c)
 与$(objects:.o=.c) 类似

3.$(strip <string>)
• 名称:去空格函数。
• 功能:去掉<string>字串中开头和结尾的空字符。
• 返回:返回被去掉空格的字符串值。
  $(strip a b c )

4.$(findstring <find>,<in>)
 • 名称:查找字符串函数
 • 功能:在字串<in>中查找<find>字串。
 • 返回:如果找到，那么返回<find>，否则返回空字符串。
   $(findstring a,a b c)

5.$(filter <pattern...>,<text>)
 • 名称:过滤函数
 • 功能:以<pattern>模式过滤<text>字符串中的单词，保留符合模式<pattern>的单词。可以 有多个模式。
 • 返回:返回符合模式<pattern>的字串。
   sources := foo.c bar.c baz.s ugh.h
   foo: $(sources)
	cc $(filter %.c %.s,$(sources)) -o foo
6.$(filter-out <pattern...>,<text>)
 • 名称:反过滤函数

7.$(sort <list>)
• 名称:排序函数
• 功能:给字符串<list>中的单词排序(升序)。
• 返回:返回排序后的字符串。
       $(sort foo bar lose)返回bar foo lose。
• 备注:sort函数会去掉<list>中相同的单词。

8.$(word <n>,<text>)
• 名称:取单词函数
• 功能:取字符串<text>中第<n>个单词。(从一开始)
• 返回:返回字符串<text>中第<n>个单词。如果<n>比<text>中的单词数要大，那么返回空字 符串。
  $(word 2,foo bar baz)返回值是bar。

9.$(words <text>)
• 名称:单词个数统计函数
• 功能:统计<text>中字符串中的单词个数。
• 返回:返回<text>中的单词数。
  $(words,foo bar baz)返回值是3。
  $(word $(words <text>）

10.$(firstword <text>)
• 名称:首单词函数——firstword。
• 功能:取字符串<text>中的第一个单词。
• 返回:返回字符串<text>的第一个单词。
  $(firstword foo bar)返回值是foo。

11.$(wordlist <ss>,<e>,<text>)
• 名称:取单词串函数
• 功能:从字符串<text>中取从<ss>开始到<e>的单词串。<ss>和<e>是一个数字。
   $(wordlist2,3,foo bar baz)返回值是bar baz。

利用 这个搜索路径来指定编译器对头文件的搜索路径参数 CFLAGS
override CFLAGS += $(patsubst %,-I%,$(subst :, ,$(VPATH)))
如果$(VPATH) 值是 src:../headers  将返回 -Isrc -I../headers  
#--------------------
# 文件名操作函数
#--------------------
每个函数的参数字符串都会被当做一个或是一系列的文件名来对待
1.$(dir <names...>)
• 名称:取目录函数——dir。
• 功能:从文件名序列<names>中取出目录部分。目录部分是指最后一个反斜杠(/)之前的部分。 
       如果没有反斜杠，那么返回 ./ 。
• 返回:返回文件名序列<names>的目录部分。
  $(dir src/foo.c hacks)返回值是src/ ./

2.$(notdir <names...>)
• 名称:取文件函数——notdir。
• 返回:返回文件名序列<names>的非目录部分。

3.$(suffix <names...>)
• 名称:取後缀函数——suﬀix。
• 返回:返回文件名序列<names>的后缀序列，如果文件没有后缀，则返回空字串。
$(suffix src/foo.c src-1.0/bar.c  hacks)返回值是.c .c

4.$(basename <names...>)
• 名称:取前缀函数——basename。
• 返回:返回文件名序列<names>的前缀序列，如果文件没有前缀，则返回空字串。
$(basename src/foo.c src-1.0/bar.c hacks) 返回值是src/foo src-1.0/bar hacks

5.$(addsuffix <suffix>,<names...>)
• 名称:加后缀函数——addsuﬀix。

6.$(addprefix <prefix>,<names...>)
• 名称:加前缀函数——addprefix。

7.$(join <list1>,<list2>)
• 名称:连接函数——join。
• 功能:把 <list2> 中的单词对应地加到 <list1> 的单词后面。
  如果 <list1> 的单词个数要比 <list2> 的多，那么，<list1> 中的多出来的单词将保持原样。
  如果 <list2> 的单词个数要比 <list1> 多，那么，<list2> 多出来的单词将被复制到 <list1> 中。
• 返回:返回连接过后的字符串。
• 示例:$(join aaa bbb,111 222 333)返回值是 aaa 111 bbb 222 333。

#-------------------
#foreach 函数
#-------------------
$(foreach <var>,<list>,<text>)

names := a b c d
files := $(foreach n,$(names),$(n).o)

$(name) 中的单词会被挨个取出，并存到变量 n 中，$(n).o 每次根据 $(n) 计算出 一个值，
这些值以空格分隔，最后作为 foreach 函数的返回，
$(files) 的值是 a.o b.o c.o d.o

foreach 中的 <var> 参数是一个临时的局部变量，foreach 函数执行完后，参数 <var> 的变量将不在作用，
其作用域只在 foreach 函数当中


#-------------------
#  if 函数
#-------------------
$(if <condition>,<then-part>)
$(if <condition>,<then-part>,<else-part>)
if 函数很像 GNU 的 make 所支持的条件语句——ifeq

#-------------------
#call 函数
#-------------------
$(call <expression>,<parm1>,<parm2>,...,<parmn>)
<expression> 参数中的变量，如 $(1) 、$(2) 等，会被参数 <parm1> 、 <parm2> 、<parm3> 依次取代
在向call函数传递参数时,call函数在处理参数时，第2个及其之后的参数中的空格会被保留，因而可能造成一些奇怪的效果。
在向call函数提供参数时，最安全的做法是去除所有多余的空格。call 函数是唯一一个可以用来创建新的参数化的函数。
<expression> 的返回值就是 call 函数的返回值

#-------------------
# origin 函数
#-------------------
$(origin <variable>)
origin 函数不像其它的函数，他并不操作变量的值，他只是告诉你你的这个变量是哪里来的
<variable> 是变量的名字，不应该是引用。

undefined 如果 <variable> 从来没有定义过，origin 函数返回这个值 undefined
default 如果 <variable> 是一个默认的定义，比如“CC”这个变量，这种变量我们将在后面讲述。
environment 如果 <variable> 是一个环境变量，并且当 Makefile 被执行时，-e 参数没有被打开。
file 如果 <variable> 这个变量被定义在 Makefile 中。
command line 如果 <variable> 这个变量是被命令行定义的。
override 如果 <variable> 是被 override 指示符重新定义的。
automatic 如果 <variable> 是一个命令运行中的自动化变量。关于自动化变量将在后面讲述。

#-------------------
#shell 函数
#-------------------
它的参数应该就是操作系统 Shell 的命令
files := $(shell echo *.c)

#-------------------
#控制 make 的函数
#-------------------
$(error <text ...>)
产生一个致命的错误，<text ...> 是错误信息。
ifdef ERROR_001
	$(error error is $(ERROR_001)) 
endif

$(warning <text ...>)
函数很像 error 函数，只是它并不会让 make 退出，只是输出一段警告信息，而 make 继续执行。

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# make的运行
#--------------------
# make 的退出码
0 表示成功执行。
1 如果 make 运行时出现任何错误，其返回 1。
2 如果你使用了 make 的“-q”选项，并且 make 使得一些目标不需要更新，那么返回 2

# 指定 Makefile 
make –f hchen.mk

# 指定目标
有一个 make 的环境变量叫 MAKECMDGOALS ，这个变量中会存放你所指定的终极目标的列表

#伪目标
• all: 这个伪目标是所有目标的目标，其功能一般是编译所有的目标。
• clean: 这个伪目标功能是删除所有被 make 创建的文件。
• install: 这个伪目标功能是安装已编译好的程序，其实就是把目标执行文件拷贝到指定的目标中去。
• print: 这个伪目标的功能是例出改变过的源文件。 
• tar: 这个伪目标功能是把源程序打包备份。也就是一个 tar 文件。
• dist: 这个伪目标功能是创建一个压缩文件，一般是把 tar 文件压成 Z 文件。或是 gz 文件。
• TAGS: 这个伪目标功能是更新所有的目标，以备完整地重编译使用。
• check 和 test: 这两个伪目标一般用来测试 makefile 的流程。

#检查规则
 -n
 -t
 -q
 -W <file>

# make 参数
#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# 隐含规则
#--------------------
make 会自动去推导这两个目标的依赖目标和生命
1.编译 C 程序的隐含规则。
  <n>.o 的目标的依赖目标会自动推导为 <n>.c ，并且其生成命令是 $(CC) –c $(CPPFLAGS) $(CFLAGS)

2.编译 C++ 程序的隐含规则。
  <n>.o 的目标的依赖目标会自动推导为 <n>.cc 或是 <n>.C ，
  并且其生成命令是 $(CXX) –c $(CPPFLAGS) $(CFLAGS) 。

命令变量
命令参数

模式
% 表示长度任意非空的字符串
%.o : %.c ; <command ......>;






#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
#Richard Stallman
http://www.stallman.org/
http://bbs.chinaunix.net/attachments/rms.jpg

#Roland McGrath
http://www.frob.com/~roland/





#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0


```

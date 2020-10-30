##

```
#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
#makefile 初识
#--------------------
#编译compile：把源文件编译成中间代码文件
               UNIX下是.o
 链接link。 ：把大量的Object File合成执行文件

#make如何工作的
  edit : main.o kbd.o command.o display.o \
        insert.o search.o files.o utils.o
	cc -o edit main.o kbd.o command.o display.o \ 
	    insert.o search.o files.o utils.o
  
  在默认的方式下，也就是我们只输入 make 命令
  1.如果找到，它会找文件中的第一个目标文件(target),上面的例子中，他会找到“edit”这个文件，
    并把这个文件作为最终的目标文件。
  2.如果 edit 文件不存在或是 edit 所依赖的后面的 .o 文件的文件修改时间要比 edit 这个文件新， 
    那么，他就会执行后面所定义的命令来生成 edit 这个文件。
  3.整个 make 的依赖性，make 会一层又一层地去找文件的依赖关系，
    直到最终编译出第一个目标文件

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
#MakeFile的规则
#--------------------
#Makefile
   1. 显式规则。显式规则说明了如何生成一个或多个目标文件。这是由 Makefile 的书写者明显指出要
      生成的文件、文件的依赖文件和生成的命令。
   2. 隐晦规则。由于我们的 make 有自动推导的功能，所以隐晦的规则可以让我们比较简略地书写
      Make-file，这是由 make 所支持的。
        make看到一个.o文件，它就会自动的把.c文件加在依赖关系中。
	    如果 make 找到一个 whatever.o ，那么 whatever.c 就会是 whatever.o 的依赖文件。
	    并且 cc -c whatever.c 也会被推导 出来
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
	  4.2 指根据某些情况指定Makefile中的有效部分，就像C语言中的预编译#if一样
	  4.3 定义一个多行的命令
   5. 注释。Makefile 中只有行注释，和 UNIX 的 Shell 脚本一样，其注释是用#字符，
            Makefile 中的命令，必须要以 Tab 键开始。

#文件名
  默认的情况下,make命令会在当前目录下按顺序找寻文件名为“GNUmakefile”、“makefile”、“Make- file”的文件
  如果要指定特定的 Makefile，你可以使用 make 的-f 和--file 参数，如:make -f Make.Linux。

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
   obj := $(wildcard *.c)

#文件搜索
  Makefile 文件中的特殊变量 VPATH,如果没有指明这个变量，make 只会在当前的目录中去找寻依赖文件和目标文件。
  如果定义了这个变量，那么，make 就会在当前目录找不到的情 况下，到所指定的目录中去找寻文件了。
  VPATH = src:../headers   
    目录由“冒号”分隔。(当前目录永远是最高优先搜索的地方)

  另一个设置文件搜索路径的方法是vpath
    <pattern> 指定了要搜索的文件集，而 <directories> 则 指定了 < pattern> 的文件集的搜索的目录
      vpath <pattern> <directories> 为符合模式 <pattern> 的文件指定搜索目录 <directories>。 
      vpath <pattern> 清除符合模式 <pattern> 的文件的搜索目录。
      vpath 清除所有已被设置好了的文件搜索目录。
 
    vpath %.h ../headers
    % 的意思是匹配零或若干字符,%.h 表示所有以.h 结尾的文件

#伪目标, 伪目标只是一个标签不会生成文件
 .PHONY:clean
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
	$@ 自动化变量

#自动生成依赖性
   cc -M main.c
   gcc -MM main.c

#*********1*********2*********3*********4*********5*********6********7*********8*********9*********0
# make命令&变量
#--------------------
make 会把其要执行的命令行在命令执行前输出到屏幕上。
当我们用 @ 字符在命令行前，这个命令将不被 make 显示出来

make -n  只是显示命令
make -s  全面禁止命令
make -k  终止当前规则，继续下一个规则
make -i  所有命令会忽略错误
make一般是使用环境变量SHELL中说定义的系统Shell来执行命令

#命令执行
  上一条命令结果应用于下一条命令时，你应该使用分号分隔这两条命令
#命令出错
  每当命令运行完后，make 会检测每个命令的返回码，如果命令返回成功，那么 make 会执行下一条命令，
  当规则中所有的命令成功返回后，这个规则就算是成功完成了。如果一个规则中的某个命令出错了
  (命令退出码非零)，那么 make 就会终止执行当前规则，这将有可能终止所有规则的执行。
 
 你要传递变量到下级 Makefile 中，那么你可以使用这样的声明:
 export <var ...>
 不想让某些变量传递到下级 Makefile 中，那么你可以这样声明:
 unexport <var ...>
有两个变量一个是SHELL ，一个是 MAKEFLAGS ，这两个变量不管你是否 export， 其总是要传递到下层 Makefile中，
MAKEFLAGS变量，其中包含了 make 的参数信息，执行“总控 Makefile”时有 make 参数或是在上层 Makefile 中定义了这个变量，
那么MAKEFLAGS 变量将会是这些参数，并会传递到下层Makefile 中，这是一个系统级的环境变量。

#定义命令包
define cmdName
 cmds
endif

#-------------------
#变量
1. :=  前面的变量不能使用后面的变量
2.  =
3. nullstring :=
   space := ${nullstring}
   dir := /foo/bar    #
4. FOO ?= bar
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
  a_objects := a.o b.o c.o
  1_objects := 1.o 2.o 3.o
  sources := $($(a1)_objects:.o=.c)
  (4)
  ifdef do_sort
  func := sort else
  func := strip endif
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



```

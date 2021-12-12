foo := a.o b.o c.o
bar := $(foo:.o=.c)

foo1 := a.o b.o c.o
bar1 := $(foo:%.o=%.c)
all:
	@echo $(foo)
	@echo $(foo1)
	

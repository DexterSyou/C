#TM1:
a_objs := a.o b.o c.o
1_objs := 1.o 2.0 3.o 

srcs := $($(a1)_objs:.o=.c)

#TM2:
ifdef do_sort
	func := sort 
else
	func := strip 
endif

bar := a d b g q c
foo := $($(func) $(bar))

#TM3:
dir = foo
$(dir)_sources := $(wildcard $(dir)/*.c)

define $(dir)_print
lpr $($(dir)_sources)
endef

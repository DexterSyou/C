test:
	@echo "hello world"
	@echo $(dir ./test)
	@echo $(join a b , 1 2)

#ifeq "$(origin hhh)" "undefined"
#	hhh = hello hello hello
#endif
#	@echo $(hhh)
#
	@echo $(shell cat foo)

# File:		Makefile
# Devs:		Nathan W. Barros
# Origin:	2026-09-21 08:14:13
# Edited:	2026-09-21 23:16:01

.PHONY: lifesim

lifesim:
	@javac src/*.java -d bin
	@java -cp bin LifeSimulator

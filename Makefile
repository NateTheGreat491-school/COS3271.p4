# File:		Makefile
# Devs:		Nathan W. Barros
# Origin:	2026-09-21 08:14:13
# Edited:	2026-09-21 22:58:21

.PHONY: lifesim

lifesim:
	@javac LifeSimulator.java Person.java Utility.java
	@java LifeSimulator

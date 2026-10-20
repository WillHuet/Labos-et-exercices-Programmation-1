# Makefile pour INF3105 / TP2

#OPTIONS = -Wall           # option standard
#OPTIONS = -g -O0 -Wall    # pour rouler dans gdb
OPTIONS = -O2 -Wall        # pour optimiser

all : tp2

tp2 : tp2.cpp carte.o position.h position.o
	g++ ${OPTIONS} -o tp2 tp2.cpp carte.o position.o

carte.o : carte.cpp carte.h
	g++ ${OPTIONS} -c -o carte.o carte.cpp
	
position.o : position.cpp position.h
	g++ ${OPTIONS} -c -o position.o position.cpp

clean:
	rm -rf tp2 *~ *.o


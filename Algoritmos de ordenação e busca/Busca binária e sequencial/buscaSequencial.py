import random

lista = list(range(0,30))
random.shuffle(lista)


def buscaSequencial(lista,num):
	for i in lista:
		if(i == num): return i
	return -1

print(buscaSequencial(lista,10))


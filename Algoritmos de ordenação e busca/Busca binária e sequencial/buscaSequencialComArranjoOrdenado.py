import random
lista = list(range(1,40))
random.shuffle(lista)

lista.sort()

def buscar_sequencial_com_arranjo_ordenado(lista,num):
    for i in lista:
        if(num == i): 
            return i
        if(i > num): 
            return 

print(buscar_sequencial_com_arranjo_ordenado(lista,50))
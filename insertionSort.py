arranjo=[5,7,8,2,4,6,3]

def InsertionSort(arranjo):
    if(len(arranjo) == 1):return
    for i in range(1,len(arranjo)):
        j=i-1
        chave = arranjo[i]
        while(arranjo[j]> chave and j>=0):
            aux = arranjo[j]
            arranjo[j] = arranjo[j+1]
            arranjo[j+1] = aux
            j-=1
        
print("Desordenado")
print(arranjo)
InsertionSort(arranjo)
print("Ordenado")
print(arranjo)

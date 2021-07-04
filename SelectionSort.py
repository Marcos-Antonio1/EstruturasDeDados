arranjo = [5,7,8,2,4,6,3]
def selectionSort(arranjo):
    min = 0
    for i in range(len(arranjo)-1):
        min = i
        for j in range(i+1,len(arranjo)):
            if(arranjo[min]>arranjo[j]):
                min = j
        if(min != i):
            [arranjo[min], arranjo[i]] = [arranjo[i], arranjo[min]]

print("### Desordenado ####")
print(arranjo)
selectionSort(arranjo)
print("### Ordenado ####")
print(arranjo)
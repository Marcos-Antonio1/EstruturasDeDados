import random 
arranjo = list(range(0,50))
random.shuffle(arranjo)

def BubbleSort(arranjo):
    fim=len(arranjo)-1
    for i in range(len(arranjo)-1):
        for j in range(fim):
            if(arranjo[j] > arranjo[j+1]):
                aux = arranjo[j]
                arranjo[j]=arranjo[j+1]
                arranjo[j+1]= aux
        fim-=1
print("##################")
print(arranjo)
BubbleSort(arranjo)
print('##################')
print(arranjo)

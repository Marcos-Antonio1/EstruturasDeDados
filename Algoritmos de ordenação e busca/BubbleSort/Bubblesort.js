const arranjo = [9,8,4,6,3]

const bubbleSort = function(arranjo){
    let final =arranjo.length-1;
    for(let i=0;i<=arranjo.length;i++){
        for(j=0;final>=j;j++){
            if(arranjo[j]>arranjo[j+1]){
                let troca =arranjo[j]
                arranjo[j]=arranjo[j+1]
                arranjo[j+1]=troca;
            }
        }
     final--;
    }
}

// percorrer o arranjo
// comparando os valores
// se o anterior é maior ao posterior , tem que trocar
// segue comparando até o final de
// ao final de cada rodada elemento com maior valor vai estar no seu lugar correto 
/* console.log('========== DESORDENADO =============');
console.log(arranjo);
console.log('====================================');
bubbleSort(arranjo)
console.log('============ Ordenado ==============');
console.log(arranjo);
console.log('===================================='); */


const BubbleSortRecursivo = function (arranjo,tamanho) {
    if(tamanho < 1) return;
    for(let i =0;i<tamanho;i++){
        if(arranjo[i] >arranjo[i+1]){
            swap(arranjo,i,i+1)
        }
    }
    return BubbleSortRecursivo(arranjo, tamanho-1)
}

const swap = function (arranjo,posicao1,posicao2){
    let aux= arranjo[posicao1]
    arranjo[posicao1]=arranjo[posicao2]
    arranjo[posicao2]=aux
}

console.log('========== DESORDENADO =============');
console.log(arranjo);
console.log('====================================');
let tamanho= arranjo.length -1;
BubbleSortRecursivo(arranjo,tamanho)
console.log('============ Ordenado ==============');
console.log(arranjo);
console.log('===================================='); 

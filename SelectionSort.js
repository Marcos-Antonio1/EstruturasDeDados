let arranjo = [5,7,8,2,4,6,3]

const selectionSort = function (arranjo){
    let min; 
    for(let i = 0; i<arranjo.length-1; i++){
        min= i;
        for(j= i+1;j<=arranjo.length;j++){
            if(arranjo[min]> arranjo[j]){
                min = j
            }
        }
        if(min != i){
            [arranjo[min],arranjo[i]]=[arranjo[i],arranjo[min]]
        }
    }
}

console.log('============= DESORDENADO =============');
console.log(arranjo);
selectionSort(arranjo)
console.log('================ ORDENADO ==========');
console.log(arranjo);
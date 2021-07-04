let arranjo = [5,7,8,2,4,6,3]

const IsertionSort= function (arr) {
    if( arr.length == 1) return 
    let chave= arr[1]
    for(let i =1;i<arr.length;i++){
        let j = i-1
        while(arr[j]>chave && j>=0){
            arr[j+1]=arr[j]
            arr[j]= chave;
            j--;
        }
    chave= arr[i+1]
    }
}

console.log('============= DESORDENADO =============');
console.log(arranjo);
IsertionSort(arranjo)
console.log('================ ORDENADO ==========');
console.log(arranjo);

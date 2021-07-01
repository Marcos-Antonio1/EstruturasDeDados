let arranjo = [30,40,12,32,50,23,1,2,3,7]
arranjo.sort()

const buscaSequencialArrayOrdenado =function (arranjo,num){
    for(let i= 0;i<arranjo.length;i++){
        if(arranjo[i]== num) return num;
        if(arranjo[i]> num) return -1;
    }
}

const result =buscaSequencialArrayOrdenado(arranjo,50)
console.log(result)
const lista = [1,2,3,4,5,6,7,8,9,10]


const BuscaBinaria = function(lista,num){
    let inicio= 0;
    let fim = lista.length -1 ;
    while(inicio <= fim ){
        let meio =Math.trunc((inicio +fim)/2);
        if(lista[meio] < num) inicio= meio+1
        else{
            if(lista[meio]> num) fim = meio -1
            else return meio
        }
    }
    return -1; 
}

const buscaBinariaRecursiva = function (lista,num){
    if((lista.length-1) < 0 ){
        return -1;
    }
    let meio= Math.trunc((lista.length-1) /2);
        let number = lista[meio];
        if(number == num) return num;
        if(number > num)return  buscaBinariaRecursiva(lista.slice(0,meio),num)
        if(number < num) return buscaBinariaRecursiva(lista.slice(meio+1,lista.length),num)   
}
/* const result =buscaBinariaRecursiva(lista,10)
console.log(result)
*/

console.log(BuscaBinaria(lista,10))
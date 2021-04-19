class Pilha {
   constructor(){
     this.pilha=[];
     this.ponteiro=-1;
   }
   IsEmpty(){
     if(this.ponteiro == -1) return true;
     return false;
   }
   tamanho(){
     if(this.IsEmpty()) return 0;
     return this.ponteiro;
   }
   pop(){
     if(this.IsEmpty()) return null;
     --this.ponteiro
   }
   push(v){
     this.ponteiro++
     return this.pilha[this.ponteiro]=v;
   }
   show(){
      console.log(this.pilha)
   }
   getPilha(){
    return this.pilha;
   }
}


export default Pilha;

import Pilha from './Pilha';
function Parenteses(string){
    let pilha= new Pilha()
    let balanceado= true;
    let indiceDoParenteseProblematico=null;

    for(let i=0;i<string.length;i++){
      if(string[i] == '(')
        pilha.push({valor:string[i],indice:i})
      else{
        if (pilha.IsEmpty()){
            balanceado= false;
            indiceDoParenteseProblematico=i;
            break;
          }
        else{
          pilha.pop();
          balanceado= true;
        }
      }
    }
    if(!pilha.IsEmpty()){
      let dadosDapilha=pilha.getPilha();
      indiceDoParenteseProblematico=dadosDapilha[0].indice;
    }

    if(pilha.IsEmpty() && balanceado) console.log("Está balanceado")
    else console.log(`Não está balanceado, o indice do Parenteses problemático é ${indiceDoParenteseProblematico}`)
}

Parenteses("((()))())")
Parenteses("()()()")
Parenteses(")))(((")
Parenteses("()())")
Parenteses("()()())")
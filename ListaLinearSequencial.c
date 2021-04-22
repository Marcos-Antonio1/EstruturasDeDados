#include <stdio.h>
#include <stdboo.h>
#difine MAX 50

typedef int TIPOCHAVE;

typedef struct {
  TIPOCHAVE chave,
  // poderia ter outros campos que se deseja guardar
}REGISTRO;

typedef struct {
  A[MAX+1];
  int nroElmen;
}LISTA;

void inicializarLista(LISTA* l){
  l->nroElmen= 0;
}

int tamanho(LISTA* l){
  return l->nroElmen;
}

void imprimir(LISTA* l){
  int i;
  printf(" Lista: \n", );
  for(i=0;i<l->nroElmen;i++){
    printf("%i\n",l->A[i]->nroElmen);
  }
}

int buscaSequencial(LISTA* l,TIPOCHAVE ch){
  int i;
  for(i=0;i<l->nroElmen;i++){
    if(ch == l->A[i].chave) return i;
  }
  return -1;
}

int buscaOtimizada(LISTA* l,TIPOCHAVE ch){
  int i=0;
  l->A[l->nroElmen].chave=ch;
  while(l->A[i].chave != ch) i++;
  if( i == l-> nroElmen) return -1;
}
int  buscaBinaria(LISTA* l, TIPOCHAVE ch){
  int esq,dir,mid;
  esq=0;
  dir=l->nroElmen-1;
  while (esq <= dir) {
    meio=((esq+dir)/2);
    if(l->A[meio].chave == ch) return meio;
    else{
      if(l->A[meio].chave < ch) esq=meio +1
      else dir = meio-1;
    }
  }
  return -1;
}
bool inserirElementoLista(LISTA* l, REGISTRO reg, int i){
  int j;
  if((l->nroElmen == MAX) || ( i<0 ) || (i>l->nroElmen) ) return false;
  // deslocar todo mundo apartir da posição i para a direta
   for(j=l->nroElmen;j>i;j--){
     l->A[j]=l->A[j-1];
   }
   l->A[i]=reg;
   l->nroElmen++;
   return true;
}

bool inserirListaOrdenada(LISTA* l,REGISTRO reg){
  if(l->nroElmen >=MAX) return false;
  int pos=l->nroElmen;
  while(pos> 0 && l->A[pos-1].chave >reg.chave){
    l->A[pos]=l->A[pos-1];
    pos--;
  }
  l->A[pos]=reg;
  l->nroElmen++;
}

bool excluirElemLista(TIPOCHAVE ch, LISTA* l){
  int pos ,j;
  pos = buscaBinaria(l,ch);
  if(pos == -1 )return false;
  for( j=pos;j< l->nroElmen; j++){
    l->A[j]=l->A[j+1];
  }
  l->nroElmen--;
  return true;
}

void ReinicialiarLista(LISTA* 1){
  l->nroElmen=0;
}

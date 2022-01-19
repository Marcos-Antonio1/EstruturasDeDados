# Estrutura de Dados Doubly Linked List ou Lista Duplamente encadeada:

## Descrição

  <p align= "justify">
      &nbsp &nbsp &nbsp &nbsp A Estrutura da lista duplamente encadeada tem como intuinto principal agrupar elementos na memória de forma a criar um encadeamento lógico de dados, na qual cada elemento tem seu valor interno e uma referência para o próximo objeto e outra referência para o anterior, ela é muito semelhante a uma lista encadeada tendo como divergência apenas o fato da lista duplamente encadeada guardar a referência para seu elemento anterior, dessa forma é possível percorrer-la nos dois sentidos, do ínicio ao final e do final ao ínico. No demais as operações são as mesmas da lista encadeada apenas alterando o fato de que as operações devem levar em consideração as duas referências.
  <br/>
  <br/>
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/150153957-9812abf4-f0b3-4f86-85dd-d8b3ba10fded.png">
  <br/>
  <br/>
</p>

<p align="justify">
   &nbsp &nbsp &nbsp &nbsp A figura acima tenta mostrar um represetação gráfica de como seria essa estutura, A qual podemos destacar a sua organização, como dita anteriormente é uma composição bem simples na qual está presente o um ponteiro para marcar a entrada da lista e seus elementos, que armazenam os dados e a referência para o elemento posterior e anterior.
  
# Implementação :
  <p align="justify" > Nessa seção será mostrado a estutura básica de uma lista duplamente encadeada e suas principais operações. </p>
  
  ## Implementação dos Elementos(Nós): 
  <p algin="justify"> Elementos que são responsáveis por armazenar os dados e a referências. </p>
  
  ```
package com.doublyLinkedList;

public class DoubleNode<T> {

    private T content;
    private DoubleNode<T> nextNode;
    private DoubleNode<T> previousNode;

    public DoubleNode(T content){
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public DoubleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "content=" + content +
                '}';
    }
}
  
  ```

## Implementação da estrutura básica da Lista: 
```

public class DoubleLinkedList<T> {

    private DoubleNode<T> firstNode;
    private DoubleNode<T> lastNode;

    private int listSize;
    
    
    public DoubleLinkedList(){
        this.firstNode= null;
        this.lastNode = null;
        this.listSize=0;
    }
}
      
```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp A estrutura básica é composta  por dois objetos  DoubleNode,que são responsáveis por marcar o ínicio e o fim da lista , e por uma variável listSize para demarcar o tamanho da lista 
  ,quando instanciado o construtor inicia o firstNode e o lastNode como null e listsize como 0 ,deixado dessa forma a lista vazia.
</p>

## Implementação do método size: 
```
public int size(){
        return  this.listSize;
    }
```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método size é um método bem simples que retorna apenas o valor do tamanho da lista, dessa forma sendo útil aos outros métodos que necessitam interar na estrutura.
</p>



## Implementação do método add:
 
 ```
 public void add (T element){
        DoubleNode<T> newNode =new DoubleNode<>(element);
        newNode.setNextNode(null);
        newNode.setPreviousNode(lastNode);
        if(firstNode == null){
            firstNode = newNode;
        }
        if(lastNode != null){
            lastNode.setNextNode(newNode);
        }

        lastNode= newNode;
        listSize++;
    }

    public void add(int index, T element){
        DoubleNode<T> auxNode = getNode(index);
        DoubleNode<T> newNode = new DoubleNode<>(element);
        newNode.setNextNode(auxNode);

        if(newNode.getNextNode() != null){
            newNode.setPreviousNode(auxNode.getPreviousNode());
            newNode.getNextNode().setPreviousNode(newNode);
        }else{
            newNode.setNextNode(lastNode);
            lastNode = newNode;
        }

        if(index == 0){
            firstNode = newNode;
        }else{
            newNode.getPreviousNode().setNextNode(newNode);
        }

        listSize++;
    }
 
 ```
 <p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp A adição de um novo elemento na lista é possível de duas formas, a primeira é inserir no final com o método add passando apenas o elemento e a outra é atráves da sobrecarga do método add o
  qual é passado além do elemento a posição a qual se deseja inserir o novo objeto.
  A inserção do elemento no final da lista é a forma mais simples de adição sendo necessário apenas percorrer a lista até o último elemento e mudar as referências do último elemento e do novo elemento, de forma que o elemento que era o antigo último será o penúltimo e novo elemento será o último.A inserção pela posição é um pouco 
  mais complexa que a inserção no final, uma vez que é necessário desfazer as referências dos elementos de forma a abrir um "espaço" para inserir o novo elemento, e setar as refêrencia dos nós levando em consideração o elemento adicionado;
</p>


## Implementação do método getNode:
```
private DoubleNode<T> getNode(int index){
        DoubleNode  auxNode=firstNode;

        for(int i=0;(i<index)&&(auxNode != null);i++){
            auxNode = auxNode.getNextNode();
        }
        return  auxNode;
    }

```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método getNode recebe o index e pecorre a lista até esse ponto e retorna o nó que está presente nesta posição, essa funcionalidade serve de base para o método de obter um elemento da lista e para o método remove.  
</p>


## Implementção do método get 
```
 public T get(int index){
        return this.getNode(index).getContent();
    }
```

<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método get retorna uma chamada do getNode(que realiza a busca) pegando apenas o conteúdo presente no nó.   
</p>


## Implementção do método remove 
```
public void remove(int index){
        if(index == 0){
            firstNode =firstNode.getNextNode();
            if(firstNode != null){
                firstNode.setPreviousNode(null);
            }
        }else{
            DoubleNode<T> auxNode = getNode(index);
            auxNode.getPreviousNode().setNextNode(auxNode.getNextNode());
            if(auxNode != lastNode){
                auxNode.getNextNode().setPreviousNode(auxNode.getPreviousNode());
            }else{
                lastNode =auxNode;
            }
        }
        this.listSize--;
    }
 
```

<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/150184054-16d5eac9-13a9-430a-8e84-baa64c82dcdf.png">
  <br/>
  <br/>
</p>

<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método remove deleta apartir de um indice passado, de forma geral o algoritmo de remoção retira as referências do elemento a ser excluído,assim o garbage collection elimina esse objeto da memória, e seta as referências dos elemento anterior e posterior e por fim o tamanho da lista é decrementado.
</p>



## Implementção do toString 
```
 @Override
    public String toString() {
        String strReturn = "";

        DoubleNode<T> auxNode = firstNode;

        for(int i =0;i <size();i++){
            strReturn +=  "[Node{content= " + auxNode.getContent() + "}] --->";
            auxNode = auxNode.getNextNode();
        }
        strReturn += "null";

        return  strReturn;
    }

```
<p align ="justify"> 
 O método toString Percorre toda a Lista e vai adicionando cada elemento em  a string que tem o objetivo de facilitar a visão da Lista quando ela é impresa.  
</p>

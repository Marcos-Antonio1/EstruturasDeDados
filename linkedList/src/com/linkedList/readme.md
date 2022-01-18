# Estrutura de Dados Linked List ou Lista encadeada:

## Descrição

  <p align= "justify">
      &nbsp &nbsp &nbsp &nbsp A Estrutura de lista encadeada tem como intuinto principal agrupar elementos na memória de forma a criar um encadeamento lógico de dados, na qual cada elemento tem seu valor interno e uma referência para o próximo objeto, além de ter outras implementações como listas circulares e listas duplamente encadeada elas são consideradas estruturas mais génericas e podem ser usadas na implementação de filas e pilhas, outro ponto relevante é que diferentemente de listas sequenciais as listas encadeadas  não necessariamente possuem elementos contíguos na memória. <br/>
    &nbsp &nbsp &nbsp &nbsp A utilização de listas encadeadas facilita as operações de remoção e inserção, uma vez que é apenas necessário saber a posição que se quer inserir e então alterar os ponteiros , de forma que o elemento anterior a posição que o novo elemento será inserido aponte para  o novo objeto e o novo objeto aponte para o nó o qual o seu elemento anterior fazia referência, porém apesar da facilidade de dessas operações esse tipo de estrutura 
  não é adequada para realizar busca binária, pois não é possível acessar o elemento diretamente,assim há sempre uma necessidade de percorrer a lista até chegar determinado elemento o que  aumenta o tempo para divisão da lista ao meio, deixando dessa forma ,a depender da lista, a busca binária  bem semelhante a uma busca sequêncial.
  <br/>
  <br/>
</p>


<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/149939924-dae413fa-76e4-4b04-bbd5-4cf351d53979.png">
  <br/>
  <br/>
</p>

<p align="justify">
   &nbsp &nbsp &nbsp &nbsp A figura acima tenta mostrar um represetação gráfica de como seria essa estutura, A qual podemos destacar a sua organização, como dita anteriormente é uma composição bem simples na qual está presente o um ponteiro para marcar a entrada da lista e seus elementos, que armazenam os dados e a referência para o elemento posterior.
  
# Implementação :
  <p align="justify" > Nessa seção será mostrado a estutura básica de uma lista encadeada e suas principais operações. </p>
  
  ## Implementação dos Elementos(Nós): 
  <p algin="justify"> Elementos que são responsáveis por armazenar os dados e a referências para o próximo objeto </p>
  
  ```
package com.linkedList;

public class Node<T> {

    private T content;
    private Node nextNode;

    public Node() {
        this.nextNode = null;
    }
    public Node(T content){
        this.content =content;
        this.nextNode = null;
    }

    public Node(T content, Node nextNode) {
        this.content = content;
        this.nextNode = nextNode;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        String str= "Node{" + "content=" + content + '}';

        if(nextNode !=null){
            str +=  "->" + nextNode.toString();
        }else{
            str += "-> null";
        }

        return str;
    }
}

  
  ```

## Implementação da estrutura básica da Fila: 
```
package com.linkedList;

public class LinkedList<T> {

    Node<T> inputReference;

    public  LinkedList(){
        this.inputReference= null;
    }
}

```

<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp A estrutura básica é composta  por uma objeto Node, o qual serve para referênciar a entrada da Lista , quando instanciado o construtor inicia o ponteiro de entrada como null,deixado dessa forma a lista vazia.
</p>

## Implementação do isEmpty: 
```
public boolean isEmpty(){
        return inputReference == null ? true : false;
    }

```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método isEmpty verifica se a Lista está vazia, para isso verifica o elemento de entrada, se este estiver null quer dizer que não há nenhum elemento e a Lista está vazia.
</p>



## Implementação do método size:
 ```
    public int size(){
        int listSize = 0;

        Node <T> referenceAux = inputReference;
        while (true){
            if(referenceAux != null){
                listSize++;
                if(referenceAux.getNextNode() != null){
                    referenceAux = referenceAux.getNextNode();
                }else {
                    break;
                }
            }else{
                break;
            }
        }

        return listSize;
    }
 
 ```
 <p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método size é responsável por percorrer toda a lista e contar os elementos presentes nela e assim retornar o tamanho da lista.  
</p>

## Implementação do método add:
 ```
  public void add(T content){
        Node<T> newNode = new Node<>(content);

        if(this.isEmpty()){
            inputReference = newNode;
            return;
        }

        Node <T> NodeAux =inputReference;

        for(int i = 0;i<this.size()-1;i++){
            NodeAux= NodeAux.getNextNode();
        }

        NodeAux.setNextNode(newNode);
    }
 ```
 <p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método add é responsável por adicionar um novo elemento ao final da lista, para isso inicialmente é realizado o teste se a lista está vazia, pois se isso for verdade o elemento será adicionando como a referência de entrada sendo assim o primeiro elemento, o outro caso corresponde ao cenário em que a lista já possui elementos e neste caso é utilizado um nó auxiliar responsável por percorrer toda a estrutura  com a ajuda de um laço de repetição, ao fim do laço o Nó auxiliar terá como referênncia o último elemento da estrutura e assim é possível adicionar o novo Nó. 
</p>

## Implementação do método validadeIndex:
 ```
 private void validateIndex(int index ){
        if(index >= size()){
            throw  new IndexOutOfBoundsException("There is no content in the index " + index + "this list");
        }
    }
 
 ```
 <p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método validadeIndex  verifica se o index passado é maior que o tamanho da lista, para sim evitar o erro de acessar um elemento que não está na lista.
</p>

## Implementação do método getNode:
```
private  Node<T> getNode(int index){

        validateIndex(index);

        Node<T> NodeAux= inputReference;
        Node<T> NodeReturn =null;

        for(int i = 0;i<=index;i++){

            NodeReturn = NodeAux;
            NodeAux= NodeAux.getNextNode();

        }
        return NodeReturn;
    }


```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método getNode recebe o index e pecorre a lista até esse ponto e retorna o nó que está presente nesta posição, essa funcionalidade serve de base para o método de obter um elemento da lista e para o método remove.  
</p>

## Implementção do método get 
```
 public T get(int index){
        return getNode(index).getContent();
    }

```

<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método get retorna uma chamada do getNode(que realiza a busca) pegando apenas o conteúdo presente no nó.   
</p>


## Implementção do método remove 
```
 public T remove(int index){
        Node<T> NodePivot =this.getNode(index);
        if(index == 0){
            inputReference = NodePivot.getNextNode();
            return NodePivot.getContent();
        }
        Node <T> NodePrevious = getNode(index-1);
        NodePrevious.setNextNode(NodePivot.getNextNode());
        return  NodePivot.getContent();
    }


```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método remove deleta um elemento ao retirar as referências para ele, a função recebe o index do elemento a ser removido e logo após é verificado se o index é o primeiro, pois se for a  remoção é simplemente apontar a referência da lista para o elemento logo após o primeiro e o elemento retirado e retornado, o outro cenário é se o index for diferente de 0,ou seja, o elemento está não está no inicio, sendo a assim a remoção se dá da seguinte forma: é necessário guardar o elemento anterior ao removido e isso é feito com o método getNode, assim é possível setar o a referência do NodePrevious para o elemento próximo ao deletado, isso faz com que o elemento deletado fique sem referência fazendo com que ele seja recolhido pelo garbage collection, por fim o elemento deletado é retornado. 
</p>



## Implementção do toString 
```
 @Override
    public String toString() {

        String strReturn ="";
        Node <T> NodeAux =inputReference;

        for(int i= 0;i<this.size();i++){
            strReturn += "Node{ content= "+NodeAux.getContent() + "} --->";
            NodeAux = NodeAux.getNextNode();
        }
        strReturn += "null";

        return  strReturn;
    }

```

<p align ="justify"> 
 O método toString Percorre toda a Lista e vai adicionando cada elemento em  a string que tem o objetivo de facilitar a visão da Lista quando ela é impresa.  
</p>

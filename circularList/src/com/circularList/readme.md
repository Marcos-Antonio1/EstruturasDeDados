# Estrutura de Dados Circular List ou Lista Circular:

## Descrição

  <p align= "justify">
      &nbsp &nbsp &nbsp &nbsp A Estrutura da lista circular tem como intuinto principal agrupar elementos na memória de forma a criar um encadeamento lógico 
  de dados, na qual cada elemento tem seu valor interno e uma referência para o próximo objeto, ela é uma variação da implementação de lista da qual se difere pelo fato do último elemeno possuir um ponteiro para o primeiro, assim tornando possível circular os elementos da estrutura. 
  <br/>
  <br/>
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/150361050-1051aaea-7bee-403d-8674-3614f9a3f4fd.png">
  <br/>
  <br/>
</p>

<p align="justify">
   &nbsp &nbsp &nbsp &nbsp A figura acima tenta mostrar um represetação gráfica de como seria essa estutura, A qual podemos destacar a sua organização, como dita anteriormente é uma composição bem simples na qual está presente o um ponteiro para marcar a entrada da lista e seus elementos, que armazenam os dados e a referência para o elemento posterior, com ênfase que específicamente a lista circular tem seu último elemento apontado para o início da lista.
  
# Implementação :
  <p align="justify" > Nessa seção será mostrado a estutura básica de uma lista Circular e suas principais operações. </p>
  
  ## Implementação dos Elementos(Nós): 
  <p algin="justify"> Elementos que são responsáveis por armazenar os dados e a referências. </p>
  
  ```
  package com.circularList;

public class Node<T>{

    private T content;
    private Node<T> nextNode;


    public Node(T content){
        this.nextNode =null;
        this.content = content;

    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "content=" + content +
                '}';
    }
} 
  ```
## Implementação da estrutura básica da Lista Circular: 
```

package com.circularList;

public class CircularList<T> {

    private Node<T> head;
    private Node<T> tail;
    private  int sizeList;

    public CircularList(){
        this.head =null;
        this.tail = null;
        this.sizeList =0;
    }
}
      
```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp A estrutura básica é composta  por dois objetos Node,que são responsáveis por marcar o ínicio e o fim da lista , e por uma variável listSize para demarcar o tamanho da lista 
  ,quando instanciado o construtor inicia o head e o tail como null e listsize como 0 ,deixado dessa forma a lista vazia.
</p>

## Implementação do método size: 
```
public int size(){
       return this.sizeList;
    }

```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método size é um método bem simples que retorna apenas o valor do tamanho da lista, dessa forma sendo útil aos outros métodos que necessitam interar na estrutura.
</p>

## Implementação do método add:
 
 ```
 public void add(T content){
        Node<T> newNode = new Node<>(content);
        if(isEmpty()){
            this.head =newNode;
            this.tail = this.head;
            this.head.setNextNode(tail);
        }else{
            newNode.setNextNode(this.tail);
            this.head.setNextNode(newNode);
            this.tail = newNode;
        }
        this.sizeList++;
    }
 ```
 <p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método add é o responsável por adicionar novos elementos a estrutura, assim o elemento a ser adicionado é passado como parâmetro e logo um novo nó é instanciado, esse método especificamente insere os elementos a partir da refência da cauda, ou seja, sempre no início da lista.
  Tendo isso em vista é feita a comparação se a lista está vazia, pois se estiver o elemento inserido vai ser tanto a cauda quando a cabeça da lista pelo fato da lista não possuir nenhum elemento, caso contrário  o novo nó vai receber como referência de próximo o nó que está na cauda, além disso  cabeça irá apontar para o novo nó porque esse agora é a nova cauda e por fim a 
  variável cauda aponta para o novo nó, desta forma é possível fazer a inserção do elemento na lista.
</p>


## Implementação do método getNode:
```
 private Node<T> getNode(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("the is Empty");
        if(index == 0){
            return this.tail;
        }
        Node<T> auxNode = this.tail;
        for(int i =0 ;i<index;i++){
            auxNode = auxNode.getNextNode();
        }

        return auxNode;
    }

```
<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método getNode recebe o index e pecorre a lista até esse ponto e retorna o nó que está presente nesta posição, essa funcionalidade serve de base para o método de obter um elemento da lista e para o método remove.  
</p>


## Implementção do método get 
```
    public T get(int index){
        return  this.getNode(index).getContent();
    }
```

<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método get retorna uma chamada do getNode(que realiza a busca) pegando apenas o conteúdo presente no nó.   
</p>


## Implementção do método remove 
```
 public void remove(int index){
        if(index >= size()){
            throw  new IndexOutOfBoundsException("Index Invalid");
        }
        Node<T> auxNode = this.tail;

        if(index == 0){
            this.tail = this.tail.getNextNode();
            this.head.setNextNode(this.tail);
        }else if(index == 1){
            this.tail.setNextNode(this.tail.getNextNode());
        }else{
            for(int i =0; i< index -1;i++){
                auxNode = auxNode.getNextNode();
            }

```


<p align ="justify"> 
 &nbsp &nbsp &nbsp &nbsp O método remove deleta apartir de um indice passado, de forma geral o algoritmo de remoção retira a referência do elemento a ser excluído,assim o garbage collection elimina esse objeto da memória, e seta as referências dos elemento anterior  e por fim o tamanho da lista é decrementado.
</p>



## Implementção do toString 
```
  @Override
    public String toString() {
        String str = "";

        Node<T> auxNode = this.tail;
        for(int i=0; i<size();i++){
            str += "[Node{content ="+auxNode.getContent() +"}] --->";
            auxNode = auxNode.getNextNode();
        }
        str += this.size() != 0 ?"[Node{content ="+tail.getContent() +"}]": "[]";
        return  str;
    }
}

```
<p align ="justify"> 
 O método toString Percorre toda a Lista e vai adicionando cada elemento em  a string que tem o objetivo de facilitar a visão da Lista quando ela é impresa.  
</p>

# Estrutura de Dados Linked List ou Lista encadeada:

## Descrição

  <p align= "justify">
     A Estrutura de lista encadeada tem como intuinto principal agrupar elementos na memória de forma a criar um encadeamento lógico de dados, na qual cada elemento tem seu valor interno e uma referência para o próximo objeto, além de ter outras implementações como listas crculares e listas duplamente encadeada elas são consideradas estruturas mais génericas e podem ser usadas na implementação de filas e pilhas, outro ponto relevante é que diferentemente de lista sequenciais as listas encadeadas  não necessariamente possuem elementos contíguos na memória.
     A utilização de listas encadeadas facilita as operações de remoção e inserção, uma vez que é apenas necessário saber a posição que se quer inserir e então alterar os ponteiros , de forma que o elemento anterior a posição que o novo elemento será inserido aponte para no o novo objeto e o novo objeto aponte para o nó o qual o seu elemento anterior fazia referência, porém apesar da facilidade de dessas operações esse tipo de estrutra 
  não é adequada para realizar busca binária, pois devido a impossibilidade de acessar o elemento diretamente, há sempre uma necessidade de percorrer a lista até chegar determinado elemento o que dificulta aumenta o tempo para divisão da lista ao meio, deixando dessa forma a depender da lista a busca binária nessa esrutura bem parecida 
  <br/>
  <br/>
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/149550329-d517f841-1a6a-4a11-ad4d-a0eafc54f89d.png">
  <br/>
  <br/>
</p>

<p align="justify">
    A figura acima tenta mostrar um represetação gráfica de como seria essa estutura, A qual podemos destacar as principais operações realizadas que são enqueue(enfileirar) colocar no fim da Fila um novo elemento e dequeue(desenfileirar) retirar o elemento do início da Fila, cabe resaltar,ainda, a importância do ponteiro que  sempre armazena a referência do inicio da Fila, desta forma, servindo como base para as outras operações.

# Implementação :
  <p align="justify" > Nessa seção será mostrado a estutura básica de um pilha e suas principais operações. </p>
  
  ## Implementação dos Elementos(Nós): 
  <p algin="justify"> Elementos que são responsáveis por armazenar os dados e a referências para o próximo objeto </p>
  
  ```
  package com.queue;

public class Node<T> {

    private T object;
    private  Node <T> refNode;

    public Node(){

    }

    public Node(T object){
       this.object =object;
       this.refNode = null;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node getRefNode() {
        return refNode;
    }

    public void setRefNode(Node refNode) {
        this.refNode = refNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "object=" + object +
                '}';
    }
}

  
  ```

## Implementação da estrutura básica da Fila: 
```
public class Queue<T> {

    private Node<T> refNodeInput; // referência para a entrada ou fim da fila

    public Queue() {
        this.refNodeInput = null;
    }

```

<p align ="justify"> 
  A estrutura básica é composta  por uma objeto Node, o qual serve para referênciar o fim(ou entrada) da Fila, quando instanciado o construtor inicia o ponteiro de entrada como null,deixado dessa forma a Fila vazia.
</p>

## Implementação do Enqueue:
 ```
public void enqueue(Node<T> newNode) {
        newNode.setRefNode(refNodeInput);
        refNodeInput = newNode;
    }
 
 ```
 <p align ="justify"> 
  O método enqueue é responsável por enfileirar o item na Fila tomando como referência o ponteiro que aponta para  fim(refNodeInput), de forma que o newNode recebe os dados adicionado antes dele como referência de próximo elemento e o fim da fila recebe o elemento adicionado, assim criando um encadeamento do último elemento e o penúltimo e consequentemente toda a ordem lógica da Fila.  
</p>

## Implementação do isEmpty: 
```
public boolean isEmpty(){
        return refNodeInput == null ? true : false;
    }

```
<p align ="justify"> 
  O método isEmpty verifica se a Fila está vazia, para isso verifica o elemento de entrada, se este estiver null quer dizer que não há nenhum elemento e a Fila está vazia.
</p>

## Implementação do Dequeue:
```
public Node<T> dequeue() {
        if (!this.isEmpty()) {
            Node firstNode = refNodeInput;
            Node secondNode = refNodeInput;
            while (true) {
                if (firstNode.getRefNode() != null) {
                    secondNode = firstNode;
                    firstNode = firstNode.getRefNode();
                } else {
                    secondNode.setRefNode(null);
                    break;
                }
            }
            return firstNode;
        }
        return  null;
    }

```
<p align ="justify"> 
 O método dequeue retira o elemento da Fila seguindo a especificação FIFO, ou seja, o primeiro elemento ou simplismente o elemento mais antigo da estrutura. Desse modo é feita a verificação se a Fila está vazia, não estando vazia é necessário guarda o penúltimo(fistNode) e o último(secondNode) elemento que no percorrer da lista se tornarão o primeiro e segundo elemento, pois uma vez o primeiro elemento é retirado o próximo elemento que ficará apto a deixar a estrutura será o anterior. Dando continuidade a nossa lógica  o while garante que a execução infinita até chegar o último  elemento e o break é acionado, enquanto isso não acontece toda estrutura é percorrida  de forma que o  firstNode e o secondNode vão recebendo os próximos elementos, mas sempre o firstNode um elemento a frente.
  Quando o primeiro elemento da fila é encontrado, o secondNode recebe como próximo elemento a  referência null, fazendo com que depois dele não tenha outro elemento e assim ele se torna o primeiro elemento e firstNode é retornado com elemento removido. 
</p>

## Implementção do First 
```
public Node<T> first(){
        Node firstNode = null;
        if(!this.isEmpty()){
            Node currentNode = refNodeInput;
            while (true){
               if(currentNode.getRefNode() != null){
                   currentNode = currentNode.getRefNode();
               }else{
                   firstNode=currentNode;
                   break;
               }
            }
        }
        return firstNode;
    }

```

<p align ="justify"> 
 O método Firts Percorre toda a fila até chegar ao primeiro elemento e o retorna.  
</p>



## Implementção do toString 
```
@Override
    public String toString() {
        String stringReturn = "";
        Node Nodeaux =  refNodeInput;
        if(refNodeInput != null){
            while (true){
                stringReturn += "[Node{object="+Nodeaux.getObject() +"}] ---->";
                if(Nodeaux.getRefNode() != null){
                    Nodeaux =Nodeaux.getRefNode();
                }else{
                     break;
                 }
            }
        }else{
            stringReturn ="null";
        }
        return  stringReturn;
    }
```

<p align ="justify"> 
 O método toString Percorre toda a fila e vai adicionando cada elemento em  a string que tem o objetivo de facilitar a visão da fila quando ela é impresa.  
</p>


# Pricipais usos :

* Controle da ordem de execução de processos;
* Controle de documentos para impressão;
* Troca de mensagem entre computadores numa rede;

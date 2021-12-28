# Estrutura de Pilha(Stack):

## Descrição

  <p align= "justify">
  O conceito da estrutura Pilha tem como conceito implementar um encadeamento de nós assim como em outras estruturas, porém ela segue regras específicas de manipulação conhecida como LIFO(Last in First Out), a qual restringe a entrada e saída de elemento de modo que  o  último elemento adicionado sempre será o próximo a ser retirado se assemelhando ,dessa forma, com uma pilha real como por exemplo uma pilha de livros ou pratos.
  <br/>
  <br/>
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/147575949-b4962236-e6b7-4e12-8cf8-36b22effa95e.png">
  <br/>
  <br/>
</p>

<p align="justify">
    A figura acima tenta mostrar um represetação gráfica de como seria essa estutura, Na qual podemos destacar as principais operações realizadas por uma pilha que são push(empilhar) colocar no topo da pilha e pop(desempilhar) retirar o elemento do topo da pilha, cabe resaltar,ainda, a importância do top(ponteiro) o qual sempre armazena a referência do topo da lista, desta forma, servindo como base para as outras operações.

# Implementação :
  <p align="justify" > Nessa seção será mostrado a estutura básica de um pilha e suas principais operações. </p>
  
  ## Implementação dos Elementos(Nós): 
  <p algin="justify"> Elementos que são responsáveis por armazenar os dados e a referências para o próximo objeto </p>
  
  ```
  public class Node {

    private int dado;
    private Node nextNode;

    public Node(int dado) {
        this.nextNode= null;
        this.dado = dado;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "dado=" + dado +
                '}';
    }
}
  
  ```

## Implementação da estrutura básica da pilha: 
```
public class Stack {

    private Node top;


    public Stack() {
        this.top= null;
    }
}

```

<p align ="justify"> 
  A estrutura básica é composta  por uma objeto Node, o qual serve para referênciar o top da pilha, quando instanciado a pilha recebe seu top null, deixado dessa forma a pilha vazia.
</p>

## Implementação do Push:
 ```
 public void push(Node newNode){
        Node aux = top;
        this.top = newNode;
        top.setNextNode(aux);
    }
 
 ```
 <p align ="justify"> 
  O método push é responsável por empilhar o item na pilha acima dos demais, de forma que o top recebe o elemento adicionado, e o newNode recebe como seu próximo Node sempre o elemento anteriomente inserido na estrutura, garantindo assim o empilhamento dos Nós.
</p>

## Implementação do isEmpty: 
```
public Boolean isEmpty(){
           if(top == null){
               return true;
           }
           return false;
    }

```
<p align ="justify"> 
  O método isEmpty verifica se a pilha está vazia, para isso verifica o elemento top se este estiver null quer dizer que não há nenhum elemento.
</p>

## Implementação do Pop:
```
public Node pop(){
        if(!this.isEmpty()){
            Node noPoped =top;
            top = top.getNextNode();
            return noPoped;
        }
        return null;
    }

```
<p align ="justify"> 
 O método Pop retira o elemento do top da lista seguindo a especificação LIFO. Desse modo é feita a verificação se a pilha está vazia, não estando vazia o elemento do topo é retirado e a referência top recebe o nextNode do elemento retirado, assim o top fica sendo o elemento mais abaixo do item retirado da estrutura.  
</p>

## Implementção do peek 
```

 public Node peek(){
    return  this.top;
 }

```

<p align ="justify"> 
 O método Peek retorna o elemento do topo da lista sem removê-lo.  
</p>


# Pricipais uso :

* Gerenciamento de Memória em Tempo de Compilação;
* Avaliação de Expressões e Parsing Sintático;
* Algoritmos Recursivos;
* Análise de expressões aritméticas;
* Endereçamento de instruções em microprocessadores;
* Operações como desfazer e refazer em aplicações;
* Controle de navegação em browsers;

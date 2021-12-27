# Estrutura de dados Node ou Nó: 

## Descrição

<p align= "justify">
  O conceito da estrutura Nó é ter um espaço na memória que possa armazernar tanto um dado quando a referência para um outro Nó, desse modo  é considerada uma estrutura muito importante pelo fato de ser fundamental para a criação de outras estruturas.
  <br/>
  <br/>
</p>
<p align="center">
  <img src="https://user-images.githubusercontent.com/33884828/147513327-84dd3692-4f89-42d6-9bcc-8669e8a819b7.png">
</p>

<p align="justify">
    A figura acima tenta mostrar um represetação gráfica de como seria essa estutura, na qual o campo representado por data é o dado em si que deve ser guardado e o next é um ponteiro para a próxima estrutura.
</p>

# implementação:

```

public class Node<T> {

    private T content;      // conteúdo armazenado do tipo genérico 
    private Node nextNode;  // referência para o próximo Node

    public Node(T content) {
        this.nextNode = null;
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Node{" +
                "content=" + content +
                '}';
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
}

```

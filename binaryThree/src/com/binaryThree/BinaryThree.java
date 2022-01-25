package com.binaryThree;

public class BinaryThree<T extends Comparable<T>> {

    private BinNode<T> root;


    public void insert(T content){
        BinNode<T> newNode = new BinNode<>(content);
        root = insert(root, newNode);
    }

    private BinNode<T> insert(BinNode<T> current, BinNode<T> newNode){
        if(current == null){
            return newNode;
        }else if(newNode.getContent().compareTo(current.getContent()) < 0){
            current.setLeftNode(insert(current.getLeftNode(), newNode));
        }else{
            current.setRightNode(insert(current.getRightNode(), newNode));
        }
        return current;
    }


    public void inOrder(){
        System.out.println("\n Show inOrder");
        inOrder(this.root);
    }
    private void inOrder(BinNode current ){
        if( current != null){
            inOrder(current.getLeftNode());
            System.out.print(current.getContent()+ ", ");
            inOrder(current.getRightNode());
        }
    }

    public void posOrder(){
        System.out.println("\n Show posOrder");
        posOrder(this.root);
    }
    private void posOrder(BinNode current ){
        if( current != null){
            posOrder(current.getLeftNode());
            posOrder(current.getRightNode());
            System.out.print(current.getContent()+ ", ");
        }
    }

    public void preOrder(){
        System.out.println("\n Show preOrder");
        preOrder(this.root);
    }
    private void preOrder(BinNode current ){
        if( current != null){
            System.out.print(current.getContent()+ ", ");
            preOrder(current.getLeftNode());
            preOrder(current.getRightNode());
        }
    }
    public void remove(T content){
        try{
            BinNode<T> current = this.root;
            BinNode<T> father = null;
            BinNode<T> children = null;
            BinNode<T> temp = null;

            while (current != null && !current.getContent().equals(content)){
                father = current;
                if(content.compareTo(current.getContent()) < 0){
                    current = current.getLeftNode();
                }else {
                    current = current.getRightNode();
                }
            }

            if(current == null){
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            if(father == null){
                if(current.getRightNode() == null){
                    this.root = current.getLeftNode();
                }else if(current.getLeftNode() == null){
                    this.root = current.getRightNode();
                }else {
                    for(temp = current, children = current.getLeftNode();
                        children.getRightNode() != null;
                        temp = children, children = children.getLeftNode()
                    ){
                        if(children != current.getLeftNode()){
                            temp.setRightNode(children.getLeftNode());
                            children.setLeftNode(root.getLeftNode());
                        }
                    }
                    children.setRightNode(root.getRightNode());
                    root = children;
                }
            }else if(current.getRightNode() == null){
                if(father.getLeftNode() == current){
                    father.setLeftNode(current.getLeftNode());
                }else {
                    father.setRightNode(current.getLeftNode());
                }
            }else if(current.getLeftNode() == null){
                if(father.getLeftNode() == current){
                    father.setLeftNode(current.getRightNode());
                }else {
                    father.setRightNode(current.getRightNode());
                }
            }else{
                for(
                        temp = current, children = current.getLeftNode();
                        children.getRightNode() != null;
                        temp = children, children = children.getRightNode()
                ){
                    if(children != current.getLeftNode()){
                        temp.setRightNode(children.getLeftNode());
                        children.setLeftNode(current.getLeftNode());
                    }
                    children.setRightNode(current.getRightNode());
                    if(father.getLeftNode() == current){
                        father.setLeftNode(children);
                    }else{
                        father.setRightNode(children);
                    }
                }
            }
        }catch (NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }
}

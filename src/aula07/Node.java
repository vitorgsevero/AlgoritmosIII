package aula07;

public interface Node<T> {
    public boolean equals(K key);
    public Node<T> next();
}

//Assumindo que o método equals() retorna verdadeiro para a chave que reperesenta o objeto armazenado em um Node, e falso caso contrário, 
//implemente, utilizando um algoritmo recursivo, o metodo search(), na classe LinkedList:

class LinkedList<T> {
    private Node<T> head;

    public Node<T> search(K key) {
        // seu código...
    }
    
}
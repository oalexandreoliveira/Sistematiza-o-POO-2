package model;

public class Node {
    private final Contact contact; // O contato associado ao nó, definido como final
    private Node next; // Referência ao próximo nó na lista

    // Construtor que inicializa o nó com um objeto Contact
    public Node(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Erro: O contato não pode ser nulo.");
        }
        this.contact = contact;
        this.next = null;
    }

    // Retorna o contato armazenado no nó
    public Contact getContact() {
        return contact;
    }

    // Retorna o próximo nó na lista
    public Node getNext() {
        return next;
    }

    // Define o próximo nó na lista
    public void setNext(Node next) {
        this.next = next;
    }
}

package controller;

import model.Contact;
import model.Node;

public class ContactList {
    private Node head;

    // Método para adicionar um novo contato à lista
    public void addContact(Contact contact) {
        if (contact == null || contact.getName().isEmpty() || contact.getPhoneNumber().isEmpty()) {
            System.out.println("Erro: Contato inválido. Nome e número de telefone são obrigatórios.");
            return;
        }

        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        System.out.println("Contato adicionado com sucesso: " + contact.getName());
    }

    // Método para buscar um contato pelo nome ou telefone
    public Contact searchContact(String query) {
        if (query == null || query.isEmpty()) {
            System.out.println("Erro: A pesquisa não pode estar vazia.");
            return null;
        }

        Node current = head;
        while (current != null) {
            Contact contact = current.getContact();
            if (contact.getName().equalsIgnoreCase(query) || contact.getPhoneNumber().equals(query)) {
                System.out.println("Contato encontrado: " + contact.getName());
                return contact;
            }
            current = current.getNext();
        }

        System.out.println("Erro: Contato não encontrado.");
        return null;
    }

    // Método para remover um contato pelo nome ou telefone
    public boolean removeContact(String query) {
        if (query == null || query.isEmpty()) {
            System.out.println("Erro: A chave de remoção não pode estar vazia.");
            return false;
        }

        if (head == null) {
            System.out.println("Erro: A lista de contatos está vazia.");
            return false;
        }

        // Caso o contato a ser removido seja o primeiro
        if (head.getContact().getName().equalsIgnoreCase(query) || head.getContact().getPhoneNumber().equals(query)) {
            System.out.println("Contato removido com sucesso: " + head.getContact().getName());
            head = head.getNext();
            return true;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.getContact().getName().equalsIgnoreCase(query) || current.getContact().getPhoneNumber().equals(query)) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                }
                System.out.println("Contato removido com sucesso: " + current.getContact().getName());
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        System.out.println("Erro: Contato não encontrado para remoção.");
        return false;
    }

    // Método para listar todos os contatos
    public void listContacts() {
        if (head == null) {
            System.out.println("Nenhum contato encontrado.");
            return;
        }

        Node current = head;
        System.out.println("Lista de contatos:");
        while (current != null) {
            System.out.println(current.getContact());
            current = current.getNext();
        }
    }
}


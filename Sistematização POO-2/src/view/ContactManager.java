package view;

import controller.ContactList;
import model.Contact;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = new ContactList();
        int option = -1;

        try {
            while (option != 0) {
                System.out.println("\n===== Menu =====");
                System.out.println("1. Adicionar Contato");
                System.out.println("2. Buscar Contato");
                System.out.println("3. Remover Contato");
                System.out.println("4. Listar Todos os Contatos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                try {
                    option = scanner.nextInt();
                    scanner.nextLine();  // Limpa o buffer
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine();  // Limpa o buffer
                    continue;
                }

                switch (option) {
                    case 1:
                        // Adicionar um contato
                        System.out.print("Nome: ");
                        String name = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        if (name.isEmpty() || phoneNumber.isEmpty()) {
                            System.out.println("Erro: Nome e Telefone são obrigatórios.");
                        } else {
                            Contact newContact = new Contact(name, phoneNumber, email);
                            contactList.addContact(newContact);
                            System.out.println("Contato adicionado com sucesso!");
                        }
                        break;

                    case 2:
                        // Buscar um contato pelo nome ou telefone
                        System.out.print("Digite o nome ou telefone do contato: ");
                        String searchQuery = scanner.nextLine();
                        Contact foundContact = contactList.searchContact(searchQuery);
                        if (foundContact != null) {
                            System.out.println("Contato encontrado: " + foundContact);
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;

                    case 3:
                        // Remover um contato pelo nome ou telefone
                        System.out.print("Digite o nome ou telefone do contato a ser removido: ");
                        String removeQuery = scanner.nextLine();
                        boolean removed = contactList.removeContact(removeQuery);
                        if (removed) {
                            System.out.println("Contato removido com sucesso!");
                        } else {
                            System.out.println("Contato não encontrado.");
                        }
                        break;

                    case 4:
                        // Listar todos os contatos
                        System.out.println("Lista de contatos:");
                        contactList.listContacts();
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        } finally {
            scanner.close();  // Fecha o scanner para evitar vazamento de recursos
        }
    }
}
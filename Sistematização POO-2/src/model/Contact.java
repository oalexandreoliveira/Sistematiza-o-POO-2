package model;

public class Contact {
    private final String name;
    private final String phoneNumber;
    private final String email;

    // Construtor com validação de entrada
    public Contact(String name, String phoneNumber, String email) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome não pode estar vazio.");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Erro: Número de telefone não pode estar vazio.");
        }

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email; // O email é opcional, então não valida aqui
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Sobrescreve toString para exibir os detalhes do contato de forma amigável
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(name);
        sb.append(", Telefone: ").append(phoneNumber);
        if (email != null && !email.isEmpty()) {
            sb.append(", Email: ").append(email);
        } else {
            sb.append(", Email: [não informado]");
        }
        return sb.toString();
    }
}

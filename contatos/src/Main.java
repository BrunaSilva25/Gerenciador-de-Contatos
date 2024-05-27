import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static GerenciadorContatos gerenciador = new GerenciadorContatos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("1. Adicionar contato");
            System.out.println("2. Visualizar contatos");
            System.out.println("3. Excluir contato");
            System.out.println("4. Editar contato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    visualizarContatos();
                    break;
                case 3:
                    excluirContato();
                    break;
                case 4:
                    editarContato();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    private static void adicionarContato() {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.next();
        System.out.print("Telefone: ");
        String telefone = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        Contato contato = new Contato(nome, sobrenome, telefone, email);
        gerenciador.adicionarContato(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void visualizarContatos() {
        System.out.println("Contatos:");
        for (Contato contato : gerenciador.getContatos()) {
            System.out.println(contato.getNome() + " " + contato.getSobrenome() + " - " + contato.getTelefone() + " - " + contato.getEmail());
        }
    }

    private static void excluirContato() {
        System.out.print("Digite o nome do contato que deseja excluir: ");
        String nome = scanner.next();
        System.out.print("Digite o sobrenome do contato que deseja excluir: ");
        String sobrenome = scanner.next();

        if (gerenciador.excluirContato(nome, sobrenome)) {
            System.out.println("Contato excluído com sucesso!");
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    private static void editarContato() {
        if (gerenciador.getContatos().isEmpty()) {
            System.out.println("Nenhum contato cadastrado para editar.");
            return;
        }

        System.out.print("Digite o nome do contato que deseja editar: ");
        String nome = scanner.next();
        System.out.print("Digite o sobrenome do contato que deseja editar: ");
        String sobrenome = scanner.next();

        Contato contato = gerenciador.buscarContato(nome, sobrenome);
        if (contato != null) {
            System.out.println("Digite os novos dados do contato:");
            System.out.print("Nome: ");
            contato.setNome(scanner.next());
            System.out.print("Sobrenome: ");
            contato.setSobrenome(scanner.next());
            System.out.print("Telefone: ");
            contato.setTelefone(scanner.next());
            System.out.print("Email: ");
            contato.setEmail(scanner.next());
            System.out.println("Contato editado com sucesso!");
        } else {
            System.out.println("Contato não encontrado!");
        }
    }
}
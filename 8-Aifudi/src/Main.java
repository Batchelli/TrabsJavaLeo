import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aplicativo aplicativo = new Aplicativo();

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuUsuario(aplicativo, scanner);
                    break;
                case 2:
                    menuRestaurante(aplicativo, scanner);
                    break;
                case 3:
                    menuAdmin(aplicativo, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Menu Usuário");
        System.out.println("2. Menu Restaurante");
        System.out.println("3. Menu Admin");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuUsuario(Aplicativo aplicativo, Scanner scanner) {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        Usuario usuario = aplicativo.buscarUsuarioPorCPF(cpf);

        if (usuario != null) {
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
            if (senha.equals("senha123")) {
                menuPedido(aplicativo, usuario, scanner);
            } else {
                System.out.println("Senha incorreta.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private static void menuPedido(Aplicativo aplicativo, Usuario usuario, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Pedido ===");
            exibirRestaurantes(aplicativo.getRestaurantes());
            System.out.println("0. Voltar");
            System.out.print("Escolha um restaurante ou 0 para voltar: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao > 0 && opcao <= aplicativo.getRestaurantes().size()) {
                Restaurante restauranteSelecionado = aplicativo.getRestaurantes().get(opcao - 1);

                System.out.println("\n=== Cardápio de " + restauranteSelecionado.getNome() + " ===");
                List<Item> cardapio = restauranteSelecionado.getCardapio();
                for (int i = 0; i < cardapio.size(); i++) {
                    Item item = cardapio.get(i);
                    System.out.println((i + 1) + ". " + item.getNome() + " - R$" + item.getPreco());
                }

                List<Item> itensSelecionados = new ArrayList<>();
                double totalPedido = 0;

                System.out.println("\nEscolha os itens (digite os números separados por espaço):");
                String escolhas = scanner.nextLine();
                String[] escolhasArray = escolhas.split(" ");

                for (String escolha : escolhasArray) {
                    try {
                        int indiceItem = Integer.parseInt(escolha) - 1;
                        if (indiceItem >= 0 && indiceItem < cardapio.size()) {
                            Item itemSelecionado = cardapio.get(indiceItem);
                            itensSelecionados.add(itemSelecionado);
                            totalPedido += itemSelecionado.getPreco();
                        }
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    }
                }

                System.out.println("\n=== Itens Escolhidos ===");
                for (Item item : itensSelecionados) {
                    System.out.println(item.getNome() + " - R$" + item.getPreco());
                }
                System.out.println("Total do Pedido: R$" + totalPedido);

                System.out.print("\nDeseja confirmar o pedido? (S/N): ");
                String confirmacao = scanner.nextLine().toUpperCase();

                if ("S".equals(confirmacao)) {
                    Pedido novoPedido = new Pedido(restauranteSelecionado, usuario, itensSelecionados, totalPedido);
                    aplicativo.realizarPedido(novoPedido);
                    System.out.println("Pedido realizado com sucesso!");

                    System.out.println("Total da Compra: R$" + totalPedido);
                    return;
                } else {
                    System.out.println("Pedido cancelado.");
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }


    private static void menuCardapio(Aplicativo aplicativo, Restaurante restaurante, Usuario usuario, Scanner scanner) {
    }

    private static void exibirRestaurantes(List<Restaurante> restaurantes) {
        System.out.println("Escolha um restaurante:");
        for (int i = 0; i < restaurantes.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantes.get(i).getNome());
        }
    }

    private static void menuRestaurante(Aplicativo aplicativo, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Restaurante ===");
            exibirRestaurantes(aplicativo.getRestaurantes());
            System.out.println("0. Voltar");
            System.out.print("Escolha um restaurante ou 0 para voltar: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao > 0 && opcao <= aplicativo.getRestaurantes().size()) {
                Restaurante restauranteSelecionado = aplicativo.getRestaurantes().get(opcao - 1);
                menuCardapioRestaurante(aplicativo, restauranteSelecionado, scanner);
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuCardapioRestaurante(Aplicativo aplicativo, Restaurante restaurante, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Cardápio ===");
            System.out.println("1. Adicionar item ao cardápio");
            System.out.println("2. Remover item do cardápio");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarItemCardapio(restaurante, scanner);
                    break;
                case 2:
                    removerItemCardapio(restaurante, scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarItemCardapio(Restaurante restaurante, Scanner scanner) {
        System.out.print("Digite o nome do item: ");
        String nomeItem = scanner.nextLine();
        System.out.print("Digite o preço do item: ");
        double precoItem = scanner.nextDouble();
        scanner.nextLine();

        Item novoItem = new Item(nomeItem, precoItem);
        restaurante.adicionarItemAoCardapio(novoItem);
        System.out.println("Item adicionado ao cardápio: " + nomeItem);
    }

    private static void removerItemCardapio(Restaurante restaurante, Scanner scanner) {
        System.out.print("Digite o nome do item a ser removido: ");
        String nomeItem = scanner.nextLine();

        Item itemRemover = null;
        for (Item item : restaurante.getCardapio()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemRemover = item;
                break;
            }
        }

        if (itemRemover != null) {
            restaurante.removerItemDoCardapio(itemRemover);
            System.out.println("Item removido do cardápio: " + nomeItem);
        } else {
            System.out.println("Item não encontrado no cardápio.");
        }
    }

    private static void menuAdmin(Aplicativo aplicativo, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Restaurante");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarNovoUsuario(aplicativo, scanner);
                    break;
                case 2:
                    cadastrarNovoRestaurante(aplicativo, scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarNovoUsuario(Aplicativo aplicativo, Scanner scanner) {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do usuário: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o CPF do usuário: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, endereco, cpf, senha);
        aplicativo.cadastrarUsuario(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso: " + nome);
    }

    private static void cadastrarNovoRestaurante(Aplicativo aplicativo, Scanner scanner) {
        System.out.print("Digite o nome do restaurante: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a localização do restaurante: ");
        String localizacao = scanner.nextLine();

        Restaurante novoRestaurante = new Restaurante(nome, localizacao);
        aplicativo.cadastrarRestaurante(novoRestaurante);
        System.out.println("Restaurante cadastrado com sucesso: " + nome);
    }
}

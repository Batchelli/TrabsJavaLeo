
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {

    private Aplicativo aplicativo;
    private List<Usuario> usuariosCadastrados;
    private List<Restaurante> restaurantesCadastrados;
    private Usuario usuario;
    private Restaurante restaurante;

    public Window(Aplicativo aplicativo, List<Usuario> usuariosCadastrados, List<Restaurante> restaurantesCadastrados) {
        this.aplicativo = aplicativo;
        this.usuariosCadastrados = usuariosCadastrados;
        this.restaurantesCadastrados = restaurantesCadastrados;
        this.usuario = null;
        this.restaurante = null;

        setTitle("AiFudi");
        setSize(450, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        JButton usuarioButton = new JButton("Menu Usuário");
        JButton restauranteButton = new JButton("Menu Restaurante");
        JButton adminButton = new JButton("Menu Admin");
        JButton exitButton = new JButton("Sair");

        usuarioButton.addActionListener(e -> openUsuarioMenu());
        restauranteButton.addActionListener(e -> openRestauranteMenu());
        adminButton.addActionListener(e -> openAdminMenu());
        exitButton.addActionListener(e -> System.exit(0));

        add(usuarioButton);
        add(restauranteButton);
        add(adminButton);
        add(exitButton);
    }

    private void exibirPedido(List<Item> itensSelecionados, double totalPedido) {
        if (usuario != null && restaurante != null) {
            StringBuilder pedidoText = new StringBuilder("Pedido feito por " + usuario.getNome() +
                    " no restaurante " + restaurante.getNome() + "\n=== Itens Escolhidos ===");

            for (Item item : itensSelecionados) {
                pedidoText.append("\n").append(item.getNome()).append(" - R$").append(item.getPreco());
            }

            pedidoText.append("\nTotal do Pedido: R$").append(totalPedido);

            JOptionPane.showMessageDialog(this, pedidoText.toString(), "Resumo do Pedido", JOptionPane.INFORMATION_MESSAGE);

            int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja confirmar o pedido?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                Pedido novoPedido = new Pedido(restaurante, usuario, itensSelecionados, totalPedido);
                aplicativo.realizarPedido(novoPedido);
                JOptionPane.showMessageDialog(this, "Pedido realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Pedido cancelado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao exibir o pedido. Usuário ou restaurante não definidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void openUsuarioMenu() {
        String cpf = JOptionPane.showInputDialog(this, "Digite seu CPF:");

        Usuario usuarioEncontrado = aplicativo.buscarUsuarioPorCPF(cpf);

        if (usuarioEncontrado != null) {
            String senha = JOptionPane.showInputDialog(this, "Digite sua senha:");

            if (senha != null && senha.equals(senha)) {
                usuario = usuarioEncontrado;
                menuPedido(usuario);
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirCardapio(Restaurante restaurante) {
        List<Item> cardapio = restaurante.getCardapio();
        StringBuilder cardapioText = new StringBuilder("\n=== Cardápio de " + restaurante.getNome() + " ===");
        for (int i = 0; i < cardapio.size(); i++) {
            Item item = cardapio.get(i);
            cardapioText.append("\n").append((i + 1)).append(". ").append(item.getNome()).append(" - R$").append(item.getPreco());
        }

        JOptionPane.showMessageDialog(this, cardapioText.toString(), "Cardápio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void realizarPedido(Usuario usuario, Restaurante restaurante) {
        List<Item> itensSelecionados = new ArrayList<>();
        double totalPedido = 0;

        while (true) {
            String escolha = JOptionPane.showInputDialog(this, "Escolha um item (ou '0' para finalizar):");

            if (escolha.equals("0")) {
                break;
            }

            try {
                int indiceItem = Integer.parseInt(escolha) - 1;
                if (indiceItem >= 0 && indiceItem < restaurante.getCardapio().size()) {
                    Item itemSelecionado = restaurante.getCardapio().get(indiceItem);
                    itensSelecionados.add(itemSelecionado);
                    totalPedido += itemSelecionado.getPreco();
                } else {
                    JOptionPane.showMessageDialog(this, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Digite um número válido.");
            }
        }

        exibirPedido(itensSelecionados, totalPedido);
    }

    private void menuPedido(Usuario usuario) {
        Restaurante restauranteSelecionado = escolherRestaurante();
        if (restauranteSelecionado != null) {
            exibirCardapio(restauranteSelecionado);
            realizarPedido(usuario, restauranteSelecionado);
        }
    }

    private Restaurante escolherRestaurante() {
        List<Restaurante> restaurantes = aplicativo.getRestaurantes();

        if (restaurantes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum restaurante cadastrado. Cadastre um restaurante primeiro.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        String[] opcoesRestaurante = new String[restaurantes.size()];
        for (int i = 0; i < restaurantes.size(); i++) {
            opcoesRestaurante[i] = restaurantes.get(i).getNome();
        }

        int escolhaRestaurante = JOptionPane.showOptionDialog(
                this,
                "Escolha um restaurante:",
                "Escolha de Restaurante",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoesRestaurante,
                opcoesRestaurante[0]
        );

        if (escolhaRestaurante >= 0 && escolhaRestaurante < restaurantes.size()) {
            restaurante = restaurantes.get(escolhaRestaurante);
            return restaurante;
        } else {
            return null;
        }
    }

    private void openRestauranteMenu() {
        Restaurante restauranteSelecionado = escolherRestaurante();
        if (restauranteSelecionado != null) {
            String[] options = {"Adicionar Item ao Cardápio", "Remover Item do Cardápio", "Voltar"};

            int choice = JOptionPane.showOptionDialog(this, "Escolha uma opção:", "Menu Restaurante",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    adicionarItemAoCardapio(restauranteSelecionado);
                    break;
                case 1:
                    removerItemDoCardapio(restauranteSelecionado);
                    break;
                // Caso "Voltar" ou fechar a janela
                default:
                    break;
            }
        }
    }

    private void adicionarItemAoCardapio(Restaurante restaurante) {
        String nomeItem = JOptionPane.showInputDialog(this, "Digite o nome do item:");
        String precoItemString = JOptionPane.showInputDialog(this, "Digite o preço do item:");

        try {
            double precoItem = Double.parseDouble(precoItemString);
            Item novoItem = new Item(nomeItem, precoItem);
            restaurante.adicionarItemAoCardapio(novoItem);
            JOptionPane.showMessageDialog(this, "Item adicionado ao cardápio do restaurante: " + restaurante.getNome());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido para o preço.");
        }
    }

    private void removerItemDoCardapio(Restaurante restaurante) {
        String nomeItem = JOptionPane.showInputDialog(this, "Digite o nome do item a ser removido:");

        Item itemRemover = null;
        for (Item item : restaurante.getCardapio()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemRemover = item;
                break;
            }
        }

        if (itemRemover != null) {
            restaurante.removerItemDoCardapio(itemRemover);
            JOptionPane.showMessageDialog(this, "Item removido do cardápio do restaurante: " + restaurante.getNome());
        } else {
            JOptionPane.showMessageDialog(this, "Item não encontrado no cardápio do restaurante: " + restaurante.getNome());
        }
    }

    private void openAdminMenu() {
        String[] options = {"Cadastrar Usuário", "Cadastrar Restaurante", "Voltar"};

        int choice = JOptionPane.showOptionDialog(this, "Escolha uma opção:", "Menu Admin",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                cadastrarNovoUsuario();
                break;
            case 1:
                cadastrarNovoRestaurante();
                break;
            // Caso "Voltar" ou fechar a janela
            default:
                break;
        }
    }

    private void cadastrarNovoUsuario() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do usuário:");
        String endereco = JOptionPane.showInputDialog(this, "Digite o endereço do usuário:");
        String cpf = JOptionPane.showInputDialog(this, "Digite o CPF do usuário:");
        String senha = JOptionPane.showInputDialog(this, "Digite sua Senha");

        Usuario novoUsuario = new Usuario(nome, endereco, cpf, senha);
        aplicativo.cadastrarUsuario(novoUsuario);
        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso: " + nome);
    }

    private void cadastrarNovoRestaurante() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do restaurante:");
        String localizacao = JOptionPane.showInputDialog(this, "Digite a localização do restaurante:");

        Restaurante novoRestaurante = new Restaurante(nome, localizacao);
        aplicativo.cadastrarRestaurante(novoRestaurante);
        JOptionPane.showMessageDialog(this, "Restaurante cadastrado com sucesso: " + nome);
    }

    public static void main(String[] args) {
        List<Usuario> usuariosCadastrados = new ArrayList<>();
        List<Restaurante> restaurantesCadastrados = new ArrayList<>();

        SwingUtilities.invokeLater(() -> {
            Window window = new Window(new Aplicativo(), usuariosCadastrados, restaurantesCadastrados);
            window.setVisible(true);
        });
    }
}

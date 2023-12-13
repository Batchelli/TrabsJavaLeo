// Pedido.java
import java.util.List;

public class Pedido {
    private Restaurante restaurante;
    private Usuario usuario;
    private List<Item> itens;
    private double total;

    // Construtor
    public Pedido(Restaurante restaurante, Usuario usuario, List<Item> itens, double total) {
        this.restaurante = restaurante;
        this.usuario = usuario;
        this.itens = itens;
        this.total = total;
    }

    // Comportamentos
    public void fazerPedido() {
        System.out.println("Pedido feito por " + usuario.getNome() +
                " no restaurante " + restaurante.getNome());
    }

    public void imprimirPedidoNoConsole() {
        System.out.println("Detalhes do Pedido:");
        System.out.println("Restaurante: " + restaurante.getNome());
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Itens do Pedido:");
        for (Item item : itens) {
            System.out.println(item.getNome() + " - R$" + item.getPreco());
        }
        System.out.println("Total do Pedido: R$" + total);
    }
}

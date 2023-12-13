// Aplicativo.java
import java.util.ArrayList;
import java.util.List;

public class Aplicativo {
    private List<Restaurante> restaurantes;
    private List<Usuario> usuarios;
    private List<Pedido> pedidos;

    // Construtor
    public Aplicativo() {
        this.restaurantes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public Usuario buscarUsuarioPorCPF(String cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    // Comportamentos
    public void cadastrarRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarPedido(Pedido pedido) {
        pedidos.add(pedido);
        pedido.fazerPedido();
    }


}

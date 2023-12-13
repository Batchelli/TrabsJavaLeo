// Restaurante.java
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private String localizacao;
    private List<Item> cardapio;

    // Construtor
    public Restaurante(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.cardapio = new ArrayList<>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    // Comportamentos
    public void imprimirCardapio() {
        System.out.println("Cardápio do Restaurante: " + nome);
        for (Item item : cardapio) {
            System.out.println(item.getNome() + " - R$" + item.getPreco());
        }
    }

    public void adicionarItemAoCardapio(Item item) {
        cardapio.add(item);
    }

    public void removerItemDoCardapio(Item item) {
        cardapio.remove(item);
    }

    public List<Item> getCardapio() {
        return cardapio;
    }

}

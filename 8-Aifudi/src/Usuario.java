// Usuario.java
public class Usuario {
    private String nome;
    private String endereco;
    private String cpf;
    private String senha;

    // Construtor
    public Usuario(String nome, String endereco, String cpf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {return cpf;}

    public  String getSenha() {return senha;}
}

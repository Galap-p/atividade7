package poo;

public class Produto{
    private String id;
    private String nome;
    private double preco;
    private int estoque;
    private String descricao;

    void ExibirDetalhes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em Estoque: " + this.estoque);

    }

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
    public Produto(String nome, double preco, int estoque, String id, String descricao){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.id = id;
        this.descricao = descricao;
    }

    public String getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public double getPreco(){
        return this.preco;
    }
    public int getEstoque(){
        return this.estoque;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarEstoque(int quantidade){
        if(quantidade>0){
            this.estoque = this.estoque + quantidade;
        }
    }
}
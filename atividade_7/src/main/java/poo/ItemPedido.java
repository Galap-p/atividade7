package poo;

public class ItemPedido {
    private Produto item;
    private int quantidade;
    private double precoUnitario;

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getItem() {
        return item;
    }

    public void setItem(Produto item) {
        this.item = item;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemPedido(Produto produto, int quantidade){
        this.item = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();

    }

    public double getSubtotal(){
        return precoUnitario * quantidade;
    }

}
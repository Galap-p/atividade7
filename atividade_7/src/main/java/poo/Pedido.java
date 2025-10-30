package poo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Pedido{
    private List<ItemPedido> itens = new ArrayList<>();
    private LocalDate data;
    private Cliente cliente;
    private IPagamento metodoPagamento;
    private StatusPedido status = StatusPedido.PENDENTE;
    private double desconto = 0;


    public Pedido(LocalDate data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
    }
    public Pedido(LocalDate data){
        this.data = data;
    }
    public void aplicarDesconto(double desconto){
        this.desconto = desconto;
    }

    public double calcularTotal(){
        double total = 0;
        int i;
        for(i=0;i<itens.size();i++){
            if(itens.get(i) != null)
                total += itens.get(i).getSubtotal();
        }
        total -= this.desconto;
        return total;
    }
    public void adicionarItem(Produto produto, int quantidade){
        for(int i = 0; i<itens.size();i++){
            if(itens.get(i).getItem() == produto) {
                itens.get(i).setQuantidade(itens.get(i).getQuantidade() + quantidade);
                return;
            }
        }
        
        this.itens.add(new ItemPedido(produto, quantidade));
        return;
    }

    public void removerItem(ItemPedido removItem){
        this.itens.remove(removItem);
    }
    
    public boolean confirmarPedido() {
    	if(this.status != StatusPedido.PENDENTE) {
    		this.status = StatusPedido.CANCELADO;
    		return false;
    	}
    	if(this.metodoPagamento == null)
    		return false;
    	else {
    		if(metodoPagamento.processarPagamento(this.calcularTotal())) {
    			this.status = StatusPedido.PROCESSANDO;
    			return true;
    		}
    	
    	}
    	return false;
    }
    public ItemPedido getItem(int numList){
        return this.itens.get(numList);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDate getData(){
        return this.data;
    }
    public void setData(LocalDate data){
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
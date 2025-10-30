package poo;

import java.time.LocalDate;

public class PagamentoBoleto implements IPagamento{

    private String codigoBarras;
    private StatusPagamento status;
    private double valor;
    private LocalDate dataVencimento;

    @Override
    public boolean processarPagamento(double valor) {
        this.status = StatusPagamento.APROVADO;
    	return true;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public StatusPagamento getStatus(){
        return this.status;
    }
}
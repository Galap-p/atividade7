package poo;

import java.time.LocalDate;

public class PagamentoCartaoCredito implements IPagamento{

    private String numeroCartao;
    private String nomeTitular;
    private LocalDate dataValidade;
    private StatusPagamento status;

    @Override
    public boolean processarPagamento(double valor) {
        if(valor<5000.0){
            this.status = StatusPagamento.APROVADO;
            return true;
        }
        else{
            this.status = StatusPagamento.RECUSADO;
            return false;
        }
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public StatusPagamento getStatus() {
        return this.status;
    }
}
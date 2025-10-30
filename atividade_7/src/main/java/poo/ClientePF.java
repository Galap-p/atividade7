package poo;

import java.time.LocalDate;

public class ClientePF extends Cliente {
    private String cpf;
    private LocalDate dataDeNascimento;

    public ClientePF(String nome, String email, String cpf){
        super(nome, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void MostraCliente(){
        System.out.printf("Nome: %s\nEmail: %s\nCPF: %s\n", this.nome, this.email, this.cpf);
    }

    @Override
    public String getIdentificadorUnico() {
        return this.cpf;
    }
}
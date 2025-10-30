package poo;

abstract class Cliente {
    protected String nome;
    protected String email;
    protected String id;
    protected String telefone;


    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getId(){return this.id;}
    public abstract String getIdentificadorUnico();
    public String getTelefone(){
        return this.telefone;
    }

}   
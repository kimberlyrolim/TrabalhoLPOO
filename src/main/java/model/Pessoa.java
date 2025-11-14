package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private String telefone;
    
    private String email;
    private String endereco;
    private int codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String exibirDados(){
        // Define o mesmo formatador usado para a criação da string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String aux = "Pessoa cadastrada: \n";
        aux += "Nome: " + nome+ "\n";
        aux += "CPF: " + CPF + "\n";
        aux += "Telefone: "+telefone+"\n";
        aux += "Data Nascimento: "+dataNascimento.format(formatter)+"\n";
    
        return aux;
    }
            
}

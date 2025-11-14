package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "vendedores")
public class Vendedor extends Pessoa implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "vend_id")
    private int id;
    
    @Column(name = "vend_salario", columnDefinition = "numeric(12,2)")
    private double salario;
    
    public Vendedor(){
        vendas = new ArrayList<>();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

   
    public String exibirDados(){
        String aux = super.exibirDados()+"\n";
        aux += "Salário" + salario + "\n";

        return aux;
    }
     
    // 1 vendedor -> várias vendas
    @OneToMany(mappedBy = "vendedor")
    private List<Venda> vendas;
    
    public List<Venda> getVendas() { return vendas; }
    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }

}

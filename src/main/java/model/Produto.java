package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "prod_id")
    private int id;
   
    @Column(name = "prod_nome")
    private String prodNome;
    
    @Column(name = "prod_tipo")
    private String prodTipo;
    
    @Column(name = "prod_valor")
    private double prodValor;
    
    @Column(name = "prod_disponivel")
    private Boolean prodDisponivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public String getProdTipo() {
        return prodTipo;
    }

    public void setProdTipo(String prodTipo) {
        this.prodTipo = prodTipo;
    }

    public double getProdValor() {
        return prodValor;
    }

    public void setProdValor(double prodValor) {
        this.prodValor = prodValor;
    }
  
 
    public Produto(){
        prodDisponivel = true;
        vendas = new ArrayList<>();
    }
    
    public String exibirDados(){
        String aux = "Produto cadastrado:\n";
        
        aux += "Id: "+id+"\n";
        aux += "Produto: "+prodNome+"\n";
        aux += "Tipo: "+prodTipo+"\n";
        aux += "Valor: R$"+prodValor+"\n";
        aux += prodDisponivel ? "[DISPONÍVEL]" : "[NÃO DISPONÍVEL]";

        return aux;
    }
    
    @OneToMany(mappedBy = "produto")//um produto várias vendas
    private List<Venda> vendas;
    
    public List<Venda> getVendas() { return vendas; }
    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }

    public Boolean getDisponivel() {
        return prodDisponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.prodDisponivel = disponivel;
    }

    


    
}

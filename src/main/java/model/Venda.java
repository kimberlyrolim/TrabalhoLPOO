package model;

import model.dao.Util;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "venda_id")
    private int id;
    
    @Column(name = "venda_data_hora", nullable = false)
    private LocalDateTime dataVenda;
    
    @Column(name = "venda_valor", columnDefinition = "numeric(12,2)")
    private double valorVenda;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "venda_forma_contrato")
    private FormaContrato formaContrato;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "venda_forma_pgto")
    private FormaPgto formaPgto;
    
    @ManyToOne
    @JoinColumn(name = "venda_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "venda_vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "venda_produto")
    private Produto produto;
    
    

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public FormaContrato getFormaContrato() {
        return formaContrato;
    }

    public void setFormaContrato(FormaContrato formaContrato) {
        this.formaContrato = formaContrato;
    }

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return Util.formatarDataHora(dataVenda);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String exibirDados() {
        
        String aux = "Dados da Venda:\n";
        aux += "Data|Hora:"+Util.formatarDataHora(dataVenda)+"\n";
        aux += "Produto"+getProduto().getProdNome()+"\n";
        aux += "Cliente: "+getCliente().getNome()+"\n";
        aux += "Vendedor: "+getVendedor().getNome()+"\n";
        aux += "Forma de Contrato: "+formaContrato+"\n";
        aux += "Forma de Pagamento: "+formaPgto+"\n";
          return aux;
    }
    
    
}

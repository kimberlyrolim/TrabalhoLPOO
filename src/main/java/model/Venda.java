package model;

import model.dao.Util;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "venda_id")
    private int id;

    @Column(name = "venda_data_hora", nullable = false)
    private LocalDate dataVenda;

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

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemVenda> itensVenda = new java.util.ArrayList<>();

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
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

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void adicionarItem(ItemVenda item) {
        // Garante que a lista está inicializada antes de adicionar
        if (this.itensVenda == null) {
            this.itensVenda = new java.util.ArrayList<>();
        }
        this.itensVenda.add(item);
        // Configura a relação bidirecional (ItemVenda aponta de volta para esta Venda)
        item.setVenda(this);
    }

    public void atualizarValorTotal() {
        double total = 0.0;
        // Percorre todos os itens da lista
        for (ItemVenda item : getItensVenda()) {
            // Usa o método calcularSubTotal() da classe ItemVenda
            total += item.calcularSubTotal();
        }
        // Define o valor total da venda
        this.valorVenda = total;
    }

    @Override
    public String toString() {
        return Util.formatarData(dataVenda);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String exibirDados() {

        String aux = "Dados da Venda:\n";
        aux += "Data:" + Util.formatarData(dataVenda) + "\n";
        //aux += "Produto"+getProduto().getProdNome()+"\n";
        aux += "\nProdutos Vendidos:\n";
        for (ItemVenda item : getItensVenda()) {
            aux += " - " + item.getProduto().getProdNome()
                    + " (Qtde: " + item.getQuantidade()
                    + " | Subtotal: " + item.calcularSubTotal() + ")\n";
        }
        aux += "Cliente: " + getCliente().getNome() + "\n";
        aux += "Vendedor: " + getVendedor().getNome() + "\n";
        aux += "Forma de Contrato: " + formaContrato + "\n";
        aux += "Forma de Pagamento: " + formaPgto + "\n";
        return aux;
    }

}

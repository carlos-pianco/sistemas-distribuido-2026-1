package br.ufc.loja.model;

public class Pedido {

    private int id;
    private Cliente cliente;
    private ItemVenda item;
    private int quantidade;
    private double total;

    public Pedido() {
    }

    public Pedido(int id, Cliente cliente, ItemVenda item, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.item = item;
        this.quantidade = quantidade;
        this.total = item.getPreco() * quantidade;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ItemVenda getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return total;
    }
}
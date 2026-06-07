package br.ufc.loja.service;

import br.ufc.loja.dto.CompraResponse;
import br.ufc.loja.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LojaService {

    private final List<ItemVenda> itens = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Pedido> pedidos = new ArrayList<>();

    private int proximoPedidoId = 1;

    public LojaService() {

        itens.add(new ProdutoFisico(
                1,
                "Hello Hello Ciclo Body Splash 200ml",
                45.00,
                0.20,
                "hello-hello-ciclo.png"
        ));

        itens.add(new ProdutoFisico(
                2,
                "Natura Tododia Ameixa e Flor de Baunilha 400ml",
                49.99,
                0.40,
                "tododia-ameixa-baunilha.png"
        ));

        itens.add(new ProdutoFisico(
                3,
                "Ciclo Kiss Me More Hidratante Corporal 240ml",
                40.00,
                0.24,
                "kiss-me-more.png"
        ));

        itens.add(new ProdutoFisico(
                4,
                "Ciclo Kiss You More Body Splash 200ml",
                50.00,
                0.20,
                "kiss-you-more.png"
        ));

        itens.add(new ProdutoFisico(
                5,
                "Natura Luna Radiante 75ml",
                125.00,
                0.30,
                "luna-radiante.png"
        ));

        clientes.add(new Cliente(1, "Maria", "maria@email.com"));
        clientes.add(new Cliente(2, "João", "joao@email.com"));
    }

    public List<ItemVenda> listarItens() {
        return itens;
    }

    public ItemVenda buscarItem(int id) {
        for (ItemVenda item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public double calcularTotal(int id, int quantidade) {
        ItemVenda item = buscarItem(id);

        if (item == null || quantidade <= 0) {
            return 0;
        }

        return item.getPreco() * quantidade;
    }

    public CompraResponse comprarItem(int clienteId, int itemId, int quantidade) {
        Cliente cliente = buscarCliente(clienteId);
        ItemVenda item = buscarItem(itemId);

        if (cliente == null) {
            return new CompraResponse("Cliente não encontrado.", 0);
        }

        if (item == null) {
            return new CompraResponse("Item não encontrado.", 0);
        }

        if (quantidade <= 0) {
            return new CompraResponse("Quantidade inválida.", 0);
        }

        Pedido pedido = new Pedido(proximoPedidoId++, cliente, item, quantidade);
        pedidos.add(pedido);

        return new CompraResponse(
                "Compra realizada: " + quantidade + "x " + item.getNome(),
                pedido.getTotal()
        );
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public List<ProdutoFisico> listarProdutosFisicos() {
        List<ProdutoFisico> resultado = new ArrayList<>();

        for (ItemVenda item : itens) {
            if (item instanceof ProdutoFisico) {
                resultado.add((ProdutoFisico) item);
            }
        }

        return resultado;
    }

    public List<ProdutoDigital> listarProdutosDigitais() {
        List<ProdutoDigital> resultado = new ArrayList<>();

        for (ItemVenda item : itens) {
            if (item instanceof ProdutoDigital) {
                resultado.add((ProdutoDigital) item);
            }
        }

        return resultado;
    }

    public List<br.ufc.loja.model.Servico> listarServicos() {
        List<br.ufc.loja.model.Servico> resultado = new ArrayList<>();

        for (ItemVenda item : itens) {
            if (item instanceof br.ufc.loja.model.Servico) {
                resultado.add((br.ufc.loja.model.Servico) item);
            }
        }

        return resultado;
    }
}
package br.ufc.loja.controller;

import br.ufc.loja.dto.CompraRequest;
import br.ufc.loja.dto.CompraResponse;
import br.ufc.loja.model.Cliente;
import br.ufc.loja.model.ItemVenda;
import br.ufc.loja.model.Pedido;
import br.ufc.loja.model.ProdutoDigital;
import br.ufc.loja.model.ProdutoFisico;
import br.ufc.loja.service.LojaService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @GetMapping("/itens")
    public List<ItemVenda> listarItens() {
        return lojaService.listarItens();
    }

    @GetMapping("/itens/{id}")
    public ItemVenda buscarItem(@PathVariable int id) {
        return lojaService.buscarItem(id);
    }

    @GetMapping("/produtos/fisicos")
    public List<ProdutoFisico> listarProdutosFisicos() {
        return lojaService.listarProdutosFisicos();
    }

    @GetMapping("/produtos/digitais")
    public List<ProdutoDigital> listarProdutosDigitais() {
        return lojaService.listarProdutosDigitais();
    }

    @GetMapping("/servicos")
    public List<br.ufc.loja.model.Servico> listarServicos() {
        return lojaService.listarServicos();
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return lojaService.listarClientes();
    }

    @GetMapping("/clientes/{id}")
    public Cliente buscarCliente(@PathVariable int id) {
        return lojaService.buscarCliente(id);
    }

    @GetMapping("/pedidos")
    public List<Pedido> listarPedidos() {
        return lojaService.listarPedidos();
    }

    @GetMapping("/total")
    public double calcularTotal(
            @RequestParam int id,
            @RequestParam int quantidade) {

        return lojaService.calcularTotal(id, quantidade);
    }

    @PostMapping("/comprar")
    public CompraResponse comprarItem(
            @RequestBody CompraRequest request) {

        return lojaService.comprarItem(
                request.getClienteId(),
                request.getItemId(),
                request.getQuantidade()
        );
    }
}
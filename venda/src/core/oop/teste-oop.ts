import { ProdutoFisico } from "./produto-fisico.js";
import { ProdutoDigital } from "./produto-digital.js";
import { Servico } from "./servico.js";
import { Carrinho } from "./carrinho-classe.js";
import { Loja } from "./loja.js";

const loja = new Loja();

const produtoFisico = new ProdutoFisico("1", "Camisa", 59.9, 0.3);
const produtoDigital = new ProdutoDigital("2", "E-book", 29.9, 15);
const servico = new Servico("3", "Entrega local", 10, 1);

loja.adicionarItem(produtoFisico);
loja.adicionarItem(produtoDigital);
loja.adicionarItem(servico);

console.log("Catálogo da loja:");
console.log(loja.listarItens());

const carrinho = new Carrinho();

carrinho.adicionarItem(produtoFisico);
carrinho.adicionarItem(produtoDigital);
carrinho.adicionarItem(servico);

console.log("Total do carrinho:");
console.log(carrinho.calcularTotal());

carrinho.removerItem("2");

console.log("Total após remover o e-book:");
console.log(carrinho.calcularTotal());

carrinho.finalizarCompra();
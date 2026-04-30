import { CarrinhoDeCompras } from "./carrinho-de-compras.js";
import { ItemVenda } from "./item-venda.js";

export class Carrinho implements CarrinhoDeCompras {
  private itens: ItemVenda[] = [];

  adicionarItem(item: ItemVenda): void {
    this.itens.push(item);
  }

  removerItem(id: string): void {
    this.itens = this.itens.filter(item => item.id !== id);
  }

  calcularTotal(): number {
    return this.itens.reduce((total, item) => total + item.preco, 0);
  }

  finalizarCompra(): void {
    console.log("Compra finalizada! Total:", this.calcularTotal());
    this.itens = [];
  }
}
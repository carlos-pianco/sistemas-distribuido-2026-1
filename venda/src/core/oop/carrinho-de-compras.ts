import { ItemVenda } from "./item-venda.js";

export interface CarrinhoDeCompras {
  adicionarItem(item: ItemVenda): void;
  removerItem(id: string): void;
  calcularTotal(): number;
  finalizarCompra(): void;
}
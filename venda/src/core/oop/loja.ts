import { ItemVenda } from "./item-venda.js";

export class Loja {
  private catalogo: ItemVenda[] = [];

  adicionarItem(item: ItemVenda): void {
    this.catalogo.push(item);
  }

  listarItens(): ItemVenda[] {
    return this.catalogo;
  }
}
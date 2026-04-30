import { ItemVenda } from "./item-venda.js";

export class ProdutoDigital extends ItemVenda {
  constructor(
    id: string,
    nome: string,
    preco: number,
    public tamanhoMB: number
  ) {
    super(id, nome, preco);
  }

  getTipo(): string {
    return "Produto Digital";
  }
}
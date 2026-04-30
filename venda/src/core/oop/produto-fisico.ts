import { ItemVenda } from "./item-venda.js";

export class ProdutoFisico extends ItemVenda {
  constructor(
    id: string,
    nome: string,
    preco: number,
    public peso: number
  ) {
    super(id, nome, preco);
  }

  getTipo(): string {
    return "Produto Físico";
  }
}
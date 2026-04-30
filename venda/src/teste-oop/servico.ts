import { ItemVenda } from "./item-venda.js";

export class Servico extends ItemVenda {
  constructor(
    id: string,
    nome: string,
    preco: number,
    public duracao: number
  ) {
    super(id, nome, preco);
  }

  getTipo(): string {
    return "Serviço";
  }
}
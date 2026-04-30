export abstract class ItemVenda {
  constructor(
    public id: string,
    public nome: string,
    public preco: number
  ) {}

  abstract getTipo(): string;
}
abstract class ItemVenda {
  constructor(
    public id: string,
    public nome: string,
    public preco: number
  ) {}

  abstract getTipo(): string;
}

class ProdutoFisico extends ItemVenda {
  constructor(id: string, nome: string, preco: number, public peso: number) {
    super(id, nome, preco);
  }

  getTipo(): string {
    return "Produto Físico";
  }
}

class ProdutoDigital extends ItemVenda {
  constructor(id: string, nome: string, preco: number, public tamanhoMB: number) {
    super(id, nome, preco);
  }

  getTipo(): string {
    return "Produto Digital";
  }
}

class Servico extends ItemVenda {
  constructor(id: string, nome: string, preco: number, public duracao: number) {
    super(id, nome, preco);
  }

  getTipo(): string {
    return "Serviço";
  }
}

interface CarrinhoDeCompras {
  adicionarItem(item: ItemVenda): void;
  removerItem(id: string): void;
  calcularTotal(): number;
  finalizarCompra(): void;
}

class Carrinho implements CarrinhoDeCompras {
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

class Loja {
  private catalogo: ItemVenda[] = [];

  adicionarItem(item: ItemVenda): void {
    this.catalogo.push(item);
  }

  listarItens(): ItemVenda[] {
    return this.catalogo;
  }
}

console.log("=== TESTE OOP ===");

const loja = new Loja();

const produtoFisico = new ProdutoFisico("1", "Camisa", 59.9, 0.3);
const produtoDigital = new ProdutoDigital("2", "E-book", 29.9, 15);
const servico = new Servico("3", "Entrega local", 10, 1);

loja.adicionarItem(produtoFisico);
loja.adicionarItem(produtoDigital);
loja.adicionarItem(servico);

console.log("Catálogo:");
console.log(loja.listarItens());

const carrinho = new Carrinho();

carrinho.adicionarItem(produtoFisico);
carrinho.adicionarItem(produtoDigital);
carrinho.adicionarItem(servico);

console.log("Total:");
console.log(carrinho.calcularTotal());

carrinho.removerItem("2");

console.log("Total após remover o E-book:");
console.log(carrinho.calcularTotal());

carrinho.finalizarCompra();
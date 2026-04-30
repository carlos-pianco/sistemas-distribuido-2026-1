import { FastifyInstance } from "fastify";

import { ProdutoFisico } from "../../../core/oop/produto-fisico.js";
import { ProdutoDigital } from "../../../core/oop/produto-digital.js";
import { Servico } from "../../../core/oop/servico.js";
import { Carrinho } from "../../../core/oop/carrinho-classe.js";
import { Loja } from "../../../core/oop/loja.js";

const loja = new Loja();
const carrinho = new Carrinho();

export async function oopRoutes(app: FastifyInstance) {
  app.get("/oop/teste", async () => {
    return { message: "OOP funcionando 🚀" };
  });

  app.post("/oop/carrinho/adicionar", async (request, reply) => {
    const { id, nome, preco, tipo } = request.body as any;

    let item;

    if (tipo === "fisico") {
      item = new ProdutoFisico(id, nome, preco, 0.5);
    } else if (tipo === "digital") {
      item = new ProdutoDigital(id, nome, preco, 10);
    } else {
      item = new Servico(id, nome, preco, 1);
    }

    carrinho.adicionarItem(item);

    return {
      total: carrinho.calcularTotal(),
    };
  });

  app.get("/oop/carrinho", async () => {
    return {
      total: carrinho.calcularTotal(),
    };
  });
}
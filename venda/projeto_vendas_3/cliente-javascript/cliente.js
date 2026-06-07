const axios = require("axios");
const prompt = require("prompt-sync")();

const BASE_URL = "http://localhost:8080/api";

async function listarItens() {
    const resposta = await axios.get(`${BASE_URL}/itens`);
    console.log(resposta.data);
}

async function buscarItem() {
    const id = prompt("ID do item: ");

    const resposta = await axios.get(
        `${BASE_URL}/itens/${id}`
    );

    console.log(resposta.data);
}

async function calcularTotal() {
    const id = prompt("ID do item: ");
    const quantidade = prompt("Quantidade: ");

    const resposta = await axios.get(
        `${BASE_URL}/total`,
        {
            params: {
                id: id,
                quantidade: quantidade
            }
        }
    );

    console.log("Total:", resposta.data);
}

async function listarClientes() {
    const resposta = await axios.get(
        `${BASE_URL}/clientes`
    );

    console.log(resposta.data);
}

async function listarPedidos() {
    const resposta = await axios.get(
        `${BASE_URL}/pedidos`
    );

    console.log(resposta.data);
}

async function comprarItem() {

    const clienteId = Number(prompt("ID do cliente: "));
    const itemId = Number(prompt("ID do item: "));
    const quantidade = Number(prompt("Quantidade: "));

    const resposta = await axios.post(
        `${BASE_URL}/comprar`,
        {
            clienteId,
            itemId,
            quantidade
        }
    );

    console.log(resposta.data);
}

async function menu() {

    while (true) {

        console.log("\n===== CLIENTE JAVASCRIPT =====");
        console.log("1 - Listar itens");
        console.log("2 - Buscar item");
        console.log("3 - Calcular total");
        console.log("4 - Listar clientes");
        console.log("5 - Listar pedidos");
        console.log("6 - Comprar item");
        console.log("0 - Sair");

        const opcao = prompt("Escolha: ");

        try {

            if (opcao === "1")
                await listarItens();

            else if (opcao === "2")
                await buscarItem();

            else if (opcao === "3")
                await calcularTotal();

            else if (opcao === "4")
                await listarClientes();

            else if (opcao === "5")
                await listarPedidos();

            else if (opcao === "6")
                await comprarItem();

            else if (opcao === "0")
                break;

            else
                console.log("Opção inválida.");

        } catch (erro) {
            console.log("Erro:", erro.message);
        }
    }
}

menu();
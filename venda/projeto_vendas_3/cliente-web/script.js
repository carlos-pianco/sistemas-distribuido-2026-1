function abrirLoginAdm() {
    document.getElementById("modal-login").style.display = "flex";
}

function fecharLoginAdm() {
    document.getElementById("modal-login").style.display = "none";
    document.getElementById("erroLogin").innerText = "";
}

function loginAdm() {
    const usuario = document.getElementById("usuarioAdm").value;
    const senha = document.getElementById("senhaAdm").value;

    if (usuario === "admin" && senha === "123456") {
        window.location.href = "adm.html";
    } else {
        document.getElementById("erroLogin").innerText =
            "Usuário ou senha inválidos.";
    }
}

const API = "http://localhost:8080/api";

function mostrarResultado(dados) {

    const saida = document.getElementById("saida");

    if (!Array.isArray(dados)) {
        saida.innerHTML =
            `<pre>${JSON.stringify(dados, null, 2)}</pre>`;
        return;
    }

    if (dados.length === 0) {
        saida.innerHTML = "<p>Nenhum registro encontrado.</p>";
        return;
    }

    let html = "<table>";

    html += "<thead><tr>";

    Object.keys(dados[0]).forEach(chave => {
        html += `<th>${chave}</th>`;
    });

    html += "</tr></thead>";

    html += "<tbody>";

    dados.forEach(item => {

        html += "<tr>";

        Object.values(item).forEach(valor => {

            if (typeof valor === "object" && valor !== null) {
                html += `<td>${JSON.stringify(valor)}</td>`;
            } else {
                html += `<td>${valor}</td>`;
            }

        });

        html += "</tr>";

    });

    html += "</tbody></table>";

    saida.innerHTML = html;
}

async function listarClientes() {

    const resposta =
        await fetch(`${API}/clientes`);

    const dados =
        await resposta.json();

    mostrarResultado(dados);
}

async function listarPedidos() {

    const resposta =
        await fetch(`${API}/pedidos`);

    const dados =
        await resposta.json();

    mostrarResultado(dados);
}

async function listarProdutosFisicos() {

    const resposta =
        await fetch(`${API}/produtos/fisicos`);

    const dados =
        await resposta.json();

    mostrarResultado(dados);
}

async function listarProdutosDigitais() {

    const resposta =
        await fetch(`${API}/produtos/digitais`);

    const dados =
        await resposta.json();

    mostrarResultado(dados);
}

async function listarServicos() {

    const resposta =
        await fetch(`${API}/servicos`);

    const dados =
        await resposta.json();

    mostrarResultado(dados);
}

async function carregarProdutos() {

    const resposta =
        await fetch("http://localhost:8080/api/itens");

    const produtos =
        await resposta.json();

    const container =
        document.getElementById("produtos");

    container.innerHTML = "";

    produtos.forEach(produto => {

        const card = document.createElement("div");

        card.className = "card-produto";

        card.innerHTML = `
            <img
                src="imagens/${produto.imagem}"
                alt="${produto.nome}"
                class="foto-produto">

            <h3>${produto.nome}</h3>

            <p>
                <strong>Preço:</strong>
                R$ ${produto.preco.toFixed(2)}
            </p>

            <button onclick="comprarRapido(${produto.id})">
                Comprar
            </button>
        `;

        container.appendChild(card);

    });

}

function comprarRapido(idProduto) {

    document.getElementById("idProduto").value =
        idProduto;

    document
        .getElementById("quantidadeProduto")
        .focus();

}

async function calcularTotalCliente() {

    const id =
        document.getElementById("idProduto").value;

    const quantidade =
        document.getElementById("quantidadeProduto").value;

    const resposta =
        await fetch(
            `http://localhost:8080/api/total?id=${id}&quantidade=${quantidade}`
        );

    const total =
        await resposta.json();

    document.getElementById("resultadoTotal")
        .innerText =
        `Total: R$ ${total}`;
}

async function finalizarCompra() {

    const clienteId =
        Number(document.getElementById("clienteId").value);

    const itemId =
        Number(document.getElementById("idProduto").value);

    const quantidade =
        Number(document.getElementById("quantidadeProduto").value);

    if (!clienteId || !itemId || !quantidade) {

        alert("Preencha todos os campos.");

        return;
    }

    const resposta = await fetch(
        "http://localhost:8080/api/comprar",
        {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                clienteId,
                itemId,
                quantidade
            })
        }
    );

    const dados =
        await resposta.json();

    alert(
        `${dados.mensagem}\n\nTotal: R$ ${dados.total}`
    );
}
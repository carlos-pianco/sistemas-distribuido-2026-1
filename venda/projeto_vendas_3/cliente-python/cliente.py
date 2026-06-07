import requests

BASE_URL = "http://localhost:8080/api"


def listar_itens():
    resposta = requests.get(f"{BASE_URL}/itens")
    print("\nItens disponíveis:")
    print(resposta.json())


def buscar_item():
    item_id = int(input("Digite o ID do item: "))

    resposta = requests.get(
        f"{BASE_URL}/itens/{item_id}"
    )

    print(resposta.json())


def calcular_total():
    item_id = int(input("Digite o ID do item: "))
    quantidade = int(input("Digite a quantidade: "))

    resposta = requests.get(
        f"{BASE_URL}/total",
        params={
            "id": item_id,
            "quantidade": quantidade
        }
    )

    print("\nTotal: R$", resposta.json())


def listar_clientes():
    resposta = requests.get(
        f"{BASE_URL}/clientes"
    )

    print(resposta.json())


def listar_pedidos():
    resposta = requests.get(
        f"{BASE_URL}/pedidos"
    )

    print(resposta.json())


def comprar_item():
    cliente_id = int(input("ID do cliente: "))
    item_id = int(input("ID do item: "))
    quantidade = int(input("Quantidade: "))

    dados = {
        "clienteId": cliente_id,
        "itemId": item_id,
        "quantidade": quantidade
    }

    resposta = requests.post(
        f"{BASE_URL}/comprar",
        json=dados
    )

    print("\nResultado da compra:")
    print(resposta.json())


while True:

    print("\n===== CLIENTE PYTHON =====")
    print("1 - Listar itens")
    print("2 - Buscar item")
    print("3 - Calcular total")
    print("4 - Listar clientes")
    print("5 - Listar pedidos")
    print("6 - Comprar item")
    print("0 - Sair")

    opcao = input("\nEscolha: ")

    if opcao == "1":
        listar_itens()

    elif opcao == "2":
        buscar_item()

    elif opcao == "3":
        calcular_total()

    elif opcao == "4":
        listar_clientes()

    elif opcao == "5":
        listar_pedidos()

    elif opcao == "6":
        comprar_item()

    elif opcao == "0":
        print("Encerrando...")
        break

    else:
        print("Opção inválida!")
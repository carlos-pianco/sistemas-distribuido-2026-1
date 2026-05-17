import socket
import json

HOST = "localhost"
PORTA = 5001


def enviar_mensagem(mensagem):
    cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    cliente.connect((HOST, PORTA))

    cliente.sendall((json.dumps(mensagem) + "\n").encode("utf-8"))

    resposta = cliente.recv(4096).decode("utf-8")
    cliente.close()

    return json.loads(resposta)


def listar_produtos():
    resposta = enviar_mensagem({
        "acao": "listar"
    })

    print("\nResposta recebida do servidor:")
    print(resposta)

    if "produtos" not in resposta:
        print("Erro: servidor não retornou a lista de produtos.")
        return

    print("\nProdutos disponíveis:")

    for produto in resposta["produtos"]:
        print(f'{produto["id"]} - {produto["nome"]} - R$ {produto["preco"]:.2f}')


def comprar_produto():
    id_produto = int(input("Digite o ID do produto: "))
    quantidade = int(input("Digite a quantidade: "))

    resposta = enviar_mensagem({
        "acao": "comprar",
        "id": id_produto,
        "quantidade": quantidade
    })

    print("\nResposta do servidor:")
    print(resposta)


while True:
    print("\n=== Cliente Python - Loja Online ===")
    print("1 - Listar produtos")
    print("2 - Comprar produto")
    print("0 - Sair")

    opcao = input("Escolha: ")

    if opcao == "1":
        listar_produtos()
    elif opcao == "2":
        comprar_produto()
    elif opcao == "0":
        break
    else:
        print("Opção inválida.")
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            LojaService loja = (LojaService) registry.lookup("LojaService");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== Cliente RMI - Loja Online ===");
                System.out.println("1 - Listar itens");
                System.out.println("2 - Buscar item");
                System.out.println("3 - Comprar item");
                System.out.println("4 - Calcular total");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    List<ItemVenda> itens = loja.listarItens();

                    System.out.println("\nItens disponíveis:");
                    for (ItemVenda item : itens) {
                        System.out.println(item);
                    }

                } else if (opcao == 2) {
                    System.out.print("Digite o ID do item: ");
                    int id = scanner.nextInt();

                    ItemVenda item = loja.buscarItem(id);

                    if (item == null) {
                        System.out.println("Item não encontrado.");
                    } else {
                        System.out.println("Item encontrado: " + item);
                    }

                } else if (opcao == 3) {
                    System.out.print("Digite o ID do item: ");
                    int id = scanner.nextInt();

                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();

                    String resposta = loja.comprarItem(id, quantidade);

                    System.out.println(resposta);

                } else if (opcao == 4) {
                    System.out.print("Digite o ID do item: ");
                    int id = scanner.nextInt();

                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();

                    double total = loja.calcularTotal(id, quantidade);

                    System.out.println("Total: R$ " + total);

                } else if (opcao == 0) {
                    System.out.println("Encerrando cliente...");
                    break;

                } else {
                    System.out.println("Opção inválida.");
                }
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorVendas {
    private static Loja loja = new Loja();

    public static void main(String[] args) {
        int porta = 5001;;

        try (ServerSocket servidor = new ServerSocket(porta)) {
            System.out.println("Servidor Java rodando na porta " + porta);

            while (true) {
                Socket cliente = servidor.accept();
                new Thread(new ClienteHandler(cliente)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClienteHandler implements Runnable {
        private Socket socket;

        public ClienteHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter saida = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String mensagem = entrada.readLine();
                System.out.println("Recebido: " + mensagem);

                String resposta = processarMensagem(mensagem);
                saida.println(resposta);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processarMensagem(String mensagem) {
            if (mensagem.contains("\"acao\": \"listar\"") || mensagem.contains("\"acao\":\"listar\"")) {
                return listarProdutosJson();
            }

            if (mensagem.contains("\"acao\": \"comprar\"") || mensagem.contains("\"acao\":\"comprar\"")) {
                int id = extrairNumero(mensagem, "id");
                int quantidade = extrairNumero(mensagem, "quantidade");

                ItemVenda item = loja.buscarPorId(id);

                if (item == null) {
                    return "{\"status\":\"erro\",\"mensagem\":\"Produto não encontrado\"}";
                }

                double total = item.getPreco() * quantidade;

                return "{"
                        + "\"status\":\"ok\","
                        + "\"mensagem\":\"Compra realizada\","
                        + "\"produto\":\"" + item.getNome() + "\","
                        + "\"quantidade\":" + quantidade + ","
                        + "\"total\":" + total
                        + "}";
            }

            return "{\"status\":\"erro\",\"mensagem\":\"Ação inválida\"}";
        }

        private String listarProdutosJson() {
            StringBuilder json = new StringBuilder();
            json.append("{\"status\":\"ok\",\"produtos\":[");

            List<ItemVenda> itens = loja.listarItens();

            for (int i = 0; i < itens.size(); i++) {
                ItemVenda item = itens.get(i);

                json.append("{")
                    .append("\"id\":").append(item.getId()).append(",")
                    .append("\"nome\":\"").append(item.getNome()).append("\",")
                    .append("\"preco\":").append(item.getPreco())
                    .append("}");

                if (i < itens.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]}");
            return json.toString();
        }

        private int extrairNumero(String json, String campo) {
            String chave = "\"" + campo + "\":";
            int inicio = json.indexOf(chave) + chave.length();
            int fim = json.indexOf(",", inicio);

            if (fim == -1) {
                fim = json.indexOf("}", inicio);
            }

            return Integer.parseInt(json.substring(inicio, fim).trim());
        }
    }
}
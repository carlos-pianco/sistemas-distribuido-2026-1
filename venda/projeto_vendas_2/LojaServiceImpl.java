import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LojaServiceImpl extends UnicastRemoteObject implements LojaService {
    private static final long serialVersionUID = 1L;

    private List<ItemVenda> itens;

    public LojaServiceImpl() throws RemoteException {
        super();

        itens = new ArrayList<>();

        itens.add(new ProdutoFisico(1, "Perfume Local", 89.90, 0.3));
        itens.add(new ProdutoFisico(2, "Sabonete Artesanal", 12.50, 0.1));
        itens.add(new Servico(3, "Entrega Local", 15.00, 30));
        itens.add(new ProdutoDigital(4, "Catalogo Digital", 9.90, "https://loja.com/catalogo"));
    }

    @Override
    public List<ItemVenda> listarItens() throws RemoteException {
        return itens;
    }

    @Override
    public ItemVenda buscarItem(int id) throws RemoteException {
        for (ItemVenda item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    @Override
    public String comprarItem(int id, int quantidade) throws RemoteException {
        ItemVenda item = buscarItem(id);

        if (item == null) {
            return "Item não encontrado.";
        }

        double total = item.getPreco() * quantidade;

        return "Compra realizada: " + quantidade + "x " + item.getNome()
                + " | Total: R$ " + total;
    }

    @Override
    public double calcularTotal(int id, int quantidade) throws RemoteException {
        ItemVenda item = buscarItem(id);

        if (item == null) {
            return 0;
        }

        return item.getPreco() * quantidade;
    }
}
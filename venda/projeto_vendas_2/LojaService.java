import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LojaService extends Remote {
    List<ItemVenda> listarItens() throws RemoteException;

    ItemVenda buscarItem(int id) throws RemoteException;

    String comprarItem(int id, int quantidade) throws RemoteException;

    double calcularTotal(int id, int quantidade) throws RemoteException;
}
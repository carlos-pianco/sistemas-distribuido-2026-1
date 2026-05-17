import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            LojaService loja = new LojaServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("LojaService", loja);

            System.out.println("Servidor RMI rodando...");
            System.out.println("Objeto remoto registrado como: LojaService");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
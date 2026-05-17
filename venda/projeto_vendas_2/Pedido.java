import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private Cliente cliente;

    private List<ItemVenda> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemVenda item : itens) {
            total += item.getPreco();
        }

        return total;
    }
}
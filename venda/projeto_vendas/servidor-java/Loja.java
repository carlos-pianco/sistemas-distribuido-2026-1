import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<ItemVenda> itens = new ArrayList<>();

    public Loja() {
        itens.add(new ProdutoFisico(1, "Perfume Local", 89.90, 0.3));
        itens.add(new ProdutoFisico(2, "Sabonete Artesanal", 12.50, 0.1));
        itens.add(new Servico(3, "Entrega Local", 15.00, 30));
        itens.add(new ProdutoDigital(4, "Catálogo Digital", 9.90, "https://loja.com/catalogo"));
    }

    public List<ItemVenda> listarItens() {
        return itens;
    }

    public ItemVenda buscarPorId(int id) {
        for (ItemVenda item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
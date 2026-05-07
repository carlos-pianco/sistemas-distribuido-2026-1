
public class ProdutoFisico extends ItemVenda {
    private double peso;

    public ProdutoFisico(int id, String nome, double preco, double peso) {
        super(id, nome, preco);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}

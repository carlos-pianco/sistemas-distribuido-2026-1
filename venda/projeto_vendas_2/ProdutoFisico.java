public class ProdutoFisico extends ItemVenda {
    private static final long serialVersionUID = 1L;

    private double peso;

    public ProdutoFisico(int id, String nome, double preco, double peso) {
        super(id, nome, preco);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}
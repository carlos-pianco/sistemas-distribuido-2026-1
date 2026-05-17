public class Servico extends ItemVenda {
    private static final long serialVersionUID = 1L;

    private int duracaoMinutos;

    public Servico(int id, String nome, double preco, int duracaoMinutos) {
        super(id, nome, preco);
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
}
public class ProdutoDigital extends ItemVenda {
    private static final long serialVersionUID = 1L;

    private String linkDownload;

    public ProdutoDigital(int id, String nome, double preco, String linkDownload) {
        super(id, nome, preco);
        this.linkDownload = linkDownload;
    }

    public String getLinkDownload() {
        return linkDownload;
    }
}
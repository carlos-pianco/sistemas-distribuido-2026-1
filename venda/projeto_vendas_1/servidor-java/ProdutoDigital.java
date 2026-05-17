
public class ProdutoDigital extends ItemVenda {
    private String linkDownload;

    public ProdutoDigital(int id, String nome, double preco, String linkDownload) {
        super(id, nome, preco);
        this.linkDownload = linkDownload;
    }

    public String getLinkDownload() {
        return linkDownload;
    }
}
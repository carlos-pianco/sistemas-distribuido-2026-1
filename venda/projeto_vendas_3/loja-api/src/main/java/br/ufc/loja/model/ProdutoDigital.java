package br.ufc.loja.model;

public class ProdutoDigital extends ItemVenda {

    private String linkDownload;

    public ProdutoDigital() {
    }

    public ProdutoDigital(
            int id,
            String nome,
            double preco,
            String linkDownload,
            String imagem) {

        super(id, nome, preco, imagem);
        this.linkDownload = linkDownload;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }
}
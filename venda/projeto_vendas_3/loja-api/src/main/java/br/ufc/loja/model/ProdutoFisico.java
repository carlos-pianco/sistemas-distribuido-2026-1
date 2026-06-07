package br.ufc.loja.model;

public class ProdutoFisico extends ItemVenda {

    private double peso;

    public ProdutoFisico() {
    }

    public ProdutoFisico(
            int id,
            String nome,
            double preco,
            double peso,
            String imagem) {

        super(id, nome, preco, imagem);

        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
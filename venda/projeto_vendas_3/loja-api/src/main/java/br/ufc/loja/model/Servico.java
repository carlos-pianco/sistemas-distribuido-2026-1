package br.ufc.loja.model;

public class Servico extends ItemVenda {

    private int duracaoMinutos;

    public Servico() {
    }

    public Servico(
            int id,
            String nome,
            double preco,
            int duracaoMinutos,
            String imagem) {

        super(id, nome, preco, imagem);

        this.duracaoMinutos = duracaoMinutos;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}
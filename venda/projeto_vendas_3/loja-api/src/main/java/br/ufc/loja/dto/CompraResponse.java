package br.ufc.loja.dto;

public class CompraResponse {

    private String mensagem;
    private double total;

    public CompraResponse() {
    }

    public CompraResponse(String mensagem, double total) {
        this.mensagem = mensagem;
        this.total = total;
    }

    public String getMensagem() {
        return mensagem;
    }

    public double getTotal() {
        return total;
    }
}
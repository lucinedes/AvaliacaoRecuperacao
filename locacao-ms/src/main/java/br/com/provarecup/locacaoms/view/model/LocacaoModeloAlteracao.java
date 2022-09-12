package br.com.provarecup.locacaoms.view.model;

public class LocacaoModeloAlteracao {

    private String idVeículo;
    private String idCliente;
    private String numDiasLocacao;
    
    public String getIdVeículo() {
        return idVeículo;
    }
    public void setIdVeículo(String idVeículo) {
        this.idVeículo = idVeículo;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getNumDiasLocacao() {
        return numDiasLocacao;
    }
    public void setNumDiasLocacao(String numDiasLocacao) {
        this.numDiasLocacao = numDiasLocacao;
    }
    @Override
    public String toString() {
        return "LocacaoModeloAlteracao [idCliente=" + idCliente + ", idVeículo=" + idVeículo + ", numDiasLocacao="
                + numDiasLocacao + "]";
    }

}
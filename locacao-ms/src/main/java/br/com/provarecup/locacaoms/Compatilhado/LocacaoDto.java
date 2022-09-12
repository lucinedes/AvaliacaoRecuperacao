package br.com.provarecup.locacaoms.Compatilhado;

public class LocacaoDto {
    
    private String idLocaçao;
    private String idVeículo;
    private String idCliente;
    private String numDiasLocacao;
    
    public String getIdLocaçao() {
        return idLocaçao;
    }
    
    public void setIdLocaçao(String idLocaçao) {
        this.idLocaçao = idLocaçao;
    }
    
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
        return "Locacao [idCliente=" + idCliente + ", idLocaçao=" + idLocaçao + ", idVeículo=" + idVeículo
                + ", numDiasLocacao=" + numDiasLocacao + "]";
    }

    public void setId(String id) {
    }
    
    }
    
package br.com.provarecup.locacaoms.model;

public class Locacao {
   
private String idLocaçao;
private String idVeículo;
private String idCliente;
private String numDiasLocacao;

public Locacao(String idLocaçao, String idVeículo, String idCliente, String numDiasLocacao) {
    this.idLocaçao = idLocaçao;
    this.idVeículo = idVeículo;
    this.idCliente = idCliente;
    this.numDiasLocacao = numDiasLocacao;
}

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

}

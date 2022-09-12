package br.com.provarecup.locacaoms.view.model;

public class VeiculoModeloAlteracao {

    private String id;
    private String modelo;
    private int numPassageiro;
    private double valorLocacaoDia;
    private String tipoCombustivel;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getNumPassageiro() {
        return numPassageiro;
    }
    public void setNumPassageiro(int numPassageiro) {
        this.numPassageiro = numPassageiro;
    }
    public double getValorLocacaoDia() {
        return valorLocacaoDia;
    }
    public void setValorLocacaoDia(double valorLocacaoDia) {
        this.valorLocacaoDia = valorLocacaoDia;
    }
    public String getTipoCombustivel() {
        return tipoCombustivel;
    }
    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
    
}

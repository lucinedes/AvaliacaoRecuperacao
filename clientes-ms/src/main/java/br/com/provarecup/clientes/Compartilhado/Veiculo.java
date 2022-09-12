package br.com.provarecup.clientes.Compartilhado;

public class Veiculo {

    private String id;
    private String marca;
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
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
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

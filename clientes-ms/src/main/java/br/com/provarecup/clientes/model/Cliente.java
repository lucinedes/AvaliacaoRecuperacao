package br.com.provarecup.clientes.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("cliente")
public class Cliente {

private String id;
private String nome;
private String cpf;
private int numero;
private String cnh;
private String dataNascimento;

public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getCpf() {
    return cpf;
}
public void setCpf(String cpf) {
    this.cpf = cpf;
}
public int getNumero() {
    return numero;
}
public void setNumero(int numero) {
    this.numero = numero;
}
public String getCnh() {
    return cnh;
}
public void setCnh(String cnh) {
    this.cnh = cnh;
}
public String getDataNascimento() {
    return dataNascimento;
}
public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
}

}

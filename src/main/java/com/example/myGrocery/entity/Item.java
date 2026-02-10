package com.example.myGrocery.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "estoque")
    private int estoque;

    @Column(name = "preco")
    private BigDecimal preco;

    public Item(){}

    public Item(String nome, int estoque, BigDecimal preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estoque=" + estoque +
                ", preco=" + preco +
                '}';
    }
}

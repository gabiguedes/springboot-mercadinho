package desafio.happe.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "valor")
    private Double valor;

    public Produtos() {
    }

    public Produtos(Integer id, String nomeProduto, Double valor) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }

    @ManyToMany
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return Objects.equals(id, produtos.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

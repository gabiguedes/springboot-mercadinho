package desafio.happe.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "alimentos")
    private String alimentos;

    @Column(name = "limpeza")
    private String limpeza;

    @Column(name = "bebidas")
    private String bebidas;

    @Column(name = "congelados")
    private String congelados;

    @Column(name = "confeitaria")
    private String confeitaria;

    @Column(name = "acougue")
    private String acougue;

    public Categoria() {
    }

    public Categoria(Integer id, String alimentos, String limpeza, String bebidas, String congelados,
                     String confeitaria, String acougue) {

            this.id = id;
            this.alimentos = alimentos;
            this.limpeza = limpeza;
            this.bebidas = bebidas;
            this.congelados = congelados;
            this.confeitaria = confeitaria;
            this.acougue = acougue;
    }

    @JsonIgnore
    @OneToMany(mappedBy="categoria")
    private List<Produtos> produtos = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(String alimentos) {
        this.alimentos = alimentos;
    }

    public String getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(String limpeza) {
        this.limpeza = limpeza;
    }

    public String getBebidas() {
        return bebidas;
    }

    public void setBebidas(String bebidas) {
        this.bebidas = bebidas;
    }

    public String getCongelados() {
        return congelados;
    }

    public void setCongelados(String congelados) {
        this.congelados = congelados;
    }

    public String getConfeitaria() {
        return confeitaria;
    }

    public void setConfeitaria(String confeitaria) {
        this.confeitaria = confeitaria;
    }

    public String getAcougue() {
        return acougue;
    }

    public void setAcougue(String acougue) {
        this.acougue = acougue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

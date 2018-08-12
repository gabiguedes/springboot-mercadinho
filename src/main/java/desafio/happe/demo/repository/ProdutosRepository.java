package desafio.happe.demo.repository;

import desafio.happe.demo.entity.Categoria;
import desafio.happe.demo.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    List<Produtos> findByCategoria(Categoria categoria);
}

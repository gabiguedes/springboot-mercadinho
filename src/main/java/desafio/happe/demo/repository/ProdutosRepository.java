package desafio.happe.demo.repository;

import desafio.happe.demo.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}

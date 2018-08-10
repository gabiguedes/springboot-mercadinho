package desafio.happe.demo.repository;

import desafio.happe.demo.entity.Produtos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends CrudRepository<Produtos, Long> {

}

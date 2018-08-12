package desafio.happe.demo.service;

import desafio.happe.demo.entity.Categoria;
import desafio.happe.demo.entity.Produtos;
import desafio.happe.demo.repository.ProdutosRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    ProdutosRepository produtosRepository;

    @Autowired
    CategoriaService categoriaService;

    public List<Produtos> findAll() {
        return produtosRepository.findAll();
    }

    public List<Produtos> findAllByCategoria(Long id) {
        Categoria categoria= categoriaService.findById(id);
        return  produtosRepository.findByCategoria(categoria);
    }

    public Produtos findById(Long id) {
        Optional<Produtos> obj = produtosRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(1L, "Produtos"));
    }
}

package desafio.happe.demo.service;

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

    public List<Produtos> findAll() {
        return (List<Produtos>) produtosRepository.findAll();
    }

    public Produtos findById(Long id) {
        Optional<Produtos> obj = produtosRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(1L, "Produtos"));
    }
}

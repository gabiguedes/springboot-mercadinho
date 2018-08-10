package desafio.happe.demo.service;

import desafio.happe.demo.entity.Produtos;
import desafio.happe.demo.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutosRepository produtosRepository;

    public List<Produtos> findAll() {
        return (List<Produtos>) produtosRepository.findAll();
    }
}
